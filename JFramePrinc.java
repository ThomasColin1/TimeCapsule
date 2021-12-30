import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;

public class JFramePrinc extends JFrame implements ActionListener{
    protected JButton boutonEcrire;
    protected JButton boutonLire;
    protected JButton boutonChoix;
    protected JPanelEcrire panelEcrire;
    protected JPanelLire panelLire;
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
        panelEcrire = new JPanelEcrire(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        panelLire = new JPanelLire(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        panelChoix = new JPanelChoix(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        boutonEcrire = new JButton("Ecrire");
        boutonEcrire.setLayout(null);
        boutonEcrire.setBounds(10,10,60,20);
        boutonEcrire.setVisible(true);
        boutonLire = new JButton("Lire");
        boutonLire.setLayout(null);
        boutonLire.setBounds(90,10,60,20);
        boutonLire.setVisible(true);
        boutonChoix = new JButton("Choix");
        boutonChoix.setLayout(null);
        boutonChoix.setBounds(170,10,60,20);
        boutonChoix.setVisible(true);
        this.add(panelEcrire);
        this.add(panelLire);
        this.add(panelChoix);
        this.add(boutonEcrire);
        this.add(boutonLire);
        this.add(boutonChoix);
        boutonEcrire.addActionListener(this);
        boutonLire.addActionListener(this);
        boutonChoix.addActionListener(this);
        setVisible(false);
        setVisible(true);

        
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==boutonEcrire){
            panelEcrire.setVisible(true);
        }
        if(e.getSource()==boutonLire){
            panelLire.setVisible(true);
        }
        if(e.getSource()==boutonChoix){
            panelChoix.setVisible(true);
        }
    }

}

