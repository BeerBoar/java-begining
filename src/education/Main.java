package education;


/*
C:\Users\Veniol\Desktop\MyDir
C:\Users\Veniol\Desktop\MyDir\result.txt
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        File path = new File("C:\\Users\\Veniol\\Desktop\\MyDir");
        File resultFileAbsolutePath = new File("C:\\Users\\Veniol\\Desktop\\MyDir\\result.txt");
        String newFileName = path.getAbsolutePath() + "\\allFilesContent.txt";
        File newFile = new File(newFileName);
        if (!FileUtils.isExist(newFile)) {
            FileUtils.renameFile(resultFileAbsolutePath, newFile);
        }

        SearchFiles searchFiles = new SearchFiles();
        Files.walkFileTree(path.toPath(), searchFiles);
        ArrayList<Path> list = searchFiles.list;
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            for (Path p:list) {
                try (FileInputStream fileInputStream = new FileInputStream(p.toFile())) {
                    fileInputStream.transferTo(fileOutputStream);
                    fileOutputStream.write("\n".getBytes());
                    fileOutputStream.flush();
                }
            }
        }
    }

    public static class SearchFiles extends SimpleFileVisitor<Path> {
        ArrayList<Path> list = new ArrayList<>();

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (attrs.size() <= 50) {
                list.add(file);
            }
            return super.visitFile(file, attrs);
        }
    }

    public static class FileUtils {

        public static void deleteFile(File file) {
            if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
        }

        public static void renameFile(File source, File destination) {
            if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
        }

        public static boolean isExist(File file) {
            return file.exists();
        }
    }
}
