package io.github.theguy191919.customdoc.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class FieldMethodVisitor extends ASTVisitor {

    List<MethodDeclaration> methods = new ArrayList<>();
    List<FieldDeclaration> fields = new ArrayList<>();
    
	@Override
	public boolean visit(MethodDeclaration method) {
		this.methods.add(method);
		return true;
	}
    
	@Override
	public boolean visit(FieldDeclaration field) {
		this.fields.add(field);
		return true;
	}

    public List<MethodDeclaration> getMethods() {
        return methods;
    }

    public List<FieldDeclaration> getFields() {
        return fields;
    }

}
