package io.github.theguy191919.customdoc.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StructuralPropertyDescriptor;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.internal.core.dom.rewrite.RewriteEventStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.TextEditGroup;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class CompilationEditor {
	
	public static IProject getCurrentProject() {
		IProject project = null;
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor != null) {
			IEditorInput input = editor.getEditorInput();
			project = input.getAdapter(IProject.class);
			if (project == null) {
				IResource resource = input.getAdapter(IResource.class);
				if (resource != null) {
					project = resource.getProject();
				}
			}
		}
		return project;
	}
	
	private static CompilationUnit parse(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		return (CompilationUnit) parser.createAST(null);
	}
	
	public static void insertTemplate() {
		IProject project = getCurrentProject();
		try {
			if (project == null || !project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {
				return;
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
//		System.out.println("Project: " + project.getName());
		try {
			IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
	        for (IPackageFragment mypackage : packages) {
	        	if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
//	        		System.out.println("Package: " + mypackage.getElementName());
	        		for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
	        			CompilationEditor.insertTemplate(unit);
	        		}
	        	}

	        }	
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertTemplate(ICompilationUnit compileUnit) {
		CompilationUnit parse = parse(compileUnit);
		AST ast = parse.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		
		//System.out.println("Running");
		ClassVisitor classV = new ClassVisitor();
		parse.accept(classV);
		for (TypeDeclaration type : classV.getClasses()) {
			//System.out.println("Loop");
//			System.out.println(this.generateClassTemplate(type));

			ListRewrite listRewrite = rewriter.getListRewrite(type, TypeDeclaration.BODY_DECLARATIONS_PROPERTY);
			ASTNode placeHolder = rewriter.createStringPlaceholder(generateComment(generateClassTemplate(type)), ASTNode.BLOCK_COMMENT);
			listRewrite.insertFirst(placeHolder, null);
			
			for (MethodDeclaration md : type.getMethods()) {
				if (!md.isConstructor()) {
//					System.out.println(this.generateMethodTemplate(md));
					if (md.getBody() != null) {
						ListRewrite listRewriteMethod = rewriter.getListRewrite(md.getBody(), Block.STATEMENTS_PROPERTY);
						ASTNode placeHolderMethod = rewriter.createStringPlaceholder(generateComment(generateMethodTemplate(md)), ASTNode.BLOCK_COMMENT);
						listRewriteMethod.insertFirst(placeHolderMethod, null);
					}
				}
			}
		}

		
		try {
			TextEdit edits = rewriter.rewriteAST();
			Document document = new Document(compileUnit.getSource());
			edits.apply(document);
			compileUnit.getBuffer().setContents(document.get());
		} catch (JavaModelException | IllegalArgumentException | MalformedTreeException | BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	private static String generateClassTemplate(TypeDeclaration typeDeclaration) {
		StringBuilder sb = new StringBuilder();
		List<String> methodOnField = new ArrayList<>();
		sb.append("Class Template for class " + typeDeclaration.getName().getIdentifier() + "\n");
		sb.append("Field" + "\n");
		if (typeDeclaration.getFields().length == 0) {
			sb.append("\tNothing\n");
		}
		for (FieldDeclaration fd : typeDeclaration.getFields()) {
			for (Object ob : fd.fragments()) {
				VariableDeclarationFragment vdf = (VariableDeclarationFragment) ob;
				sb.append("\tthis." + vdf.getName() + " - " + fd.getType() + "\n");
				if (fd.getType().resolveBinding().getDeclaredMethods() != null) {
					for (IMethodBinding mb : fd.getType().resolveBinding().getDeclaredMethods()) {
						if (!mb.isConstructor()) {
							String param = "(";
							for (ITypeBinding tb : mb.getParameterTypes()) {
								param += tb.getName() + ", ";
							}
							if (mb.getParameterTypes().length != 0) {
								param = param.substring(0, param.length() - 2);
							}
							param += ")";
							methodOnField.add("\tthis." + vdf.getName() + "." + mb.getName() + param + " - " + mb.getReturnType().getName());
						}
					}
				}
			}
			
		}
		sb.append("Method" + "\n");
		if (typeDeclaration.getMethods().length == 0) {
			sb.append("\tNothing\n");
		}
		for (MethodDeclaration md : typeDeclaration.getMethods()) {
			if (md.getReturnType2() != null && !md.isConstructor()) {
				String param = md.typeParameters().toString().replaceAll("\\[", "(").replaceAll("\\]", ")");
				sb.append("\tthis." + md.getName() + param + " - " + md.getReturnType2() + "\n");
			}
		}
		sb.append("Method on field" + "\n");
		if (methodOnField.isEmpty()) {
			sb.append("\tNothing\n");
		}
		for (String str : methodOnField) {
			sb.append(str + "\n");
		}
		return sb.toString();
	}
	
	private static String generateMethodTemplate(MethodDeclaration methodDeclaration) {
		List<String> methodOnField = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("Everything in the class template plus:\n");
		sb.append("Params\n");
		for (Object object : methodDeclaration.parameters()) {
			SingleVariableDeclaration svd = (SingleVariableDeclaration) object;
			sb.append("\t" + svd.getName() + " - " + svd.getType() + "\n");
			if (svd.getType().resolveBinding().getDeclaredMethods() != null) {
				for (IMethodBinding mb : svd.getType().resolveBinding().getDeclaredMethods()) {
					if (!mb.isConstructor()) {
						String param = "(";
						for (ITypeBinding tb : mb.getParameterTypes()) {
							param += tb.getName() + ", ";
						}
						if (mb.getParameterTypes().length != 0) {
							param = param.substring(0, param.length() - 2);
						}
						param += ")";
						methodOnField.add("\t" + svd.getName() + "." + mb.getName() + param + " - " + mb.getReturnType().getName());
					}
				}
			}
		}
		if (methodDeclaration.parameters().isEmpty()) {
			sb.append("\tNothing\n");
		}
		
		sb.append("Method on Params\n");
		for (String str : methodOnField) {
			sb.append(str + "\n");
		}
		if (methodOnField.isEmpty()) {
			sb.append("\tNothing\n");
		}
		return sb.toString();
	}
	
	private static String generateComment(String str) {
		str = str.replaceAll("\\n", "\n * ");
		str = str.replaceAll("\\t", "  ");
		return "  /*" + str + "\n */";
	}
	
	public static void removeTemplate() {
		IProject project = getCurrentProject();
		try {
			if (project == null || !project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {
				return;
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		try {
			IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
	        for (IPackageFragment mypackage : packages) {
	        	if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
	        		for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
	        			CompilationEditor.removeTemplate(unit);
	        		}
	        	}
	
	        }	
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
//		IProject project = getCurrentProject();
//		try {
//			if (project == null || !project.isNatureEnabled("org.eclipse.jdt.core.javanature")) {
//				return;
//			}
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
////		System.out.println("Project: " + project.getName());
//		try {
//			IPackageFragment[] packages = JavaCore.create(project).getPackageFragments();
//	        for (IPackageFragment mypackage : packages) {
//	        	if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
////	        		System.out.println("Package: " + mypackage.getElementName());
//	        		for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
//	        			CompilationEditor.removeTemplate(unit);
//	        		}
//	        	}
//
//	        }	
//		} catch (JavaModelException e) {
//			e.printStackTrace();
//		}
	}
	
	private static boolean containCommentBeginningWith(String str, String beginning) {
		int beginningIndex = str.indexOf("/*" + beginning);
		if (beginningIndex == -1) {
			return false;
		}
		int endingIndex = str.indexOf("*/", beginningIndex);
		if (endingIndex == -1) {
			return false;
		}
		return true;
	}
	
	private static String removeFirstCommentBeginningWith(String str, String beginning, String replacement) {
		if (!containCommentBeginningWith(str, beginning)) {
			return str;
		}
		int beginningIndex = str.indexOf("/*" + beginning);
		int endingIndex = str.indexOf("*/", beginningIndex);
		String beginningSection = str.substring(0, beginningIndex);
		String endingSection = str.substring(endingIndex + 2, str.length());
		if (endingSection.startsWith("\n")) {
			endingSection = endingSection.substring(endingSection.indexOf("\n") + 1);
		}
		if (beginningSection.substring(beginningSection.lastIndexOf("\n")).trim().equals("")) {
			beginningSection = beginningSection.substring(0, beginningSection.lastIndexOf("\n"));
		}
		return beginningSection + replacement + endingSection;
	}
	
	public static void removeTemplate(ICompilationUnit compileUnit) {
		try {
			String out = compileUnit.getSource();
			while (containCommentBeginningWith(out, "Class Template for class ")) {
				out = removeFirstCommentBeginningWith(out, "Class Template for class ", "");
			}
			while (containCommentBeginningWith(out, "Everything in the class template plus:")) {
				out = removeFirstCommentBeginningWith(out, "Everything in the class template plus:", "\n");
			}
			compileUnit.getBuffer().setContents(out);
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
