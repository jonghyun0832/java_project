import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    public Frame(int a, int b)  {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel word_panels = new JPanel();
        JPanel word_panel = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();
        JLabel label9 = new JLabel();
        JLabel label10 = new JLabel();
        JLabel label11 = new JLabel();
        JTextArea txtArea = new JTextArea();


        panel.setLayout(new BorderLayout());
        word_panels.setLayout(new BorderLayout());
        word_panel.setLayout(new BoxLayout(word_panel,BoxLayout.Y_AXIS));

        word_panels.add(word_panel,BorderLayout.CENTER);



        panel.add(new JLabel("------------------------------ 당신의 도시 상태입니다 --------------------------------"),BorderLayout.NORTH);
        panel.add(word_panels,BorderLayout.WEST);
        panel.add(txtArea,BorderLayout.CENTER);

        //txtArea.append(c + "");


        frame.add(panel);


        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("도시상태창");
        frame.setLocation(a,b);
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
