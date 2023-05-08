package brickbreaker.model.gameObjects.power;

import java.util.List;
import java.util.stream.Stream;

public enum TypePower {
    
    NULL(0.0,"NULL"),
    SLOWBALL(10.0,"POSITIVE"),
    FASTBALL(10.0,"NEGATIVE"),
    LONGBAR(10.0,"POSITIVE"),
    SHORTBAR(10.0,"NEGATIVE");

    public final Double timeAmount;
    public final String type;

    private TypePower(final Double time, final String typePower) {
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
