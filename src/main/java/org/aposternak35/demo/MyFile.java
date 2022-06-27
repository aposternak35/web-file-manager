package org.aposternak35.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFile {
    private File file;
    private String name;
    private String path;
    private String size;
    private String dateCreate;
    private String dateUpdate;
    private String type;
    private boolean isDirectory;

    public MyFile(File file) {
        this.file=file;
        this.name=file.getName();
        this.dateUpdate=new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date(file.lastModified()));
        try {
            if (file.isDirectory()) {
                type = "Directory";
            } else {
                type = Files.probeContentType(file.toPath());
            }
        }catch (IOException ioe){
            type="";
        }
        try{
            this.size=String.format("% d КБ", Files.size(file.toPath())/1024);
        }catch (IOException ioe){
            this.size="";
        }

        this.path=file.getAbsolutePath();
        this.isDirectory=file.isDirectory();
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

    public String getType() {
        return type;
    }
    public boolean isDirectory(){
        return isDirectory;
    }
}
