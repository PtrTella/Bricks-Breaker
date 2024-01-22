package brickbreaker.common;

/**
 * Enum of error types.
 * Each Error have a string error message.
 */
public enum Error {

    /** Map load error. */
    MAPLOADER_ERROR("Map not loaded correctly"),
    /** Rank load error. */
    RANKLOADER_ERROR("Ranking not loaded correctly"),
    /** Rank write error. */
    RANKWRITER_ERROR("Ranking not writed correctly"),
    /** Rank load error. */
    USERLOADER_ERROR("User not loaded correctly"),
    /** User write error. */
    USERWRITER_ERROR("User not writed correctly"),
    /** Image load error. */
    LOAD_IMAGE_ERROR("Image not loaded correctly");


    private final String message;
    Error(final String m) {
        this.message = m;
    }

    /**
     * @return the error message as a String
     */
    public String getMessage() {
        return "Error: " + this.message;
    }
}
