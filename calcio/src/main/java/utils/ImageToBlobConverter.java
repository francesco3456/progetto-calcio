package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageToBlobConverter {

    public static byte[] convertFileContentToBlob(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] fileContent = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(fileContent);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return fileContent;
    }
}

