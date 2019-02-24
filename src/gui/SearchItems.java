package gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import helper.QueryDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchItems extends JFrame {
    private JButton backButton;
    private JPanel mainPanel;
    private JLabel itemNameLabel;
    private JTextField itemNameField;
    private JLabel upcLabel;
    private JTextField upcField;
    private JButton searchButton;
    private JPanel queryResultPanel;
    private JTextField conditionField;
    private JTextField madeInField;
    private JLabel madeInLabel;
    private JLabel clickInfoLabel;
    private JLabel conditionLabel;
    private JTextField categoryField;
    private JLabel categoryLabel;

    public SearchItems() {
        this("");
    }

    public SearchItems(String category) {
        add(mainPanel);
        setTitle("Search Items");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        categoryField.setText(category);
        populateItems();

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
                populateItems();
            }
        });
    }

    private void populateItems() {
        JScrollPane resultScrollPane = getItemQueryScrollPane();
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
                "SELECT DISTINCT item.upc, item.`condition`, item.name, item.madein " +
                        "FROM item, itemcategory " +
                        "WHERE item.upc=itemcategory.upc " +
                        "AND item.`condition`=itemcategory.`condition` ";

        if (!itemNameField.getText().equals("")) {
            result += "AND item.name = '" + itemNameField.getText().trim() + "' ";
        }
        if (!conditionField.getText().equals("")) {
            result += "AND item.condition = '" + conditionField.getText().trim() + "' ";
        }
        if (!madeInField.getText().equals("")) {
            result += "AND item.madein = '" + madeInField.getText().trim() + "' ";
        }
        if (!upcField.getText().equals("")) {
            result += "AND item.upc = '" + upcField.getText().trim() + "' ";
        }
        if (!categoryField.getText().equals("")) {
            result += "AND itemcategory.category = '" + categoryField.getText().trim() + "' ";
        }

        result += ";";

        return result;
    }

    private JScrollPane getItemQueryScrollPane() {
        JTable queryJTable = QueryDB.getJTable(getQueryString());
        queryJTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                if (target.getSelectedColumn() == 0) {
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    String upc = target.getValueAt(row, column).toString();
                    String condition = target.getValueAt(row, column + 1).toString();
                    ItemView itemView = new ItemView(upc, condition);
                    itemView.setVisible(true);
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
        mainPanel.setLayout(new GridLayoutManager(9, 2, new Insets(10, 10, 10, 10), -1, -1));
        searchButton = new JButton();
        searchButton.setText("Search");
        mainPanel.add(searchButton, new GridConstraints(6, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        upcField = new JTextField();
        mainPanel.add(upcField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        upcLabel = new JLabel();
        upcLabel.setText("UPC");
        mainPanel.add(upcLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("back");
        mainPanel.add(backButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        queryResultPanel = new JPanel();
        queryResultPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(queryResultPanel, new GridConstraints(8, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        conditionField = new JTextField();
        mainPanel.add(conditionField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        madeInField = new JTextField();
        mainPanel.add(madeInField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        madeInLabel = new JLabel();
        madeInLabel.setText("Made In");
        mainPanel.add(madeInLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        itemNameLabel = new JLabel();
        itemNameLabel.setText("Item Name");
        mainPanel.add(itemNameLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clickInfoLabel = new JLabel();
        clickInfoLabel.setText("Click on a \"UPC\" to go to that item's page");
        mainPanel.add(clickInfoLabel, new GridConstraints(7, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        itemNameField = new JTextField();
        mainPanel.add(itemNameField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        conditionLabel = new JLabel();
        conditionLabel.setText("Condition");
        mainPanel.add(conditionLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        categoryField = new JTextField();
        mainPanel.add(categoryField, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        categoryLabel = new JLabel();
        categoryLabel.setText("Category");
        mainPanel.add(categoryLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
