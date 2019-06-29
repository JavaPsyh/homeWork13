package tasks.deserialization;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class DeserializeAnimalArray {
    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals;
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(
                             new ByteArrayInputStream(data))) {
            int length = objectInputStream.readInt();
            animals = new Animal[length];
            for (int i = 0; i < length; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return animals;
    }
}
