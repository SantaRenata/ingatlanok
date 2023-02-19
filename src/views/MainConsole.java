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
