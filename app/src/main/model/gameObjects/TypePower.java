package main.model.gameObjects;

import java.util.List;
import java.util.stream.Stream;

import main.model.WorldImpl.TypeObj;

public enum TypePower {
    
    NULL(0.0,"NULL", TypeObj.POWERUP),
    SLOWBALL(10.0,"POSITIVE", TypeObj.BALL),
    FASTBALL(10.0,"NEGATIVE", TypeObj.BALL),
    LONGBAR(10.0,"POSITIVE", TypeObj.BAR),
    SHORTBAR(10.0,"NEGATIVE", TypeObj.BAR);

    public final Double timeAmount;
    public final String type;
    public final TypeObj affectedType;

    private TypePower(final Double time, final String typePower, final TypeObj affType) {
        this.timeAmount = time;
        this.type = typePower;
        this.affectedType = affType;
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
