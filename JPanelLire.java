import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.*;
import java.time.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class JPanelLire extends JPanel implements ActionListener{

    JTextArea tTexte;
    LocalDate today = LocalDate.now();
    JButton bOK;

    JPanelLire(int largeurFrame, int longueurFrame){
        setLayout(null);
        setBounds(largeurFrame/20, longueurFrame/20,largeurFrame*18/20,longueurFrame*18/20);
        setBackground(Color.red);
        setVisible(false);

        String texte = Lire(today.toString());

        int largeur = this.getWidth();
        int longueur = this.getHeight();

        bOK = new JButton("Quitter");
        bOK.setBounds(largeur/2-100,longueur-30,200,20);
        this.add(bOK);

        tTexte = new JTextArea(texte);
        tTexte.setBounds(20,40,largeur-40,longueur-120);
        tTexte.setEditable(false);
        this.add(tTexte);

        bOK.addActionListener(this);


        

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bOK){
            this.setVisible(false);
        }
    }

    public String Lire(String date){
        String s="";
        //Lire et afficher le fichier txt à l'écran
        // try {
        //     // Le fichier d'entrée
        //     FileInputStream file = new FileInputStream("donnees//"+date+".txt");
        //     Scanner scanner = new Scanner(file);

        //     //renvoie true s'il y a une autre ligne à lire
        //     while (scanner.hasNextLine()) {
        //         s=s+(scanner.nextLine())+"\n";
        //     }
        //     scanner.close();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        try (FileInputStream fis = new FileInputStream("donnees//"+date+".txt");
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr)
        ) {

            String str;
            while ((str = reader.readLine()) != null) {
                s=s+str+"\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return(s);
    }

}