package kr.co.farmstory.vo;

public class FileVo {

    private int fseq;
    private int parent;
    private String oriName;
    private String newName;
    private int download;
    private String rdate;

    public int getFseq() {
        return fseq;
    }

    public void setFseq(int fseq) {
        this.fseq = fseq;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getOriName() {
        return oriName;
    }

    public void setOriName(String oriName) {
        this.oriName = oriName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

}