package org.aposternak35.demo;

import java.io.File;
import java.util.ArrayList;

public class Fayl {
    private File dir;
    private ArrayList<MyFile> myfiles=new ArrayList<>();
    private boolean isRoot;
    private boolean isDisk;
    public Fayl(){
        this(System.getProperty("user.dir"));
    }
    public Fayl(String pathString){
        this.dir=new File(pathString);
        try {
            for(File file: dir.listFiles()){
                if(!file.isHidden()&&file.exists()){
                    this.myfiles.add(new MyFile(file));
                }
            }
        }catch (NullPointerException npe){

        }
        this.isRoot=dir.toPath().getNameCount()==0;
        this.isDisk=false;
    }
    public Fayl(File[] files){

    }
    public File getDir(){
        return dir;
    }
    public ArrayList<MyFile> getMyfiles(){
        return myfiles;
    }
    public boolean isRoot(){return isRoot;}
    public boolean isDisk(){return isDisk;}
}
