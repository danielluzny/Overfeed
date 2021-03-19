package comp3350.overfeed.domainObjects;

import java.io.Serializable;

public class Achievement implements Serializable {

    private String name;
    private String description;
    private boolean value;

    public Achievement(String name, String desc){
        this.name = name;
        this.description = desc;
        this.value = false;
    }

    public void setValue(){
        this.value = true;
    }

    public String getName(){
        return this.name;
    }

    public String getDesc(){
        return this.description;
    }

    public boolean getValue(){
        return this.value;
    }

}
