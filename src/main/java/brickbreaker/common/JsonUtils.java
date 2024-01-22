package brickbreaker.common;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Class to load and save JSON files.
 */
public class JsonUtils {

    private static final String DEFAULT_DATA = "data/";

    /**
     * Load a JSON file from the given filepath and convert it to the given type.
     * The method use ClassLoader.getSystemResourceAsStream to load the file.
     * It loads the file from the resources folder.
     * 
     * @param <E>      the type of the object to load
     * @param type     the type of the object to load
     * @param filepath the path of the JSON file
     * @return the object loaded from the JSON file
     */
    public static <E> E load(Type type, String filepath) {
        // Carica il file JSON come stream di input
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(filepath);
        if (inputStream != null) {
            // Crea un InputStreamReader per leggere il contenuto del file JSON
            InputStreamReader reader = new InputStreamReader(inputStream);
            Gson gson = new Gson();
            return gson.fromJson(reader, type);

        } else {
            System.out.println("File not found");
            return null;
        }
    }

    /**
     * Load a JSON file from the given filepath and convert it to the given type.
     * The method use FileReader to load the file.
     * It loads the file from the root folder outside the jar.
     * 
     * @param <E>      the type of the object to load
     * @param type     the type of the object to load
     * @param filePath the path of the JSON file
     * @return the object loaded from the JSON file
     */
    public static <E> E loadData(final Type type, final String filePath) {

        try (FileReader fileReader = new FileReader(filePath)) {
            Gson gson = new Gson();
            return gson.fromJson(fileReader, type);
        } catch (IOException e) {
            return JsonUtils.load(type, DEFAULT_DATA + filePath);
        }
    }

    /**
     * Save a list of objects into a JSON file.
     * The method use FileWriter to save the file.
     * It saves the file from the root folder outside the jar.
     * 
     * @param <E>      the type of the object to save
     * @param data     the list of objects to save
     * @param filePath the path of the JSON file
     */
    public static <E> void saveData(final List<E> data, final String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(data);

            fileWriter.write(json);
            System.out.println("Saving Data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
