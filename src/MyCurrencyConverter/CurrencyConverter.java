package MyCurrencyConverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.*;

/**
 * A currency converter GUI application that converts currencies between different countries.
 */
public class CurrencyConverter extends JFrame implements ActionListener {
    JComboBox<String> fromCountry, toCountry;
    JButton convert, reset, exit;
    JLabel fromUnit, toUnit;
    TextField fromText;
    TextField myResult;

    String[] currencyUnits = {
            "units", "Pakistani Rupee", "US Dollar", "Canadian Dollar", "Hungarian Forints", "Euro", "Japanese Yen"
    };

    double Paki_Rupee = 364.04;
    double US_Dollar = 1.31;
    double Canadian_Dollar = 1.71;
    double Hungarian_Forint = 434.18;
    double Euro = 1.16;
    double Japanese_Yen = 183.36;

    /**
     * Constructs a CurrencyConverter object and sets up the GUI.
     */
    public CurrencyConverter() {
        setBounds(300, 60, 700, 600);
        getContentPane().setBackground(Color.GRAY);
        setResizable(false);

        // Title Label
        JLabel title = new JLabel("Convert Currencies");
        title.setBounds(150, 30, 650, 60);
        title.setFont(new Font("Sen-Serif", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        add(title);

        // "FROM" Label
        JLabel from = new JLabel("FROM ");
        from.setBounds(90, 160, 100, 50);
        from.setFont(new Font("Georgia", Font.BOLD, 20));
        from.setForeground(Color.BLACK);
        add(from);

        // ComboBox to select "From" country
        fromCountry = new JComboBox<>(new String[]{"----------", "Pakistan", "USA", "Canada", "Hungary", "Euro", "Japan"});
        fromCountry.setBounds(200, 165, 180, 40);
        fromCountry.setFont(new Font("Sen_Serif", Font.BOLD, 20));

        fromCountry.addItemListener(e -> fromCountryItemStateChanged(e));
        add(fromCountry);

        // Text field to input the value to convert
        fromText = new TextField();
        fromText.setBounds(400, 165, 100, 40);
        fromText.setFont(new Font("Georgia", Font.BOLD, 20));
        fromText.setForeground(Color.BLACK);
        add(fromText);

        // "TO" Label
        JLabel to = new JLabel("To");
        to.setBounds(110, 240, 100, 50);
        to.setFont(new Font("Georgia", Font.BOLD, 20));
        to.setForeground(Color.BLACK);
        add(to);

        // ComboBox to select "To" country
        toCountry = new JComboBox<>(new String[]{"----------", "Pakistan", "USA", "Canada", "Hungary", "Euro", "Japan"});
        toCountry.setBounds(200, 240, 180, 40);
        toCountry.setFont(new Font("Georgia", Font.BOLD, 20));
        toCountry.addItemListener(e -> toCountryItemStateChanged(e));
        add(toCountry);

        // Text field to display the converted value
        myResult = new TextField("");
        myResult.setEditable(false);
        myResult.setBounds(400, 240, 100, 40);
        myResult.setFont(new Font("Georgia", Font.BOLD, 20));
        myResult.setForeground(Color.BLACK);
        add(myResult);

        // Convert button
        convert = new JButton("Convert");
        convert.setBounds(300, 300, 150, 40);
        convert.setFont(new Font("Georgia", Font.BOLD, 15));
        convert.addActionListener(this);
        add(convert);

        // Reset button
        reset = new JButton("Reset");
        reset.setBounds(300, 360, 150, 40);
        reset.setFont(new Font("Georgia", Font.BOLD, 15));
        reset.addActionListener(e -> jButton3ActionPerformed(e));
        add(reset);

        // Exit button
        exit = new JButton("Exit");
        exit.setBounds(300, 420, 150, 40);
        exit.setFont(new Font("Georgia", Font.BOLD, 15));
        exit.addActionListener(e -> jButton4ActionPerformed(e));
        add(exit);

        // Label to display the unit of the selected "From" country
        fromUnit = new JLabel();
        fromUnit.setBounds(570, 165, 100, 40);
        fromUnit.setFont(new Font("Georgia", Font.BOLD, 15));
        add(fromUnit);

        // Label to display the unit of the selected "To" country
        toUnit = new JLabel();
        toUnit.setBounds(570, 240, 100, 40);
        toUnit.setFont(new Font("Georgia", Font.BOLD, 15));
        add(toUnit);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Resets the panel to its initial state.
     * This method is called when the Reset button is clicked.
     * @param evt the action event
     */
    private void jButton3ActionPerformed(ActionEvent evt) {
        fromCountry.setSelectedIndex(0);
        toCountry.setSelectedIndex(0);
        fromText.setText(null);
        myResult.setText(null);
    }

    /**
     * Exits the program.
     * This method is called when the Exit button is clicked.
     * @param evt the action event
     */
    private void jButton4ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    /**
     * Updates the units based on the selected "From" country.
     * This method is called when the "From" country selection is changed.
     * @param evt the item event
     */
    private void fromCountryItemStateChanged(ItemEvent evt) {
        int position = fromCountry.getSelectedIndex();
    }

    /**
     * Updates the units based on the selected "To" country.
     * This method is called when the "To" country selection is changed.
     * @param evt the item event
     */
    private void toCountryItemStateChanged(ItemEvent evt) {
        int position = toCountry.getSelectedIndex();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convert) {
            if (fromCountry.getSelectedIndex() == 0 || toCountry.getSelectedIndex() == 0 || fromText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);
            } else {
                double amountToChange = Double.parseDouble(fromText.getText());
                double amountInPounds = 0.0;
                // Convert the amount to pounds based on the selected "From" country
                switch (fromCountry.getSelectedItem().toString()) {
                    case "Pakistan":
                        amountInPounds = amountToChange / Paki_Rupee;
                        break;
                    case "USA":
                        amountInPounds = amountToChange / US_Dollar;
                        break;
                    case "Canada":
                        amountInPounds = amountToChange / Canadian_Dollar;
                        break;
                    case "Hungary":
                        amountInPounds = amountToChange / Hungarian_Forint;
                        break;
                    case "Euro":
                        amountInPounds = amountToChange / Euro;
                        break;
                    case "Japan":
                        amountInPounds = amountToChange / Japanese_Yen;
                        break;
                    default:
                        amountInPounds = 0.0;
                }

                double newAmount = 0.0;
                // Convert the amount in pounds to the selected "To" country
                switch (toCountry.getSelectedItem().toString()) {
                    case "Pakistan":
                        newAmount = amountInPounds * Paki_Rupee;
                        break;
                    case "USA":
                        newAmount = amountInPounds * US_Dollar;
                        break;
                    case "Canada":
                        newAmount = amountInPounds * Canadian_Dollar;
                        break;
                    case "Hungary":
                        newAmount = amountInPounds * Hungarian_Forint;
                        break;
                    case "Euro":
                        newAmount = amountInPounds * Euro;
                        break;
                    case "Japan":
                        newAmount = amountInPounds * Japanese_Yen;
                        break;
                    default:
                        newAmount = amountInPounds = 0.0;
                }
                String amount = String.format("%.2f", newAmount);
                myResult.setText(amount);
            }
        }
    }
}
