package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI{
    private int count = 0;
    private int mnoznik = 1;
    private int kmnoznik = 100;
    private int dodajnik = 1;
    private int kdodajnik = 10;
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JLabel label4;

    public GUI()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        label1 = new JLabel("Number of click: 0");
        label2 = new JLabel("dodajnik: 1 mnoznik: 1"+" łącznie: "+ dodajnik*mnoznik);
        label3 = new JLabel("koszt: 100");
        label4 = new JLabel("koszt: 10");
        JLabel label5 = new JLabel(" ");
        JButton button1 = new JButton(new AbstractAction("add ") {
            @Override
            public void actionPerformed(ActionEvent e) {
                count+=dodajnik*mnoznik;
                label1.setText("Number of click: " + count);
            }
        });
        JButton button2 = new JButton(new AbstractAction("Upgrade mnoznik + 1") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count >= kmnoznik) {
                    mnoznik++;
                    count -= kmnoznik;
                    label2.setText("dodajnik:"+dodajnik+" mnoznik: "+mnoznik+" łącznie: "+ dodajnik*mnoznik);
                    label1.setText("Number of click: " + count);
                    kmnoznik=kmnoznik*10;
                    label3.setText("koszt: "+kmnoznik);
                }
            }
        });
        JButton button3 = new JButton(new AbstractAction("Upgrade dodajnik + 1") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count >= kdodajnik) {
                    dodajnik++;
                    count -= kdodajnik;
                    label2.setText("dodajnik:"+dodajnik+" mnoznik: "+mnoznik + " łącznie: "+ dodajnik*mnoznik);
                    label1.setText("Number of click: " + count);
                    kdodajnik=kdodajnik+10;
                    label4.setText("koszt: "+kdodajnik);

                }
            }
        });
        panel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button1);
        panel.add(label5);
        panel.add(button2);
        panel.add(label3);
        panel.add(button3);
        panel.add(label4);
        panel.add(label1);
        panel.add(label2);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Moje GUI");
        frame.setSize(400,200);
        frame.setVisible(true);
    }
}

