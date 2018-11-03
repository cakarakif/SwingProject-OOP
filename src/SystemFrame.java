import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SystemFrame {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtTableNum;
	private JTextField txtBudget;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemFrame window = new SystemFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SystemFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Cammel", Font.PLAIN, 12));
		frame.setTitle("Business System");
		frame.setBounds(100, 100, 342, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblBusinessName = new JLabel("Business Name");
		lblBusinessName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBusinessName.setBounds(12, 89, 111, 25);
		frame.getContentPane().add(lblBusinessName);

		JLabel lblTableNumber = new JLabel("Table Number");
		lblTableNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTableNumber.setBounds(12, 127, 111, 16);
		frame.getContentPane().add(lblTableNumber);

		JLabel lblNewLabel = new JLabel("Budget");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 156, 56, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblCreateNewSystem = new JLabel("Create New System");
		lblCreateNewSystem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCreateNewSystem.setBounds(69, 43, 160, 16);
		frame.getContentPane().add(lblCreateNewSystem);

		txtName = new JTextField();
		txtName.setBounds(159, 91, 116, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtTableNum = new JTextField();
		txtTableNum.setBounds(159, 125, 116, 22);
		frame.getContentPane().add(txtTableNum);
		txtTableNum.setColumns(10);

		txtBudget = new JTextField();
		txtBudget.setBounds(159, 158, 116, 22);
		frame.getContentPane().add(txtBudget);
		txtBudget.setColumns(10);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtName.getText().equals("") && !txtTableNum.getText().equals("") && !txtBudget.getText().equals("")) {
					MenuFrame menu=new MenuFrame();
					menu.setVisible(true);
					menu.initialize(txtName.getText(),txtTableNum.getText(),txtBudget.getText());
					frame.setVisible(false);
					
				} else {
					JOptionPane.showMessageDialog(frame, "Fill The All Choices");
				}
			}
		});
		btnCreate.setBounds(169, 205, 97, 25);
		frame.getContentPane().add(btnCreate);
	}
}
