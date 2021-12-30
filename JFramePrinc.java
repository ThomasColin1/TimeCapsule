import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JFramePrinc extends JFrame implements ActionListener{
    protected JButton bouton;
    protected JPanelChoix panelChoix;
    

    public JFramePrinc(){
        setLayout(null);
        setTitle("The Time Capsule");
        setSize(795,624);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        setLocation(x,y);
        setVisible(true);
        panelChoix = new JPanelChoix(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        bouton = new JButton();
        bouton.setBounds(10,10,30,10);
        this.add(bouton);
        this.add(panelChoix);
        bouton.addActionListener(this);

        
    }

    public void actionPerformed(ActionEvent e){
        this.setTitle("Bouton : Appuyé");
        if(e.getSource()==bouton){
            panelChoix.setVisible(true);
        }
    }

}

