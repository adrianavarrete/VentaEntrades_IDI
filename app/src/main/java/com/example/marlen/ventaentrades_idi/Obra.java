package com.example.marlen.ventaentrades_idi;

/**
 * Created by marlen on 19/05/2016.
 */
public class Obra {

    private String titol, data, descr, preu, dia;
    private int  durada,but_disp;
    private long num;


    //constructora amb paràmetres concrets
    Obra(String titol, String data, String preu, int durada, String descr, int but_disp){
        this.titol = titol;
        this.data = data;
        this.preu = preu;
        this.durada = durada;
        this.descr = descr;
        this.but_disp = but_disp;
    }

    //constructora buida
    Obra(){}

    //getters i setters
    public String getTitol(){ return titol; }
    public void setTitol(String titol){ this.titol = titol; }

    public String getData(){ return data; }
    public void setData(String data){ this.data = data; }

    public String getPreu(){ return preu; }
    public void setPreu(String preu){ this.preu = preu; }

    public Integer getDurada(){ return durada; }
    public void setDurada(int durada){ this.durada = durada; }

    public String getDescr(){ return descr; }
    public void setDescr(String descr){ this.descr = descr; }

    public Integer getButDisp(){ return but_disp; }
    public void setButDisp(int but_disp){ this.but_disp = but_disp; }

    public Long getNumBut(){ return num; }
    public void setNumBut(long num){ this.num = num; }

    public String getDia(){ return dia; }
    public void setDia(String dia){ this.dia = dia; }
}
