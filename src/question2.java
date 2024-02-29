
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class question2 extends JFrame {

    JButton button;
    JCheckBox check1;
    JCheckBox check2;
    JCheckBox check3;
    JComboBox<String> combo;
    JTextField name;
    JLabel lblfinal;

    public question2() {
        create();
        addlistener();
    }

    public void create() {
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel lbltitle, lblprice, greeting, option, guestname;
        lblprice = new JLabel("Hello your payment is : ");
        lblfinal = lblprice;
        Font font = new Font("Arial", Font.PLAIN, 20);
        JTextField txtname;
        guestname = new JLabel("guest name : ");
        txtname = new JTextField(15);
        name = txtname;
        lbltitle = new JLabel("Resort Price Calculator");
        lbltitle.setSize(new Dimension(3, 3));
        lbltitle.setFont(font);
        greeting = new JLabel("Basic price for a room is $200");
        greeting.setFont(font);
        option = new JLabel("Choose option that you want");
        option.setFont(font);
        this.setLayout(new GridBagLayout());
        Font currentFont = lbltitle.getFont();
        Font boldFont = new Font(currentFont.getFontName(), Font.BOLD, currentFont.getSize());
        lbltitle.setFont(boldFont);
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(lbltitle, gbc);
        gbc.gridx = 1;
        this.add(greeting, gbc);
        gbc.gridx = 2;
        this.add(option, gbc);
        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(guestname, gbc);

        panel.add(txtname, gbc);
        this.add(panel, gbc);
        JPanel checkpanel = new JPanel(new GridLayout(1, 3));
        JCheckBox check1 = new JCheckBox("Breakfast$20");

        JCheckBox check2 = new JCheckBox("golf$50");
        JCheckBox check3 = new JCheckBox("Pool$15");
        this.check1 = check1;
        this.check2 = check2;
        this.check3 = check3;
        checkpanel.add(check1);
        checkpanel.add(check2);
        checkpanel.add(check3);
        this.add(checkpanel, gbc);
        JPanel calculate = new JPanel(new GridLayout(1, 2, 10, 10));
        String[] arr = {"Week day(-10%)", "weekend(+30%)"};
        JComboBox<String> combo = new JComboBox<>(arr);
        this.combo = combo;
        JButton button = new JButton("Calculate");
        this.button = button;
        calculate.add(combo);
        calculate.add(button);
        this.add(calculate, gbc);
        this.add(lblprice, gbc);
        //set features

        this.setSize(400, 400);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(1000, 300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addlistener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!name.getText().isBlank()) {
                    double money = 200;
                    if (check1.isSelected()) {
                        money += 20;
                    }
                    if (check2.isSelected()) {
                        money += 50;
                    }
                    if (check3.isSelected()) {
                        money += 15;
                    }
                    if (combo.getSelectedIndex() == 0) {
                        money = money * 0.9;
                    } else {
                        money = money * 1.3;
                    }
                    lblfinal.setText("Hello " + name.getText() + " your payment is : $ " + money);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    if(!name.getText().isEmpty()){
                    int number = Integer.parseInt(name.getText());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "wrong input type.", "Error", JOptionPane.ERROR_MESSAGE);
                    name.setText("");
                }
            }

        });

    }


    

}
