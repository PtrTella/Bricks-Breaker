package main.model.gameObjects;

import java.util.List;
import java.util.stream.Stream;

public enum TypePower {
    
    NULL(0.0,"NULL"),
    LONGBAR(10.0,"POSITIVE"),
    SHORTBAR(10.0,"NEGATIVE");

    public final Double timeAmount;
    public final String type;

    private TypePower(Double time, String typePower) {
        this.timeAmount = time;
        this.type = typePower;
    }

    public static List<TypePower> getElement(String type){
        return Stream.of(TypePower.values()).filter(t -> t.type.equals(type)).toList();
    }

    public static void printAll() {
        for (TypePower e: values()) {
            System.out.println(e + "  " + e.timeAmount + " " + e.type);
        }
    }
}
