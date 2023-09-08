package Main;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\";  //set the path
        File currentFile = new File(path);
        ArrayList<File> allFiles = new ArrayList();
        allFiles.add(currentFile);

        boolean active = true;
        if (currentFile.exists()) {
            do {
                File aux = null;
                for (File listFile : currentFile.listFiles()) {
                    if (!allFiles.contains(listFile)) {
                        allFiles.add(listFile);
                        if (listFile.isDirectory()) {
                            aux = listFile;
                            break;
                        }
                    }
                }

                if (aux != null) {
                    currentFile = aux;
                } else {
                    if (!currentFile.getPath().equals(path)) {
                        currentFile = currentFile.getParentFile();
                    } else {
                        active = false;
                        for (File listFile : new File(path).listFiles()) {
                            if (!allFiles.contains(listFile)) {
                                active = true;
                            }
                        }
                    }
                }
            } while (active);

            for (File _file : allFiles) {
                System.out.println(_file);
            }
        } else {
            System.out.println("Error: File Not Found!");
        }

    }

}
