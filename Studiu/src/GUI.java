import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    ImageIcon logo = new ImageIcon("logo.png");
    private JButton b1, b2, b3, b4, b5, b6, b7, b8;
    GUI(){
        JFrame frame = new JFrame("Meniu");
        frame.setIconImage(logo.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // centreaza meniul
        frame.setLayout(new GridLayout(8, 1));
        frame.setAlwaysOnTop(true);






        b1 = new JButton("1 Adaugă un vehicul în fișier"); b1.setFocusable(false); b1.addActionListener(e ->  {TEst1.addVehiculToArraylist(); TEst1.saveArrayListToFile();});
        b2 = new JButton("2 Afișează toate produsele din companie"); b2.setFocusable(false); b2.addActionListener(e -> TEst1.showArraylist());
        b3 = new JButton("3 Prețului total al mașinilor din companie"); b3.setFocusable(false); b3.addActionListener(e -> TEst1.pretTotal());
        b4 = new JButton("4 Afișați lista camionetelor"); b4.setFocusable(false); b4.addActionListener(e -> TEst1.camionete());
        b5 = new JButton("5 Afișează datele celea mai ieftină camionetă"); b5.setFocusable(false); b5.addActionListener(e -> TEst1.ceaMaiIeftinaCamioneta());
        b6 = new JButton("6 Afișează datele automobilul cel mai vechi"); b6.setFocusable(false); b6.addActionListener(e -> TEst1.celMaiVechi());
        b7 = new JButton("7 Afișează datele automobilul cu cel mai mare număr de pasageri"); b7.setFocusable(false); b7.addActionListener(e -> TEst1.cel_mai_mare_numar_de_pasageri());
        b8 = new JButton("Cancel"); b8.setFocusable(false); b8.addActionListener(e -> System.exit(0));




        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);





        frame.setVisible(true);
    }
}