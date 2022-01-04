import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;

public class JFramePrinc extends JFrame implements ActionListener, ComponentListener{
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
        getContentPane().setBackground(new Color(14,21,37));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        setLocation(x,y);
        setVisible(true);
        panelEcrire = new JPanelEcrire(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        panelLire = new JPanelLire(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        panelLire.setVisible(true);
        panelChoix = new JPanelChoix(this.getContentPane().getWidth(),this.getContentPane().getHeight());
        boutonEcrire = new JButton("Ecrire");
        boutonEcrire.setForeground(new Color(108,217,126));
        boutonEcrire.setBackground(new Color(4,74,16));
        boutonEcrire.setLayout(null);
        boutonEcrire.setBounds(10,5,100,20);
        boutonEcrire.setVisible(true);
        boutonLire = new JButton("Lire");
        boutonLire.setLayout(null);
        boutonLire.setBounds(90,10,60,20);
        boutonLire.setVisible(false);
        boutonChoix = new JButton("Choix");
        boutonChoix.setForeground(new Color(108,217,126));
        boutonChoix.setBackground(new Color(4,74,16));
        boutonChoix.setLayout(null);
        boutonChoix.setBounds(this.getContentPane().getWidth()-110,5,100,20);
        boutonChoix.setVisible(true);
        this.add(panelEcrire);
        this.add(panelChoix);
        this.add(panelLire);
        this.add(boutonEcrire);
        this.add(boutonLire);
        this.add(boutonChoix);

        boutonEcrire.addActionListener(this);
        boutonLire.addActionListener(this);
        boutonChoix.addActionListener(this);
        this.addComponentListener(this);
        this.setVisible(false);
        this.setVisible(true);
        for(int i=0;i<panelChoix.bChoix.length;i++){
            panelChoix.bChoix[i].addActionListener(this);
        }
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==boutonEcrire){
            panelEcrire.setVisible(true);
        }
        if(e.getSource()==boutonLire){
            panelLire.setVisible(true);
        }
        if(e.getSource()==boutonChoix){
            if (panelChoix.isVisible()){
                panelChoix.setVisible(false);
            }else{
                panelChoix.setVisible(true);
            }
        }
        for(int i=0;i<panelChoix.bChoix.length;i++)
        {
            if(e.getSource()==panelChoix.bChoix[i]){
                String txt=panelChoix.fichiers[panelChoix.fichiers.length-1-(i+panelChoix.page*panelChoix.bChoix.length)];
                // System.out.println(txt);
                panelLire.changerTexte(txt);
                panelChoix.setVisible(false);
            }
        }
    }

    public void componentHidden(ComponentEvent e) {
        // displayMessage(e.getComponent().getClass().getName() + " --- Hidden");
    }

    public void componentMoved(ComponentEvent e) {
        // displayMessage(e.getComponent().getClass().getName() + " --- Moved");
    }

    public void componentResized(ComponentEvent e) {
        pack();         
    }

    public void componentShown(ComponentEvent e) {
        // displayMessage(e.getComponent().getClass().getName() + " --- Shown");

    }

}

