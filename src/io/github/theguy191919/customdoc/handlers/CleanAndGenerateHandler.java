package io.github.theguy191919.customdoc.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class CleanAndGenerateHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CompilationEditor.removeTemplate();
		CompilationEditor.insertTemplate();
		return null;
	}

}
