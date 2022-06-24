package dataAccess;

import java.io.*;

public class Serializator {

    public static Object deserialize(String fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            Object o = in.readObject();
            file.close();
            in.close();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static void serialize(Object t, String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(t);
            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}