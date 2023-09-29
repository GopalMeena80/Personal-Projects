
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CodingPart implements ActionListener
{
    JFrame jf;
    JMenuBar jmb;
    JMenu file;
    JMenuItem neww, open, save, saveas, pagesetup, print, exit;
    JTextArea jta;
    JScrollPane jsp;
    JFileChooser jfc;
    FileOutputStream fos;
    FileInputStream fis;
    File filee;
    
    String title="Untitled-Notepad";
    
    public CodingPart()
    {
        jf=new JFrame(title);
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //---------------------------------------------------
        jmb=new JMenuBar();
        
        //------------------
        file=new JMenu("File");
        //file.addActionListener(this);
        
        neww=new JMenuItem("New");
        neww.addActionListener(this);
        file.add(neww);
        
        open=new JMenuItem("Open");
        open.addActionListener(this);
        file.add(open);
        
        file.addSeparator();
        
        save=new JMenuItem("Save");
        save.addActionListener(this);
        file.add(save);
        
        saveas=new JMenuItem("Save AS");
        saveas.addActionListener(this);
        file.add(saveas);
        
        file.addSeparator();
        
        exit=new JMenuItem("Exit");
        exit.addActionListener(this);
        file.add(exit);
        
        //--------------------------
        
        jta=new JTextArea();
        jsp=new JScrollPane(jta);
        
        
        //-----------------------
        jmb.add(file);
        jf.add(jsp);
        
        jf.setJMenuBar(jmb);
        
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==neww)
        {
            newPage();
        }
        if(e.getSource()==open)
        {
            openPage();
        }
        if(e.getSource()==save)
        {
            savePage();
        }
        if(e.getSource()==saveas)
        {
            savePage();
        }
        
        if(e.getSource()==exit)
        {
            System.exit(0);
        }
        
    }
    void newPage()
    {
        String s=jta.getText();
        if(!s.equals(""))
        {
            int i=JOptionPane.showConfirmDialog(jf, "Do you want to save file!");
            if(i==0)
            {
                savePage();
                jta.setText("");
            }
            else if(i==1)
            {
                jta.setText("");
            }
            
        }
        else
        {
            jta.setText("");
        }
        
        
    }
    void savePage()
    {
        jfc=new JFileChooser();
        int i=jfc.showSaveDialog(jf);
        if(i==0)
        {
            try
            {
                String textarea=jta.getText();
                byte[] b=textarea.getBytes();  // Because write method print the data in byte form only thats why we have to convert it
                filee=jfc.getSelectedFile();
                fos=new FileOutputStream(filee);
                fos.write(b);
                setTitle(filee.getName());
                
                fos.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(jf, "Please provide file name!");
        }
    }
    void openPage()
    {
        jfc=new JFileChooser();
        int i=jfc.showOpenDialog(jf);
        if(i==0)
        {
            jta.setText("");
            //----------
            try
            {
                fis=new FileInputStream(jfc.getSelectedFile());
                int s;
                while((s=fis.read())!= -1)
                {
                    jta.append(String.valueOf((char)s));
                }
                fis.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
         }
        else
        {
            
        }
    }
    
    void setTitle(String title) 
    {
        jf.setTitle(title);
    }
}
