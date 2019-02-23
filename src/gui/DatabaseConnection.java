package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import helper.BuildDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseConnection extends JFrame {
    private JPanel dbConnectionPanel;
    private JLabel urlLabel;
    private JTextField urlField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel panelLabel;
    private JTextField usernameField;
    private JTextField passwordField;
    private JCheckBox newDBCheckBox;
    private JLabel newDBCheckBoxLabel1;
    private JLabel newDBCheckBoxLabel2;
    private JLabel driverLabel;
    private JTextField driverField;
    private JButton connectButton;

    public DatabaseConnection() {
        this(true);
    }

    //TODO Make this frame pull information from MainScreen if it is present

    public DatabaseConnection(Boolean createMainScreen) {
        add(dbConnectionPanel);
        setSize(800, 350);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen.url = urlField.getText().trim();
                MainScreen.user = usernameField.getText().trim();
                MainScreen.password = passwordField.getText().trim();
                MainScreen.driver = driverField.getText().trim();
                if (newDBCheckBox.isSelected() == true) {
                    BuildDB.buildDB(MainScreen.driver,
                            MainScreen.url,
                            MainScreen.user,
                            MainScreen.password);
                }
                if (createMainScreen == true) {
                    MainScreen mainScreen = new MainScreen();
                    mainScreen.setVisible(true);
                }
                dispose();
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        dbConnectionPanel = new JPanel();
        dbConnectionPanel.setLayout(new GridLayoutManager(8, 2, new Insets(10, 10, 10, 10), -1, -1));
        urlField = new JTextField();
        urlField.setText("jdbc:mysql://localhost/WTFoamroller?autoReconnect=true&useSSL=false");
        urlField.setToolTipText("");
        dbConnectionPanel.add(urlField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        urlLabel = new JLabel();
        urlLabel.setText("SQL Server URL");
        dbConnectionPanel.add(urlLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        usernameField = new JTextField();
        usernameField.setText("root");
        dbConnectionPanel.add(usernameField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        usernameLabel = new JLabel();
        usernameLabel.setText("SQL Server Username");
        dbConnectionPanel.add(usernameLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        panelLabel = new JLabel();
        panelLabel.setEnabled(true);
        panelLabel.setText("Database Connection Information");
        dbConnectionPanel.add(panelLabel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordLabel = new JLabel();
        passwordLabel.setText("SQL Server Password");
        dbConnectionPanel.add(passwordLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        passwordField = new JTextField();
        passwordField.setText("root");
        dbConnectionPanel.add(passwordField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        newDBCheckBoxLabel1 = new JLabel();
        newDBCheckBoxLabel1.setText("Create a new database on the server?");
        dbConnectionPanel.add(newDBCheckBoxLabel1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(120, 16), null, 0, false));
        newDBCheckBox = new JCheckBox();
        newDBCheckBox.setSelected(true);
        newDBCheckBox.setText("");
        dbConnectionPanel.add(newDBCheckBox, new GridConstraints(5, 1, 2, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        newDBCheckBoxLabel2 = new JLabel();
        newDBCheckBoxLabel2.setText("This will be a database called \"WTFoamroller\"");
        dbConnectionPanel.add(newDBCheckBoxLabel2, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        connectButton = new JButton();
        connectButton.setText("Connect");
        dbConnectionPanel.add(connectButton, new GridConstraints(7, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        driverLabel = new JLabel();
        driverLabel.setText("Driver Name");
        dbConnectionPanel.add(driverLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(129, 16), null, 0, false));
        driverField = new JTextField();
        driverField.setText("com.mysql.jdbc.Driver");
        dbConnectionPanel.add(driverField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        urlLabel.setLabelFor(urlField);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return dbConnectionPanel;
    }

}
