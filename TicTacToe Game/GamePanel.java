import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GamePanel implements ActionListener
{
    JFrame jf;
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
    
    String str="";
    int count=0;
    
    GamePanel()
    {
        jf=new JFrame("Developed by Gopal");
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridLayout gl=new GridLayout(3, 3);
        jf.setLayout(gl);
                
        
        jb1=new JButton();
        jf.add(jb1);
        jb1.addActionListener(this);
        
        jb2=new JButton();
        jf.add(jb2);
        jb2.addActionListener(this);
        
        jb3=new JButton();
        jf.add(jb3);
        jb3.addActionListener(this);
        
        jb4=new JButton();
        jf.add(jb4);
        jb4.addActionListener(this);
        
        jb5=new JButton();
        jf.add(jb5);
        jb5.addActionListener(this);
        
        jb6=new JButton();
        jf.add(jb6);
        jb6.addActionListener(this);
        
        jb7=new JButton();
        jf.add(jb7);
        jb7.addActionListener(this);
        
        jb8=new JButton();
        jf.add(jb8);
        jb8.addActionListener(this);
        
        jb9=new JButton();
        jf.add(jb9);
        jb9.addActionListener(this);
        
        
        jf.setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        count=count+1;
        
        if(count%2==0)
        {
            str="0";
        }
        else
        {
            str="X";
        }
        
        if(e.getSource()==jb1)
        {
            jb1.setFont(new Font("Arial",1, 50));
            jb1.setText(str);
            jb1.setEnabled(false);
        }
        if(e.getSource()==jb2)
        {
            jb2.setFont(new Font("Arial",1, 50));
            jb2.setText(str);
            jb2.setEnabled(false);
        }
        if(e.getSource()==jb3)
        {
            jb3.setFont(new Font("Arial",1, 50));
            jb3.setText(str);
            jb3.setEnabled(false);
        }
        if(e.getSource()==jb4)
        {
            jb4.setFont(new Font("Arial",1, 50));
            jb4.setText(str);
            jb4.setEnabled(false);
        }
        if(e.getSource()==jb5)
        {
            jb5.setFont(new Font("Arial",1, 50));
            jb5.setText(str);
            jb5.setEnabled(false);
        }
        if(e.getSource()==jb6)
        {
            jb6.setFont(new Font("Arial",1, 50));
            jb6.setText(str);
            jb6.setEnabled(false);
        }
        if(e.getSource()==jb7)
        {
            jb7.setFont(new Font("Arial",1, 50));
            jb7.setText(str);
            jb7.setEnabled(false);
        }
        if(e.getSource()==jb8)
        {
            jb8.setFont(new Font("Arial",1, 50));
            jb8.setText(str);
            jb8.setEnabled(false);
        }
        if(e.getSource()==jb9)
        {
            jb9.setFont(new Font("Arial",1, 50));
            jb9.setText(str);
            jb9.setEnabled(false);
        }
        winningPossibilities();
    }
    
    void winningPossibilities()
    {
        //Horizontal condition
        
        if (jb1.getText()==jb2.getText() && jb2.getText()==jb3.getText() && jb3.getText()!="")
        {
            JOptionPane.showMessageDialog(jf, str + " Wins");
            restart();
        }
        else if(jb4.getText()==jb5.getText() && jb5.getText()==jb6.getText() && jb6.getText()!="")
        {
           JOptionPane.showMessageDialog(jf, str + " Wins"); 
           restart();
        }
        else if(jb7.getText()==jb8.getText() && jb8.getText()==jb9.getText() && jb9.getText()!="")
        {
            JOptionPane.showMessageDialog(jf, str + " Wins");
            restart();
        }
        
        //vertical condition
        
        else if(jb1.getText()==jb4.getText() && jb4.getText()==jb7.getText() && jb7.getText()!="")
        {
            JOptionPane.showMessageDialog(jf, str + " Wins");
            restart();
        }
        else if(jb2.getText()==jb5.getText() && jb5.getText()==jb8.getText() && jb8.getText()!="")
        {
            JOptionPane.showMessageDialog(jf, str + " Wins");
            restart();
        }
        else if(jb3.getText()==jb6.getText() && jb6.getText()==jb9.getText() && jb9.getText()!="")
        {
            JOptionPane.showMessageDialog(jf, str + " Wins");
            restart();
        }
        
        //Diagonal condition
        
        else if(jb1.getText()==jb5.getText() && jb5.getText()==jb9.getText() && jb9.getText()!="")
        {
            JOptionPane.showMessageDialog(jf, str + " Wins");
            restart();
        }
        else if(jb3.getText()==jb5.getText() && jb5.getText()==jb7.getText() && jb7.getText()!="")
        {
            JOptionPane.showMessageDialog(jf, str + " Wins");
            restart();
        }
        //Draw condition
        else
        {
            if(jb1.getText()!="" && jb2.getText()!="" && jb3.getText()!="" && jb4.getText()!="" && jb5.getText()!="" && jb6.getText()!="" && jb7.getText()!="" && jb8.getText()!="" && jb9.getText()!="")
            {
                JOptionPane.showMessageDialog(jf, "Match Draw");
                restart();
            }
        }
        
        
    }
    void restart()
    {
        int i=JOptionPane.showConfirmDialog(jf, "Do you want to restart");
        {
            if(i==0)
            {
                jb1.setText("");
                jb2.setText("");
                jb3.setText("");
                jb4.setText("");
                jb5.setText("");
                jb6.setText("");
                jb7.setText("");
                jb8.setText("");
                jb9.setText("");
                
                jb1.setEnabled(true);
                jb2.setEnabled(true);
                jb3.setEnabled(true);
                jb4.setEnabled(true);
                jb5.setEnabled(true);
                jb6.setEnabled(true);
                jb7.setEnabled(true);
                jb8.setEnabled(true);
                jb9.setEnabled(true);
                
            }
            else if(i==1)
            {
                System.exit(0);
            }
            else
            {
                jb1.setEnabled(false);
                jb2.setEnabled(false);
                jb3.setEnabled(false);
                jb4.setEnabled(false);
                jb5.setEnabled(false);
                jb6.setEnabled(false);
                jb7.setEnabled(false);
                jb8.setEnabled(false);
                jb9.setEnabled(false);
            }
        }
    }
}
