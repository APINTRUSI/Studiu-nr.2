import java.io.*;
import java.util.InputMismatchException;

public class Camioneta extends Vehicule {
    private double capacitate;
    public void setCapacitate(double capacitate) {
        this.capacitate = capacitate;
    }
    public double getCapacitate() {
        return capacitate;
    }

    //constructori
    Camioneta(){}

    Camioneta(String numarSerieMotor, String marca, int anul, double pret, double capacitate){
        super(numarSerieMotor, marca, anul, pret);
        this.capacitate = capacitate;
    }

    @Override
    void read() {
        int an = -1;
        System.out.print("Marca camionetei: ");
        setMarca(scanner.nextLine());

        System.out.print("Numărul de serie al motorului: ");
        setNumarSerieMotor(scanner.nextLine());

        try {
            while (true){
                System.out.print("Anul apariției: ");
                an = scanner.nextInt();
                if(an > 0 && an <= currentYear){
                    setAnul(an);
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Valoarea trebuie sa apartina intervalului [0-an curent]");
                }
            }

            System.out.print("Preț: ");
            setPret(price(scanner.nextDouble()));
            scanner.nextLine();

            System.out.print("Capacitatea de transportare în tone: ");
            setCapacitate(scanner.nextDouble());
            scanner.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("Ai introdus un tip de date nevalabil");
            System.out.println(YELLOW + "Mai încearcă" + WHITE);
            scanner.nextLine();
            read();
        }
    }

    double price(double p) {
        if(capacitate < 3)
            return p;
        else if (capacitate < 6)
            return p + 1000;
        else if (capacitate < 10)
            return p + 2000;
        else if (capacitate < 15)
            return p + 3000;
        else
            return p + 5000;
    }

    @Override
    public String toString(){
        return getMarca() + " " + getNumarSerieMotor() + " " + getAnul() + " " + getPret() + " " + getCapacitate();
    }
}
