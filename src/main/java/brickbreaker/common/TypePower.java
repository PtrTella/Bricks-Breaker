package brickbreaker.common;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum of type PowerUp.
 * Each powerUp have a duration and a type.
 */
public enum TypePower {

    /** Null. */
    NULL(0, TypePowerUp.NULL),

    /** FastBall. */
    FASTBALL(10, TypePowerUp.POSITIVE),
    /** SlowBall. */
    SLOWBALL(10, TypePowerUp.NEGATIVE),
    /** LongBar. */
    LONGBAR(10, TypePowerUp.POSITIVE),
    /** ShortBar. */
    SHORTBAR(10, TypePowerUp.NEGATIVE),

    /** Score increase. */
    INC_50(-1, TypePowerUp.POSITIVE),
    /** Score increase. */
    INC_100(-1, TypePowerUp.POSITIVE),
    /** Score increase. */
    INC_250(-1, TypePowerUp.POSITIVE),
    /** Score increase. */
    INC_500(-1, TypePowerUp.POSITIVE),

    /** Score decrease. */
    DEC_50(-1, TypePowerUp.NEGATIVE),
    /** Score decrease. */
    DEC_100(-1, TypePowerUp.NEGATIVE),
    /** Score decrease. */
    // DEC_250(-1, TypePowerUp.NEGATIVE),
    /** Score decrease. */
    // DEC_500(-1, TypePowerUp.NEGATIVE),

    /** Life increese. */
    LIFE_INC(-1, TypePowerUp.POSITIVE),

    /** Multi ball. */
    MULTIBALL(-1, TypePowerUp.POSITIVE),

    /** Indestructible brick. */
    INDBRICK(5, TypePowerUp.NEGATIVE),

    /** SlowBall. */
    BIGBALL(10, TypePowerUp.POSITIVE),
    /** FastBall. */
    SMALLBALL(10, TypePowerUp.NEGATIVE);

    private final Integer duration;
    private final TypePowerUp type;

    /**
     * TypePower constructor.
     * 
     * @param time      duration
     * @param typePower type
     */
    TypePower(final Integer time, final TypePowerUp typePower) {
        this.duration = time;
        this.type = typePower;
    }

    /**
     * This method returns a list of positive or negative powerUp type.
     * 
     * @param typePass type of powerUp
     * @return a list of powerUp type
     */
    public static List<TypePower> getElement(final TypePowerUp typePass) {
        return Stream.of(TypePower.values()).filter(t -> t.type.equals(typePass)).collect(Collectors.toList());
    }

    /**
     * @return the duration of the powerUp
     */
    public Integer getDuration() {
        return this.duration * 100;
    }

    /**
     * @return the type of the powerUp
     */
    public TypePowerUp getType() {
        return this.type;
    }
}
