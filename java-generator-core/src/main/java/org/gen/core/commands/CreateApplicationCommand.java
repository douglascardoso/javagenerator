package org.gen.core.commands;

import org.gen.core.CommandBase;
import org.gen.core.beans.Application;

/**
 * Created by douglas on 05/12/16.
 */

public class CreateApplicationCommand implements CommandBase {

    private Application application;

    public CreateApplicationCommand(Application application) {
        this.application = application;
    }

    @Override
    public void execute() {



    }

    @Override
    public void undo() {

    }
}
