package gui;

import com.intellij.uiDesigner.core.GridLayoutManager;
import helper.QueryDB;

import javax.swing.*;
import java.awt.*;

public class ShowAllStores extends JFrame {
    private JPanel panel1;

    public ShowAllStores() {
        add(panel1);
        setTitle("Show All Stores");
        setSize(1200, 600);
        setLocationRelativeTo(null);

        String query =
                "SELECT store.*,company.name AS 'Parent Company' FROM store,company,owns WHERE store.storeid = owns.storeid AND owns.companyname = company.name";
        // QueryDB queryDB = new QueryDB();
        add(QueryDB.getScrollPane(query));
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
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
