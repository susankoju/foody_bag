package edu.kist.bit.foodybag.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author leapfrog
 */
public class FileUploadDTO {
    private String fileLocation;
    private String fileName;
    private Boolean isWrittenOnDisk;

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Boolean isIsWrittenOnDisk() {
        return isWrittenOnDisk;
    }

    public void setIsWrittenOnDisk(Boolean isWrittenOnDisk) {
        this.isWrittenOnDisk = isWrittenOnDisk;
    }

            public String getFileName() {
                        return fileName;
            }
            public void setFileName(String fileName) {
                        this.fileName = fileName;
            }
    
    
}
