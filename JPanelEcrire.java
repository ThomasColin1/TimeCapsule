import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.*;
import java.time.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class JPanelEcrire extends JPanel implements ActionListener{

    JCheckBox bMinuit;
    JTextArea tTexte;
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = today.plusDays(1);
    LocalDate choixDate;
    JButton bOK;

    JPanelEcrire(int largeurFrame, int longueurFrame){
        // System.out.println(tomorrow);
        setLayout(null);
        setBounds(largeurFrame/20, longueurFrame/20,largeurFrame*18/20,longueurFrame*18/20);
        setBackground(Color.red);
        setVisible(false);
        
        setBackground(new Color(23,30,46));

        int largeur = this.getWidth();
        int longueur = this.getHeight();

        bOK = new JButton("Valider");
        bOK.setBounds(largeur/2-100,longueur-30,200,20);
        this.add(bOK);

        bMinuit = new JCheckBox("Est-il minuit passé ?");
        bMinuit.setBounds(largeur/2-100,longueur-60,200,20);
        this.add(bMinuit);

        tTexte = new JTextArea();
        tTexte.setBounds(20,40,largeur-40,longueur-120);
        tTexte.setBackground(new Color(23,30,46));
        tTexte.setForeground(new Color(211,211,211));
        this.add(tTexte);

        bOK.addActionListener(this);


        

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bOK){
            String texte = tTexte.getText();
            System.out.println(texte);
            if(bMinuit.isSelected()){
                choixDate = today;
            }else{
                choixDate = tomorrow;
            }
            try{
                Ecrire(choixDate.toString(), texte);
            }catch(IOException i){
                System.out.println("ERREUR");
            }
            this.setVisible(false);
        }
    }
    public void Ecrire(String date, String texte) throws IOException{
        FileWriter ecrivain=new FileWriter("donnees//"+date+".txt", StandardCharsets.UTF_8); 
        PrintWriter ecrivain2=new PrintWriter(ecrivain);
        ecrivain2.printf("%s"+"%n",texte);
        ecrivain2.close();
    }

}