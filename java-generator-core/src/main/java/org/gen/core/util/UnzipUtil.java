package org.gen.core.util;

import java.io.*;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by douglas on 05/12/16.
 */
public class UnzipUtil {

    /**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;

    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     *
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public Queue<Object> unzip(String zipFilePath, String destDirectory) throws IOException {

//        File destDir = new File(destDirectory);
//        if (!destDir.exists()) {
//            destDir.mkdir();
//        }

        //Queue<Object> zipContent = new

        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();

        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (entry.isDirectory()) {

            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
        return null;
    }

    /**
     * Extracts a zip entry (file entry)
     *
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}
