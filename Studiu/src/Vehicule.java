import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class Vehicule extends MiniClasaMeaObject {
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\033[1;94m";
    public static final String WHITE= "\033[0;97m";
    public static final String FileName = "Studiu2.ser";
    transient Scanner scanner = new Scanner(System.in); //îl instanțiem aici și cum toate clasele vor extinde clasa aceasta, nu va fi nevoie să-l mai instanțiem în altă parte
    static final int currentYear = LocalDate.now().getYear();
    private String marca, numarSerieMotor;
    private int anul;
    private double pret;

    //constructori
    Vehicule(){}
    Vehicule(String marca, String numarSerieMotor, int anul, double pret){
        this.marca = marca;
        this.numarSerieMotor = numarSerieMotor;
        this.anul = anul;
        this.pret = pret;
    }

    //setter
    void setMarca(String marca){
      this.marca = marca;
    }
    void setNumarSerieMotor(String numarSerieMotor){
        this.numarSerieMotor = numarSerieMotor;
    }
    void setAnul(int anul){
        this.anul = anul;
    }
    void setPret(double pret){
        this.pret = pret;
    }

    //getter
    String getMarca(){
    return marca;
    }
    String getNumarSerieMotor(){
        return numarSerieMotor;
    }
    int getAnul(){
        return anul;
    }
    double getPret(){
        return pret;
    }

    abstract void read();

    int howOld() {
        return currentYear - anul;
    }

    @Override
    public String toString(){
        return getMarca() + " " + getNumarSerieMotor() + " " + getAnul() + " " + getPret();
    }
}