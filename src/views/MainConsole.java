/*
* File: MainConsole.java
* Author: Sánta Renáta Diána
* Copyright: 2023, Sánta Renáta Diána
* Group: Szoft II N
* Date: 2023-02-19
* Github: https://github.com/SantaRenata/
* Licenc: GNU GPL
*/

package views;

import java.util.ArrayList;

import models.Property;
import models.Restapi;

public class MainConsole {
    Restapi restapi;

    public MainConsole(Restapi restapi) {
        this.restapi = restapi;
        this.start();
    }

    public void start(){
        System.out.printf("___________________Ingatlanok__________________\n");
        System.out.printf("|%10s|%20s|%6s|%6s","Város","Cím","Méret","    Ár|\n");
        ArrayList<Property> properties = this.restapi.getProperties();
        for(Property property: properties){
            System.out.printf("|%10s|%20s|%6.0f|%6.0f|\n",
            property.city,
            property.address,
            property.size,
            property.price
            );
        }
    }
    
}
