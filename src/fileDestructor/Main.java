package fileDestructor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/*
C:\Users\Veniol\Desktop\dest.txt
C:\Users\Veniol\Desktop\Че.PNG
*/

public class Main {
    private static final byte KEY = (byte) 25022023;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Target?");
            Path path = Paths.get(reader.readLine());
            System.out.println("What will we do?");
            switch (reader.readLine()) {
                case "d" -> incrypt(path, KEY);
                case "r" -> incrypt(path, (byte) (-1 * KEY));
            }
            System.out.println("Job is done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void incrypt(Path path, byte key) throws IOException {
        byte[] arr = Files.readAllBytes(path);
        byte[] tmp = new byte[arr.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = (byte) (arr[i] + key);
        }
        try (BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(tmp));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path.toFile()))) {
            in.transferTo(out);
        }
    }
}
