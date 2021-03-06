package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import helper.QueryDB;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class SearchStores extends JFrame {
    private JButton backButton;
    private JPanel mainPanel;
    private JButton searchButton;
    private JTextField storeIDField;
    private JLabel storeIDLabel;
    private JPanel queryResultPanel;
    private JLabel companyNameLabel;
    private JLabel storeNameLabel;
    private JTextField companyNameField;
    private JTextField storeNameField;
    private JLabel storeStreetLabel;
    private JTextField storeStreetField;
    private JLabel clickInfoLabel;
    private JLabel storeCityLabel;
    private JTextField storeCityField;
    private JLabel storeZipLabel;
    private JTextField storePhoneField;
    private JTextField storeZipField;
    private JLabel storePhoneLabel;
    private JLabel storeStateLabel;
    private JTextField storeStateField;

    public SearchStores() {
        add(mainPanel);
        setTitle("Search Stores");
        setSize(1300, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        populateStores();
        /**
         * Closes the SearchStores window when the back button is clicked.
         */
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //MainScreen MainScreen = new MainScreen();
                //MainScreen.setVisible(true);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateStores();
            }
        });
    }

    private void populateStores() {
        JScrollPane resultScrollPane = getStoreQueryScrollPane();
        queryResultPanel.removeAll();
        queryResultPanel.add(resultScrollPane,
                new GridConstraints(0,
                        0,
                        1,
                        1,
                        GridConstraints.ANCHOR_CENTER,
                        GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null, 0, false));
        queryResultPanel.revalidate();
    }

    private String getQueryString() {
        String result =
                "SELECT store.*, company.name AS 'Parent Company' " +
                        "FROM store, company, owns " +
                        "WHERE store.storeid = owns.storeid " +
                        "AND owns.companyname = company.name ";

        if (!storeIDField.getText().equals("")) {
            result += "AND store.storeid = '" + storeIDField.getText().trim() + "' ";
        }
        if (!storeStreetField.getText().equals("")) {
            result += "AND store.Street = '" + storeStreetField.getText().trim() + "' ";
        }
        if (!companyNameField.getText().equals("")) {
            result += "AND company.name = '" + companyNameField.getText().trim() + "' ";
        }
        if (!storeNameField.getText().equals("")) {
            result += "AND store.name = '" + storeNameField.getText().trim() + "' ";
        }
        if (!storeCityField.getText().equals("")) {
            result += "AND store.city = '" + storeCityField.getText().trim() + "' ";
        }
        if (!storeZipField.getText().equals("")) {
            result += "AND store.zip = '" + storeZipField.getText().trim() + "' ";
        }
        if (!storeStateField.getText().equals("")) {
            result += "AND store.state = '" + storeStateField.getText().trim() + "' ";
        }
        if (!storePhoneField.getText().equals("")) {
            result += "AND store.phone = '" + storePhoneField.getText().trim() + "' ";
        }

        result += ";";

        return result;
    }

    private JScrollPane getStoreQueryScrollPane() {
        JTable queryJTable = QueryDB.getJTable(getQueryString());
        queryJTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                if (target.getSelectedColumn() == 0) {
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    StoreView storeView = new StoreView((int) target.getValueAt(row, column));
                    storeView.setVisible(true);
                }
            }
        });
        return new JScrollPane(queryJTable);
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
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(10, 4, new Insets(10, 10, 10, 10), -1, -1));
        searchButton = new JButton();
        searchButton.setText("Search");
        mainPanel.add(searchButton, new GridConstraints(7, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        storeIDField = new JTextField();
        mainPanel.add(storeIDField, new GridConstraints(2, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        storeIDLabel = new JLabel();
        storeIDLabel.setText("Store ID");
        mainPanel.add(storeIDLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("back");
        mainPanel.add(backButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        queryResultPanel = new JPanel();
        queryResultPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(queryResultPanel, new GridConstraints(9, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        companyNameField = new JTextField();
        mainPanel.add(companyNameField, new GridConstraints(3, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        storeStreetField = new JTextField();
        mainPanel.add(storeStreetField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        storeStreetLabel = new JLabel();
        storeStreetLabel.setText("Store Street");
        mainPanel.add(storeStreetLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        storeNameLabel = new JLabel();
        storeNameLabel.setText("Store Name");
        mainPanel.add(storeNameLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clickInfoLabel = new JLabel();
        clickInfoLabel.setText("Click on a \"Store ID\" to go to that store's page");
        mainPanel.add(clickInfoLabel, new GridConstraints(8, 0, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        storeZipField = new JTextField();
        mainPanel.add(storeZipField, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        storeZipLabel = new JLabel();
        storeZipLabel.setText("Store Zip");
        mainPanel.add(storeZipLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        storePhoneField = new JTextField();
        mainPanel.add(storePhoneField, new GridConstraints(6, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        storePhoneLabel = new JLabel();
        storePhoneLabel.setText("Store Phone");
        mainPanel.add(storePhoneLabel, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        storeCityLabel = new JLabel();
        storeCityLabel.setText("Store City");
        mainPanel.add(storeCityLabel, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        storeCityField = new JTextField();
        mainPanel.add(storeCityField, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        storeNameField = new JTextField();
        mainPanel.add(storeNameField, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        companyNameLabel = new JLabel();
        companyNameLabel.setText("Company Name");
        mainPanel.add(companyNameLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        storeStateLabel = new JLabel();
        storeStateLabel.setText("Store State");
        mainPanel.add(storeStateLabel, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        storeStateField = new JTextField();
        mainPanel.add(storeStateField, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
