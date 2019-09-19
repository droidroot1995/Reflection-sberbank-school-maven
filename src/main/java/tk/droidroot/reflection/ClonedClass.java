package tk.droidroot.reflection;

import java.io.Serializable;

public class ClonedClass implements Serializable {
    private String name;

    public ClonedClass(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
