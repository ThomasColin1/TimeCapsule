import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class JPanelChoix extends JPanel implements ActionListener{
    JPanelChoix(int largeur, int longueur){
        setLayout(null);
        
        setBounds(largeur/20, longueur/20,largeur*18/20,longueur*18/20);
        setBackground(Color.red);
        setVisible(false);
        
    }

    public void actionPerformed(ActionEvent e){

    }
}