package controllers;

import models.Restapi;
import views.MainConsole;

public class MainController {
    MainConsole mainConsole;
    Restapi restapi;

    public MainController(){
        this.restapi = new Restapi();
        this.mainConsole = new MainConsole(this.restapi);
    }
}
