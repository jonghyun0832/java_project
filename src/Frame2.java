import javax.swing.*;

public class Frame2 extends JPanel {
    public Frame2(JLabel label) {
        JPanel word_panel1 = new JPanel();
        word_panel1.setLayout(new BoxLayout(word_panel1, BoxLayout.X_AXIS));
        word_panel1.add((label));
        word_panel1.add(Box.createHorizontalStrut(20));

    }
}
