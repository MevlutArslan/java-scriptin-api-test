package com.company;

import java.util.ArrayList;
import java.util.List;

public class Entity {

    private List<Component> components = new ArrayList();
    private String name;

    public Entity(String name){
        this.name = name;
    }

    public void addComponent(Component component){
        for(int i = 0; i < components.size(); i++){
            Component c = components.get(i);
            if(c.getClass() == component.getClass()){
                return;
            }
        }
        components.add(component);
    }

//    public void removeComponent(Class<T> componentClass){
//        for(int i = 0; i < components.size(); i++){
//            Component c = components.get(i);
//            if(c.getClass() == componentClass){
//                components.remove(c);
//            }
//        }
//    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
