package io.github.theguy191919.customdoc.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class ClassVisitor extends ASTVisitor {

    List<TypeDeclaration> types = new ArrayList<>();
    
	@Override
	public boolean visit(TypeDeclaration type) {
		this.types.add(type);
		return true;
	}

    public List<TypeDeclaration> getClasses() {
        return types;
    }
}
