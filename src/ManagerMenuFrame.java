import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMenuFrame extends JFrame {

	private static ManagerMenuFrame frame;
	private JPanel contentPane;
	private JTextField txtNameAddMenu;
	private JTextField txtMenuAddPrice;
	private JTextField txtDeleteMenu;
	private final JButton btnExit = new JButton("Exit");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ManagerMenuFrame();
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
	public ManagerMenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalBudget = new JLabel("Total Budget:");
		lblTotalBudget.setBounds(12, 81, 86, 16);
		contentPane.add(lblTotalBudget);
		
		JLabel lblAddMenu = new JLabel("Add Menu:");
		lblAddMenu.setBounds(12, 178, 86, 16);
		contentPane.add(lblAddMenu);
		
		JLabel lblDeleteMenu = new JLabel("Delete Menu:");
		lblDeleteMenu.setBounds(12, 299, 86, 16);
		contentPane.add(lblDeleteMenu);
		
		txtNameAddMenu = new JTextField();
		txtNameAddMenu.setBounds(141, 175, 104, 22);
		contentPane.add(txtNameAddMenu);
		txtNameAddMenu.setColumns(10);
		
		txtMenuAddPrice = new JTextField();
		txtMenuAddPrice.setBounds(259, 175, 116, 22);
		contentPane.add(txtMenuAddPrice);
		txtMenuAddPrice.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(167, 156, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(282, 156, 56, 16);
		contentPane.add(lblPrice);
		
		txtDeleteMenu = new JTextField();
		txtDeleteMenu.setBounds(141, 296, 116, 22);
		contentPane.add(txtDeleteMenu);
		txtDeleteMenu.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(167, 267, 56, 16);
		contentPane.add(lblName_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtNameAddMenu.getText().equals("") && !txtMenuAddPrice.getText().equals("")){
					MenuFrame.businessSystem.addMenu(Double.parseDouble(txtMenuAddPrice.getText()),txtNameAddMenu.getText());
					JOptionPane.showMessageDialog(frame, "Added!");
				}else{
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Fill The All Choices");
				}
			}
		});
		btnAdd.setBounds(278, 210, 97, 25);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtDeleteMenu.getText().equals("")){
					MenuFrame.businessSystem.deleteMenu(txtNameAddMenu.getText());
					JOptionPane.showMessageDialog(frame, "Deleted!");
				}else{
					JOptionPane.showMessageDialog(frame, "Fill The All Choices");
				}
			}
		});
		btnDelete.setBounds(278, 295, 97, 25);
		contentPane.add(btnDelete);
		
		JTextArea txtTotalBudget = new JTextArea();
		txtTotalBudget.setEditable(false);
		txtTotalBudget.setBounds(141, 83, 104, 28);
		contentPane.add(txtTotalBudget);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTotalBudget.setText(String.valueOf(MenuFrame.businessSystem.getBudget()));
			}
		});
		btnShow.setBounds(282, 83, 97, 25);
		contentPane.add(btnShow);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
		btnExit.setBounds(141, 364, 234, 36);
		contentPane.add(btnExit);
		
		
	}
}
