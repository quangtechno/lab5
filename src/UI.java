
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class UI {
    
    static JTextField txtid, txttitle, txtprice, txtyor;
    static JButton add, show, clear;
    
    static JRadioButton radio1, radio2;
    static JComboBox<String> combo;
    static List<CD> list = new ArrayList<CD>();
    
    public static void main(String[] args) {
        
        txttitle = new JTextField(10);
        txtprice = new JTextField(10);
        txtyor = new JTextField(20);
        txtid = new JTextField(10);
        GridBagConstraints gbc = new GridBagConstraints();
        JFrame frame = new JFrame();
        JPanel mainpanel = new JPanel(new GridBagLayout());
        JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6;
        lbl1 = new JLabel("CD ID");
        lbl2 = new JLabel("CD Title");
        lbl3 = new JLabel("CD Collection");
        lbl4 = new JLabel("CD Price");
        lbl5 = new JLabel("Year Of Release");
        lbl6 = new JLabel("CD Type");
        
        add = new JButton("ADD");
        show = new JButton("SHOW");
        clear = new JButton("CLEAR");
        mainpanel.add(lbl1);
        mainpanel.add(txtid);
        gbc.gridy = 1;
        mainpanel.add(lbl2, gbc);
        mainpanel.add(txttitle, gbc);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JPanel temp = new JPanel(new GridLayout(1, 5));
        temp.add(lbl3);
        String[] arr = {"game", "video", "music"};
        combo = new JComboBox<>(arr);
        temp.add(combo);
        temp.add(lbl6);
        radio1 = new JRadioButton("VCD");
        radio2 = new JRadioButton("CD");
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        temp.add(radio1);
        temp.add(radio2);
        
        mainpanel.add(temp, gbc);
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainpanel.add(lbl4, gbc);
        gbc.gridy = 3;
        gbc.gridx = 1;
        mainpanel.add(txtprice, gbc);
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.CENTER;
        mainpanel.add(lbl5, gbc);
        gbc.gridy = 5;
        gbc.gridx = 0;
        mainpanel.add(txtyor, gbc);
        gbc.gridx = 1;
        
        mainpanel.add(add, gbc);
        gbc.gridy = 6;
        gbc.gridx = 0;
        mainpanel.add(clear, gbc);
        gbc.gridx = 1;
        mainpanel.add(show, gbc);
        addListener();
        frame.add(mainpanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setMinimumSize(new Dimension(500, 500));
    }
    
    public static void addListener() {
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                CD temp = new CD();
                String title = txttitle.getText();
                String id = txtid.getText();
               
                String type;
                if(radio1.isSelected()){
                    type=radio1.getText();
                }else{
                    type=radio2.getText();
                }
                 temp.setType(type);
                if (!txtprice.getText().isBlank() && !txtyor.getText().isBlank()) {
                    try {
                        double price = Integer.parseInt(txtprice.getText());
                        int yor = Integer.parseInt(txtyor.getText());
                        temp.setPrice(price);
                        temp.setYearOfRelease(yor);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "wrong input type");
                         clear();
                    return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "empty textfield");
                    clear();
                    return;
                }
                String collection = (String) combo.getSelectedItem();
                temp.setCollection(collection);
                if (!id.isBlank()) {
                    temp.setCd_ID(id);
                } else {
                    JOptionPane.showMessageDialog(null, "empty textfield");
                    clear();
                    return;
                    
                }
                if (!title.isBlank()) {
                    temp.setTitle(title);
                } else {
                    JOptionPane.showMessageDialog(null, "empty textfield");
                    clear();
                    return;
                }
                list.add(temp);
                System.out.println("add successfully");
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showall();
             }
        });
    }
    
    public static void clear() {
        txtid.setText("");
        txtprice.setText("");
        txttitle.setText("");
        txtyor.setText("");
        radio1.setSelected(true);
        combo.setSelectedIndex(0);
        
    }
    
    public static void showall() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
