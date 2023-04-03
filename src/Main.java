import java.io.*;
import java.util.Arrays;
import java.util.List;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> dirs = Arrays.asList(
                new File("C:/Users/Пользователь/Desktop/Games/temp"),
                new File("C:/Users/Пользователь/Desktop/Games/src"),
                new File("C:/Users/Пользователь/Desktop/Games/res"),
                new File("C:/Users/Пользователь/Desktop/Games/savegames"),
                new File("C:/Users/Пользователь/Desktop/Games/src/main"),
                new File("C:/Users/Пользователь/Desktop/Games/src/test"),
                new File("C:/Users/Пользователь/Desktop/Games/res/drawables"),
                new File("C:/Users/Пользователь/Desktop/Games/res/vectors"),
                new File("C:/Users/Пользователь/Desktop/Games/res//icons")
        );
        List<File> files = Arrays.asList(
                new File("C:/Users/Пользователь/Desktop/Games/src/main/Main.java"),
                new File("C:/Users/Пользователь/Desktop/Games/src/main/Utils.java"),
                new File("C:/Users/Пользователь/Desktop/Games/temp/temp.txt")
        );
        dirs.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Создана директория " + folder + "\n");
            else sb.append("!!!ОШИБКА!!! Директория " + folder + " не создана\n");
        });
        files.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Создан файл " + file + "\n");
                else sb.append("!!!ОШИБКА!!! Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("C:/Users/Пользователь/Desktop/Games/temp/temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Пользователь/Desktop/Games/temp/temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}