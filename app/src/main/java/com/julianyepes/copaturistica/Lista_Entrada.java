package com.julianyepes.copaturistica;

/**
 * Created by Edwin on 14/03/2017.
 */

public class Lista_Entrada {

    private int idListaIcono;
    private int idListaImg;
    private String listText;

    public Lista_Entrada(int idListaIcono,int idListaImg, String listText) {
        this.idListaIcono = idListaIcono;
        this.idListaImg = idListaImg;
        this.listText = listText;
    }

    public int getIdListaImg() {
        return idListaImg;
    }

    public void setIdListaImg(int idListaImg) {
        this.idListaImg = idListaImg;
    }

    public String getListText() {
        return listText;
    }

    public void setListText(String listText) {
        this.listText = listText;
    }

    public int getIdListaIcono() {
        return idListaIcono;
    }

    public void setIdListaIcono(int idListaIcono) {
        this.idListaIcono = idListaIcono;
    }
}
