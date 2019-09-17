import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID= 1L;

    public static void main(String[] args) {
        Frame f= new Frame();
        f.display();
    }

    private Panel a= new Panel(940, 560, this);
    private JLabel title= new JLabel();
    private JLabel score= new JLabel();
    private JLabel end= new JLabel();
    private JButton reset= new JButton();

    public Frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Graphics");
        JPanel jp= new JPanel();
        jp.setBackground(Color.BLUE);
        jp.setPreferredSize(new Dimension(1000, 800));
        jp.setLayout(null);

        title.setBounds(20, 20, 6000, 100);
        title.setText("Star Do(d)ge(r)");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Serif", Font.BOLD, 60));

        a.setBounds(20, 120, 940, 560);
        end.setBounds(20, 600, 500, 300);
        end.setFont(new Font("Arial", Font.BOLD, 40));
        end.setForeground(Color.WHITE);

        score.setForeground(Color.WHITE);
        score.setBounds(600, 600, 500, 300);
        score.setFont(new Font("Arial", Font.BOLD, 40));
        score.setText("Score: " + 10000);

        Btn b= new Btn();
        reset.addActionListener(b);
        reset.setBounds(700, 40, 200, 50);
        reset.setText("Reset");
        reset.setFont(new Font("TimesRoman", Font.BOLD, 30));

        jp.add(a);
        jp.add(title);
        jp.add(score);
        jp.add(end);
        jp.add(reset);
        getContentPane().add(jp);
        pack();
    }

    public void update(String s) {
        end.setText(s);
    }

    public void updateScore(int s) {
        score.setText("Score: " + s);
    }

    private class Btn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            a.reset();
        }
    }

    public void display() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

}
