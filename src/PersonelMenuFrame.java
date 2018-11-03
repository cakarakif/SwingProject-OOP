import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class PersonelMenuFrame extends JFrame {

	private JPanel contentPane;
	private static PersonelMenuFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelMenuFrame frame = new PersonelMenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonelMenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 28, 503, 246);
		contentPane.add(scrollPane);
		
		table = new JTable();
		Object[] columns = {"Table No","Order Name","Order Status"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
		scrollPane.setViewportView(table);
		//
		JComboBox comboBoxTable = new JComboBox();
		if (MenuFrame.businessSystem.getTableNumber() != 0) {
			String[] str = new String[MenuFrame.businessSystem.getTableNumber()];
			for (int i = 0; i < str.length; i++) {
				str[i] = Integer.toString(i + 1);
			}
			comboBoxTable.setModel(new DefaultComboBoxModel(str));
		}
		comboBoxTable.setBounds(168, 307, 66, 22);
		contentPane.add(comboBoxTable);
		//"Table No", "Order Name", "Order Status"
		

		JTextArea txtCost = new JTextArea();
		txtCost.setEditable(false);
		txtCost.setBounds(329, 339, 186, 25);
		contentPane.add(txtCost);

		JLabel lblTableNo = new JLabel("Table No:");
		lblTableNo.setBounds(12, 307, 56, 16);
		contentPane.add(lblTableNo);

		JButton btnAddCus = new JButton("Add");
		btnAddCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxTable.getSelectedItem() != null
						&& MenuFrame.businessSystem.getCustomers()[Integer.valueOf((String) comboBoxTable.getSelectedItem())-1] == null)
					MenuFrame.businessSystem.addCustomer(" ", Integer.valueOf((String) comboBoxTable.getSelectedItem())-1);
				else
					JOptionPane.showMessageDialog(frame, "Full Table Or Wrong Choice!");
			}
		});
		btnAddCus.setBounds(12, 447, 97, 25);
		contentPane.add(btnAddCus);

		JButton btnDeleteCus = new JButton("Delete");
		btnDeleteCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTable.getSelectedItem() != null
						&& MenuFrame.businessSystem.getCustomers()[Integer.valueOf((String) comboBoxTable.getSelectedItem())-1] != null)
					MenuFrame.businessSystem.deleteCustomer(Integer.valueOf((String) comboBoxTable.getSelectedItem())-1);
				else
					JOptionPane.showMessageDialog(frame, "Empty Table Or Wrong Choice!");
			}
		});
		btnDeleteCus.setBounds(12, 485, 97, 25);
		contentPane.add(btnDeleteCus);

		Object[] row = new Object[3];
		JButton btnShowCus = new JButton("Show Records");
		btnShowCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				boolean flag;
				for (int i = 0; i < MenuFrame.businessSystem.getCustomers().length; i++) {
					if (MenuFrame.businessSystem.getCustomers()[i] != null) {
						flag=false;
						row[0] = MenuFrame.businessSystem.getCustomers()[i].getCode()+1;
						for (int j = 0; j < MenuFrame.businessSystem.getCustomers()[i].getOrders().length; j++) {
							if (MenuFrame.businessSystem.getCustomers()[i].getOrders()[j] != null) {
								flag = true;
								row[1] = MenuFrame.businessSystem.getCustomers()[i].getOrders()[j].getName();
								row[2] = MenuFrame.businessSystem.getCustomers()[i].getOrders()[j].isStatus() ? "Ready!"
										: "Not Ready!";
								model.addRow(row);
							}
						}
						if (flag == false) {
							row[1] = "No Order";
							row[2] = "-";
							model.addRow(row);
						}

					}

				}
			}
		});
		btnShowCus.setBounds(329, 485, 186, 25);
		contentPane.add(btnShowCus);

		JLabel lblCustomerPanel = new JLabel("Customer Panel:");
		lblCustomerPanel.setBounds(12, 418, 133, 16);
		contentPane.add(lblCustomerPanel);

		JLabel lblOrderPanel = new JLabel("Order Panel:");
		lblOrderPanel.setBounds(168, 418, 116, 16);
		contentPane.add(lblOrderPanel);

		JComboBox comboBoxMenu = new JComboBox();
		Order[] list = MenuFrame.businessSystem.getMenu();
		String[] menu = new String[list.length];
		int count = 0;

		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				menu[i] = list[i].getName();
				count++;
			}
		}
		if (count != 0)
			comboBoxMenu.setModel(new DefaultComboBoxModel(menu));
		comboBoxMenu.setBounds(170, 334, 64, 22);
		contentPane.add(comboBoxMenu);

		JButton btnAddOrder = new JButton("Add");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTable.getSelectedItem() != null && comboBoxMenu.getSelectedItem() != null
						&& MenuFrame.businessSystem.getCustomers()[Integer.valueOf((String)comboBoxTable.getSelectedItem())-1] != null) {
					MenuFrame.businessSystem.enterInfo((String) comboBoxMenu.getSelectedItem(),
							Integer.valueOf((String) comboBoxTable.getSelectedItem())-1);
					MenuFrame.businessSystem.addOrder();
				} else
					JOptionPane.showMessageDialog(frame, "Empty Table Or Wrong Choice!");
			}
		});
		btnAddOrder.setBounds(168, 447, 97, 25);
		contentPane.add(btnAddOrder);

		JButton btnDeleteOrder = new JButton("Delete");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTable.getSelectedItem() != null && comboBoxMenu.getSelectedItem() != null
						&& MenuFrame.businessSystem.getCustomers()[Integer.valueOf((String)comboBoxTable.getSelectedItem())-1] != null) {
					MenuFrame.businessSystem.enterInfo((String) comboBoxMenu.getSelectedItem(),
							Integer.valueOf((String) comboBoxTable.getSelectedItem())-1);
					MenuFrame.businessSystem.deleteOrder();
				} else
					JOptionPane.showMessageDialog(frame, "Empty Table Or Wrong Choice!");
			}
		});
		btnDeleteOrder.setBounds(168, 485, 97, 25);
		contentPane.add(btnDeleteOrder);

		JLabel lblNotification = new JLabel("Notification:");
		lblNotification.setBounds(329, 418, 97, 16);
		contentPane.add(lblNotification);

		JButton btnChangeOrderStatus = new JButton("Change Order Status");
		btnChangeOrderStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTable.getSelectedItem() != null && comboBoxMenu.getSelectedItem() != null
						&& MenuFrame.businessSystem.getCustomers()[Integer.valueOf((String)comboBoxTable.getSelectedItem())-1] != null) {
					MenuFrame.businessSystem.enterInfo((String) comboBoxMenu.getSelectedItem(),
							Integer.valueOf((String) comboBoxTable.getSelectedItem())-1);
					MenuFrame.businessSystem.changeOrderStatus();
				} else
					JOptionPane.showMessageDialog(frame, "Empty Table Or Wrong Choice!");
			}
		});
		btnChangeOrderStatus.setBounds(329, 447, 186, 25);
		contentPane.add(btnChangeOrderStatus);

		JButton btnCalculateCost = new JButton("Calculate Cost");
		btnCalculateCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTable.getSelectedItem() != null
						&& MenuFrame.businessSystem.getCustomers()[Integer.valueOf((String) comboBoxTable.getSelectedItem())-1] != null) {
					MenuFrame.businessSystem.enterInfo("", Integer.valueOf((String)comboBoxTable.getSelectedItem())-1);
					txtCost.setText(String.valueOf(MenuFrame.businessSystem.calculateCost()));
				} else
					JOptionPane.showMessageDialog(frame, "Empty Table Or Wrong Choice!");
			}
		});
		btnCalculateCost.setBounds(329, 307, 186, 25);
		contentPane.add(btnCalculateCost);

		JLabel lblMenu = new JLabel("Menu:");
		lblMenu.setBounds(12, 337, 56, 16);
		contentPane.add(lblMenu);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
		btnExit.setBounds(329, 534, 186, 36);
		contentPane.add(btnExit);
		
		

	}
}
