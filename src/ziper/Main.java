package ziper;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Что архивируем?");
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
             String str = reader.readLine();
             Path path = Paths.get(str);
             if (!Files.exists(path)) throw new RuntimeException("Нет файло с таким путем!");
             if (str.endsWith(".zip")) throw new RuntimeException("Файл уже заархивирован!");
             try (ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(path.toFile()))){
                 if (Files.isDirectory(path)){
                     zipDir(path,outputStream);
                 }else{
                    // zipFile(path,outputStream);
                 }
             }
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }

    private static void zipDir (Path path, ZipOutputStream outputStream){
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
