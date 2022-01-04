import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.*;
import java.time.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class JPanelChoix extends JPanel implements ActionListener{

    JTextArea tTexte;
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = today.plusDays(1);
    LocalDate choixDate;
    JButton[] bChoix = new JButton[5];
    JButton bApres;
    JButton bAvant;
    int page=0;
    String[] fichiers;

    JPanelChoix(int largeurFrame, int longueurFrame){
        // System.out.println(tomorrow);
        setLayout(null);
        setBounds(largeurFrame/4, longueurFrame/20-5,largeurFrame/2,longueurFrame*18/20+10);
        setBackground(new Color(61,66,76));
        setVisible(false);

        int largeur = this.getWidth();
        int longueur = this.getHeight();
        fichiers = ExplorerFichiers(0);
        // System.out.println(fichiers[0]);
        for (int i=0;i<bChoix.length;i++){
            // System.out.println("i : "+i+", fichiers.length : "+fichiers.length);
            if (i<fichiers.length){
                bChoix[i]=new JButton(fichiers[fichiers.length-1-i]);
                // System.out.println("yes1");
            }else{
                bChoix[i]=new JButton();
                bChoix[i].setVisible(false);
            }
            bChoix[i].setLayout(null);
            bChoix[i].setBounds(20,30+i*80,largeur-40,40);
            // System.out.println(bChoix[i].getWidth()+" "+bChoix[i].getHeight());
            if (i<fichiers.length){
                bChoix[i].setVisible(true);
                bChoix[i].setOpaque(true);
                
                bChoix[i].setForeground(new Color(108,217,126));
                bChoix[i].setBackground(new Color(4,74,16));
                // System.out.println("yes2");
            }
            this.add(bChoix[i]);
        }

        bApres = new JButton("Suivant ->");
        bApres.setLayout(null);
        bApres.setBounds(largeur-150,longueur-50,125,20);
        this.add(bApres);
        if(fichiers.length<=bChoix.length){
            bApres.setVisible(false);
        }

        bAvant = new JButton("<- Précédent");
        bAvant.setLayout(null);
        bAvant.setBounds(25,longueur-50, 125,20);
        this.add(bAvant);
        bAvant.setVisible(false);
        
        for (int i=0;i<bChoix.length;i++){
            bChoix[i].addActionListener(this);
        }
        bApres.addActionListener(this);
        bAvant.addActionListener(this);


        

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bApres && fichiers.length/bChoix.length>page){
            page++;
            bAvant.setVisible(true);
            for (int i=0;i<bChoix.length;i++){
                // System.out.println("i : "+i+", fichiers.length : "+fichiers.length);
                if ((i+page*bChoix.length)<fichiers.length){
                    bChoix[i].setText(fichiers[fichiers.length-1-(i+page*bChoix.length)]);
                    bChoix[i].setVisible(true);
                }else{
                    bChoix[i].setVisible(false);
                    bApres.setVisible(false);
                }
            }
            if((page+1)*bChoix.length==fichiers.length) bApres.setVisible(false);
        }

        if(e.getSource()==bAvant && page>0){
            page--;
            if(page==0){
                bAvant.setVisible(false);
            }
            bApres.setVisible(true);
            for (int i=0;i<bChoix.length;i++){
                // System.out.println("i : "+i+", fichiers.length : "+fichiers.length);
                bChoix[i].setText(fichiers[fichiers.length-1-(i+page*bChoix.length)]);
                bChoix[i].setVisible(true);
            }
        }
    }
    public String[] ExplorerFichiers(int page){
        String[] pathnames;

        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File f = new File("donnees");

        // Populates the array with names of files and directories
        pathnames = f.list();

        // For each pathname in the pathnames array
        for (String pathname : pathnames) {
            // Print the names of files and directories
            // System.out.println(pathname);
        }
        return pathnames;
    }

}