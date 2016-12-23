package org.gen.core.commands;

import org.gen.core.CommandBase;

import java.io.File;

/**
 * Created by douglas on 05/12/16.
 */
public class CreateFolderCommand implements CommandBase {

    private String path;

    public CreateFolderCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    @Override
    public void undo() {
        File folder = new File(path);
        if (folder.exists()) {
            folder.delete();
        }
    }
}
