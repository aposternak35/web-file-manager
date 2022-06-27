package org.aposternak35.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFile {
    private File file;
    private String name;
    private String path;
    private String size;
    private String dateCreate;
    private String dateUpdate;
    private boolean isDirectory;

    public MyFile(File file) throws IOException {
        this.file = file;
        this.name = file.getName();
        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        this.dateUpdate = basicFileAttributes.lastModifiedTime().toString().substring(0, 19).replace("T", " ");
        this.dateCreate = basicFileAttributes.creationTime().toString().substring(0, 19).replace("T", " ");
        try {
            this.size = String.format("% d КБ", Files.size(file.toPath()) / 1024);
        } catch (IOException ioe) {
            this.size = "";
        }

        this.path = file.getAbsolutePath();
        this.isDirectory = file.isDirectory();
    }


    public File getFile() {
        return file;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getSize() {
        return size;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public boolean isDirectory() {
        return isDirectory;
    }
}
