package com.example.hookah.frame;

import com.example.hookah.flags.Flags;
import com.example.hookah.model.Coals;
import com.example.hookah.model.Logger;
import com.example.hookah.model.Tobacco;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* class for creating a main frame
* that acts as a user interface
 */
public class Frame extends JFrame {
    private Label text;
    private Input inputUsername;
    private JPasswordField inputPassword;
    private final Flags flags;
    private final List<String> selectionList;
    private final Map<String, Integer> selection;
    private String newTobaccoName;
    private int price;

    public Frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 800);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Admin");
        this.getContentPane().setBackground(new Color(250, 250, 250));
        this.setFocusable(true);
        this.setVisible(true);
        selectionList = new ArrayList<>();
        selection = new HashMap<>();
        flags = new Flags();
    }

    public void enter(String message) {
        this.getContentPane().removeAll();
        text = new Label(600, 250, 250, 60);
        inputUsername = new Input(600, 330, 250, 30);
        inputPassword = new JPasswordField();
        inputPassword.setLayout(null);
        inputPassword.setForeground(new Color(224, 3, 20));
        inputPassword.setFont(new Font("MV Boli", Font.PLAIN, 15));
        inputPassword.setBackground(new Color(255, 255, 255));
        inputPassword.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        inputPassword.setHorizontalAlignment(JLabel.CENTER);
        inputPassword.setOpaque(true);
        inputPassword.setVisible(true);
        inputPassword.setBounds(600, 370, 250, 30);
        Button enterButton = new Button(665, 430, 120, 30, "enter");
        text.setText(message);
        this.add(text);
        this.add(inputUsername);
        this.add(inputPassword);
        enterButton.addActionListener(e -> flags.setEnter(true));
        this.add(enterButton);
        this.repaint();
    }

    public void homePage(List<Tobacco> tobacco, List<Coals> coals, List<Logger> loggers) {
        this.getContentPane().removeAll();
        text = new Label(600, 10, 250, 30);
        text.setText("Hookah Data Base");
        this.add(text);
        String[][] tobaccoList = new String[tobacco.size()][3];
        for (int i = 0; i < tobacco.size(); i++) {
            tobaccoList[i] = new String[]{" " + tobacco.get(i).getId().toString(),
                    tobacco.get(i).getNameOfTobacco(),
                    tobacco.get(i).getAmountOfTobacco() + " g"
            };
        }
        String[] tobaccoColumn = {"id", "name of tobacco", "amount"};
        JTable tobaccoTable = new Table(tobaccoList, tobaccoColumn, 291);
        JScrollPane scrollPane = new JScrollPane(tobaccoTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        scrollPane.setBounds(25, 50, 400, 500);
        this.add(scrollPane);
        Button addAlertButtonTobacco = new Button(25, 560, 135, 30, "add new tobacco");
        addAlertButtonTobacco.addActionListener(e -> {
            AlertFrame changeTobaccoAlert = new AlertFrame(100);
            Input inputName = new Input(25, 20, 150, 30);
            changeTobaccoAlert.add(inputName);
            Input inputCount = new Input(205, 20, 50, 30);
            changeTobaccoAlert.add(inputCount);
            Button changeCoals = new Button(285, 20, 80, 30, "send");
            changeCoals.addActionListener(e1 -> {
                flags.setAddNewTobacco(true);
                selectionList.add(inputName.getText());
                selection.put(selectionList.get(0), Integer.parseInt(inputCount.getText()));
                changeTobaccoAlert.dispose();
            });
            changeTobaccoAlert.add(changeCoals);
            changeTobaccoAlert.repaint();
        });
        this.add(addAlertButtonTobacco);
        Button alertButtonTobacco = new Button(260, 560, 165, 30, "edit selection tobacco");
        alertButtonTobacco.addActionListener(e -> {
            AlertFrame changeTobaccoAlert = new AlertFrame(100);
            String selectedName = tobaccoList[tobaccoTable.getSelectedRow()][1];
            Input label = new Input(25, 20, 150, 30);
            label.setText(selectedName);
            changeTobaccoAlert.add(label);
            Input input = new Input(205, 20, 50, 30);
            changeTobaccoAlert.add(input);
            Button changeCoals = new Button(285, 20, 80, 30, "send");
            changeCoals.addActionListener(e1 -> {
                flags.setChangeTobacco(true);
                if (!label.getText().equals(selectedName)) {
                    newTobaccoName = label.getText();
                } else {
                    newTobaccoName = "";
                }
                selectionList.add(selectedName);
                int amount;
                if (input.getText().equals("")){
                    amount = 0;
                } else {
                    amount = Integer.parseInt(input.getText());
                }
                selection.put(selectionList.get(0), amount);
                changeTobaccoAlert.dispose();
            });
            changeTobaccoAlert.add(changeCoals);
            changeTobaccoAlert.repaint();
        });
        this.add(alertButtonTobacco);
        String[][] coalsList = new String[coals.size()][3];
        for (int i = 0; i < coals.size(); i++) {
            coalsList[i] = new String[]{" " + coals.get(i).getId().toString(),
                    coals.get(i).getNameOfCoals(),
                    coals.get(i).getAmountOfCoals() + ""
            };
        }
        String[] coalsColumn = {"id", "name of coals", "amount"};
        JTable coalsTable = new Table(coalsList, coalsColumn, 291);
        JScrollPane panel = new JScrollPane(coalsTable);
        panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panel.setBounds(25, 600, 400, 114);
        this.add(panel);
        Button alertButtonCoals = new Button(260, 724, 165, 30, "edit selection coals");
        alertButtonCoals.addActionListener(e -> {
            AlertFrame changeCoalsAlert = new AlertFrame(100);
            String selectedName = coalsList[coalsTable.getSelectedRow()][1];
            Label label = new Label(25, 20, 150, 30);
            label.setText(selectedName);
            changeCoalsAlert.add(label);
            Input input = new Input(205, 20, 50, 30);
            changeCoalsAlert.add(input);
            Button changeCoals = new Button(285, 20, 80, 30, "send");
            changeCoals.addActionListener(e1 -> {
                flags.setChangeCoals(true);
                selectionList.add(selectedName);
                selection.put(selectionList.get(0), Integer.parseInt(input.getText()));
                changeCoalsAlert.dispose();
                });
            changeCoalsAlert.add(changeCoals);
            changeCoalsAlert.repaint();
        });
        this.add(alertButtonCoals);
        Button alertButtonHookah = new Button(800, 100, 150, 30, "new order a hookah");
        alertButtonHookah.addActionListener(e -> {
            AlertFrame newOrderAlert = new AlertFrame(300);
            ComboBox[] comboBoxes = new ComboBox[3];
            Input[] inputs = new Input[3];
            for (int i = 0; i < 3; i++) {
                final int f = i;
                comboBoxes[f] = new ComboBox(25, 20 + f * 50, 250, 30);
                tobacco.forEach(q -> comboBoxes[f].addItem(q.getNameOfTobacco()));
                newOrderAlert.add(comboBoxes[f]);
                inputs[f] = new Input(305, 20 + f * 50, 70, 30);
                newOrderAlert.add(inputs[f]);
            }
            Label coalsInput = new Label(30, 170, 150, 30);
            coalsInput.setText("amount of coals");
            coalsInput.setBorder(null);
            newOrderAlert.add(coalsInput);
            Input amountOfCoalsInput = new Input(200, 170, 50, 30);
            newOrderAlert.add(amountOfCoalsInput);
            Label orderInput = new Label(65, 220, 120, 30);
            orderInput.setText("order price");
            orderInput.setBorder(null);
            newOrderAlert.add(orderInput);
            Input orderPriceInput = new Input(210, 220, 50, 30);
            newOrderAlert.add(orderPriceInput);
            Button newOrder1 = new Button(285, 220, 80, 30, "send");
            newOrder1.addActionListener(e1 -> {
                flags.setChangeCoals(true);
                flags.setChangeTobacco(true);
                selectionList.add("Piece coals");
                selection.put(selectionList.get(0), Integer.parseInt(amountOfCoalsInput.getText()) * -1);
                for (int i = 0; i < 3; i++) {
                    if (!comboBoxes[i].getSelectedItem().toString().equals(" ")) {
                        selectionList.add(comboBoxes[i].getSelectedItem().toString());
                        selection.put(comboBoxes[i].getSelectedItem().toString(),
                                Integer.parseInt(inputs[i].getText()) * -1);
                    }
                }
                if (orderPriceInput.getText().equals("")) {
                    price = 0;
                } else {
                    price = Integer.parseInt(orderPriceInput.getText());
                }
                newOrderAlert.dispose();
            });
            newOrderAlert.add(newOrder1);
            newOrderAlert.repaint();
        });
        this.add(alertButtonHookah);
        int size = loggers.size();
        String[][] loggerList = new String[loggers.size()][3];
        for (int i = 0; i < size; i++) {
            loggerList[i] = new String[]{" " + loggers.get(size - i - 1).getId().toString(),
                    loggers.get(size - i - 1).getLoggerTobaccos().toString(),
                    String.valueOf(loggers.get(size - i - 1).getAmountOfCoals()),
                    String.valueOf(loggers.get(size - i - 1).getPrice())
            };
        }
        String[] loggerColumn = {"id", "log", "coals", "price"};
        JTable loggerTable = new Table(loggerList, loggerColumn, 691);
        JScrollPane loggerPane = new JScrollPane(loggerTable);
        loggerPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        loggerPane.setBounds(500, 350, 900, 400);
        this.add(loggerPane);
        this.repaint();
    }

    public Input getInputUsername() {
        return inputUsername;
    }

    public JPasswordField getInputPassword() {
        return inputPassword;
    }

    public Flags getFlags() {
        return flags;
    }

    public List<String> getSelectionList() {
        return selectionList;
    }

    public Map<String, Integer> getSelection() {
        return selection;
    }

    public String getNewTobaccoName() {
        return newTobaccoName;
    }

    public void setNewTobaccoName(String newTobaccoName) {
        this.newTobaccoName = newTobaccoName;
    }

    public int getPrice() {
        return price;
    }
}
