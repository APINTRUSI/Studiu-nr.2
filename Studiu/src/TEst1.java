import java.io.*;
import java.util.*;
import static java.awt.Color.*;
import static java.lang.Double.MAX_VALUE;

public class TEst1 {
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\033[1;94m";
    public static final String PURPLE =  "\u001B[35m";
    public static final String WHITE= "\033[0;97m";
    public static final String FileName = "Studiu2.ser";

    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<MiniClasaMeaObject> list = new ArrayList<MiniClasaMeaObject>();

    public static void addVehiculToArraylist(){
        System.out.println("\nVrei să introduci un "+ YELLOW + "automobil " + WHITE + "sau o " + YELLOW + "camioneta" + WHITE);
        String s = scanner.nextLine();
        while (true){
            if (s.equalsIgnoreCase("automobil")){
                Tip tip = new Tip(s);
                list.add(tip);
                //System.out.println("Tipul vehiculului adaugat in array list");
                Automobil automobil = new Automobil();
                automobil.read();
                list.add(automobil);
                System.out.println(GREEN + "\nAutomobilul a fost adăugat cu succes." + WHITE); //în arraylist
                break;
            }
            else if (s.equalsIgnoreCase("camioneta")){
                Tip tip = new Tip(s);
                list.add(tip);
                //System.out.println("Tipul vehiculului adaugat in array list");
                Camioneta camioneta = new Camioneta();
                camioneta.read();
                list.add(camioneta);
                System.out.println(GREEN + "\nCamioneta a fost adăugată cu succes." + WHITE); //în arraylist
                break;
            }
            else{
            System.out.println(PURPLE + "\nMai încearcă" + WHITE);
            s = scanner.nextLine();
            }
        }

    }

    public static void showArraylist(){
        if (list.isEmpty())
            System.out.println(PURPLE + "\nNu exista vehicule." + WHITE);
        for (int i = 0; i<list.size(); i+=2){
            System.out.println(list.get(i).toString());
            System.out.println(list.get(i+1).toString());
        }
    }

    public static void saveArrayListToFile(){
        try (FileOutputStream fos = new FileOutputStream(FileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(list);
            //System.out.println("ArrayListSavedToFile");

        } catch (FileNotFoundException e) {
            System.err.println("\nFile not found : ");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("\nError while writing data : ");
            throw new RuntimeException(e);
        }
    }

    static public void dateFromFileToArrayList(){
        try(ObjectInputStream cin = new ObjectInputStream(new FileInputStream(FileName))) {
            list = (ArrayList<MiniClasaMeaObject>)cin.readObject();
        }
        catch (EOFException eof){}
        catch (IOException | ClassNotFoundException ex ){}
    }

    static void pretTotal(){
        double total = 0;
        if (list.isEmpty())
            System.out.println(PURPLE + "\nNu exista vehicule în companie, respectiv prețul total e 0." + WHITE);
        else{
            for (int i = 1; i<list.size(); i+=2){
                Vehicule vehicul = (Vehicule) list.get(i);
                total += vehicul.getPret();
            }
            System.out.println(BLUE + "\nPrețului total al mașinilor din companie: " + total + WHITE);
        }
    }

    static void camionete(){
        boolean ok = false;
        if (list.isEmpty())
            System.out.println(PURPLE + "\nNu exista vehicule în companie, respectiv nu-s nici camionete." + WHITE);
        else{
            for (int i = 0; i<list.size(); i+=2){
                Tip tip = (Tip) list.get(i);
                if (tip.getTip().equalsIgnoreCase("camioneta")){
                    ok = true; break;
                }
            }

            if (ok == false)
                System.out.println(PURPLE + "\nNu sunt camionete" + WHITE);
            else{
                System.out.println(BLUE + "\nCamionete:" + WHITE);
                System.out.println("Variabile{Marca, Numarul de serie, Anul aparitiei, Pretul, Capacitatea transportarii}");
                for (int i = 0; i<list.size(); i+=2){
                    Tip tip = (Tip) list.get(i);
                    if (tip.getTip().equalsIgnoreCase("camioneta")){
                        System.out.println(list.get(i+1).toString());
                        ok = true;
                    }
                }
            }
        }
    }

    static void ceaMaiIeftinaCamioneta(){
        Camioneta camioneta1 =  null;
        boolean ok = false;
        double min = MAX_VALUE;
        if (list.isEmpty())
            System.out.println(PURPLE + "\nNu exista vehicule în companie, respectiv nu-s nici camionete." + WHITE);
        else{
            for (int i = 0; i<list.size(); i+=2){
                Tip tip = (Tip) list.get(i);
                if (tip.getTip().equalsIgnoreCase("camioneta")){
                    Camioneta camioneta = (Camioneta)  list.get(i+1);
                    if(camioneta.getPret() < min){
                        min = camioneta.getPret();
                        camioneta1 = camioneta;
                    }
                    ok = true;
                }
            }
        }

            if (ok == false)
                System.out.println(PURPLE + "\nNu sunt camionete, respectiv nu exista una cea mai ieftina" + WHITE);
            else{
                System.out.println(BLUE + "\nCea mai ieftina camioneta: " + WHITE);
                System.out.println("Variabile{Marca, Numarul de serie, Anul aparitiei, Pretul, Capacitatea transportarii}");
                System.out.println(camioneta1.toString());
            }
    }

    static void celMaiVechi(){
        Automobil automobil =  null;
        boolean ok = false;
        int agemax = 0;
        if (list.isEmpty())
            System.out.println(PURPLE + "\nNu exista vehicule în companie, respectiv nu-s nici automobile." + WHITE);
        else{
            for (int i = 0; i<list.size(); i+=2){
                Tip tip = (Tip) list.get(i);
                if (tip.getTip().equalsIgnoreCase("automobil")){
                    Automobil automobil1 = (Automobil)  list.get(i+1);
                    if(automobil1.howOld() > agemax){
                        agemax = automobil1.howOld();
                        automobil = automobil1;
                    }
                    ok = true;
                }
            }

        }
        if (ok == false)
            System.out.println(PURPLE + "\nNu sunt automobile" + WHITE);
        else {
            System.out.println(BLUE + "\nCel mai vechi automobil are " + agemax + " ani: " + WHITE);
            System.out.println("Variabile{Marca, Numarul de serie, Anul aparitiei, Pretul, Capacitatea transportarii}");
            System.out.println(automobil.toString());
        }
    }

    static void cel_mai_mare_numar_de_pasageri(){
        Automobil automobil =  null;
        boolean ok = false;
        int mare = 0;
        if (list.isEmpty())
            System.out.println(PURPLE + "\nNu exista vehicule în companie, respectiv nu-s nici automobile." + WHITE);
        else{
            for (int i = 0; i<list.size(); i+=2){
                Tip tip = (Tip) list.get(i);
                if (tip.getTip().equalsIgnoreCase("automobil")){
                    Automobil automobil1 = (Automobil)  list.get(i+1);
                    if(automobil1.getSeats() > mare){
                        mare = automobil1.getSeats();
                        automobil = automobil1;
                    }
                    ok = true;
                }
            }
        }

        if (ok == false)
            System.out.println(PURPLE + "\nNu sunt automobile" + WHITE);
        else{
            System.out.println(BLUE + "\nAutomobilul cu cel mai mare numar de pasageri: " + WHITE);
            System.out.println("Variabile{Marca, Numarul de serie, Anul aparitiei, Pretul, Numarul de pasageri}");
            System.out.println(automobil.toString());
        }
    }



    public static void main(String[] args) throws IOException {
        dateFromFileToArrayList();
        GUI gui = new GUI();

    }
}


//					Steps to Serialize
//					---------------------------------------------------------------
//					1. Your class should implement Serializable interface
//					2. add import java.io.Serializable;
//					3. FileOutputStream fileOut = new FileOutputStream(file path)
//					4. ObjectOutputStream out = new ObjectOutputStream(fileOut);
//					5. out.writeObject(objectName)
//					6. out.close(); fileOut.close();
//					---------------------------------------------------------------

//                  Steps to Deserialize
//					---------------------------------------------------------------
//					1. Your class should implement Serializable interface
//					2. add import java.io.Serializable;
//					3. FileInputStream fileIn = new FileInputStream(file path);
//					4. ObjectInputStream in = new ObjectInputStream(fileIn);
//					5. objectNam = (Class) in.readObject();
//					6. in.close(); fileIn.close();
//					---------------------------------------------------------------

// important notes	1. children classes of a parent class that implements Serializable will do so as well
//					2. static fields are not serialized (they belong to the class, not an individual object)
//					3. Fields declared as "transient" aren't serialized, they're ignored
//					4. the class's definition ("class file") itself is not recorded, cast it as the object type
//					5. serialVersionUID is a unique version ID