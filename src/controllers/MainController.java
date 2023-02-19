/*
* File: MainController.java
* Author: Sánta Renáta Diána
* Copyright: 2023, Sánta Renáta Diána
* Group: Szoft II N
* Date: 2023-02-19
* Github: https://github.com/SantaRenata/
* Licenc: GNU GPL
*/


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
