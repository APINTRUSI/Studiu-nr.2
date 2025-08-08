import java.io.*;
import java.util.InputMismatchException;

public class Automobil extends Vehicule {

    private int seats;
    void setSeats(int seats){
        this.seats = seats;
    }
    int getSeats(){
        return seats;
    }
    //constructori
    Automobil(){}
    Automobil(String marca, String numarSerieMotor, int anul, double pret, int seats) {
        super(marca, numarSerieMotor, anul, pret);
        this.seats = seats;
    }

    @Override
     void read() {
        int an = -1;

        System.out.print("Marca automobilului: ");
            setMarca(scanner.nextLine());

            System.out.print("Numărul de serie al motorului: ");
            setNumarSerieMotor(scanner.nextLine());

        try {
            while (true){
                System.out.print("Anul apariției: ");
                an = scanner.nextInt();
                if(an > 0 && an <=currentYear){
                setAnul(an);
                scanner.nextLine();
                break;
                }
                else {
                    System.out.println("Valoarea trebuie sa apartina intervalului [0-an curant]");
                }
            }

            System.out.print("Preț: ");
            setPret(price(scanner.nextDouble()));
            scanner.nextLine();

            System.out.print("Număr de pasageri: ");
            setSeats(scanner.nextInt());
            scanner.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("Ai introdus un tip de date nevalabil");
            System.out.println(YELLOW + "Mai încearcă" + WHITE);
            scanner.nextLine();
            read();
        }

    }

    double price(double p){
        return p + 1000;
    }

    @Override
    public String toString(){
        return  getMarca() + " " + getNumarSerieMotor() + " " + getAnul() + " " + getPret() + " " + getSeats();
    }
}