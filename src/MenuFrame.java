import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;

public class MenuFrame extends JFrame{
	

	private JPanel contentPane;
    private static MenuFrame frame;
    private JTextField txtUsername;
    static Business businessSystem;
    private JPasswordField txtPassword;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new MenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MenuFrame(){
		setTitle("Menu");
		initialize("A","1","1");
	}

	public void initialize(String name,String tableNum,String budget) {
		businessSystem = new Business(name, Integer.parseInt(tableNum), 20, Double.parseDouble(budget));
		////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getContentPane().setLayout(null);
		
		ButtonGroup groupButtons=new ButtonGroup();
		
		JRadioButton rdbtnPersonelMenu = new JRadioButton("Personel Menu");
		rdbtnPersonelMenu.setBounds(30, 72, 127, 25);
		getContentPane().add(rdbtnPersonelMenu);
		groupButtons.add(rdbtnPersonelMenu);
		
		JRadioButton rdbtnManagerMenu = new JRadioButton("Manager Menu");
		rdbtnManagerMenu.setBounds(30, 102, 149, 25);
		getContentPane().add(rdbtnManagerMenu);
		groupButtons.add(rdbtnManagerMenu);
		
		JTextArea txtNameArea = new JTextArea();
		txtNameArea.setBackground(Color.LIGHT_GRAY);
		txtNameArea.setForeground(Color.DARK_GRAY);
		txtNameArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtNameArea.setEditable(false);
		txtNameArea.setBounds(88, 13, 154, 36);
		contentPane.add(txtNameArea);
		txtNameArea.setText(" "+name+" System");
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(115, 173, 116, 20);
		contentPane.add(txtPassword);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(227, 52, 1, 1);
		contentPane.add(layeredPane);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(30, 146, 84, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 175, 84, 16);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(115, 143, 116, 22);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnPersonelMenu.isSelected())
					new PersonelMenuFrame().setVisible(true);
				else if(rdbtnManagerMenu.isSelected()&& txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")){
					new ManagerMenuFrame().setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(frame, "Invalid password or username..!");
					
			}
		});
		btnEnter.setBounds(126, 207, 97, 25);
		contentPane.add(btnEnter);
		
		
		//
		
	}
}
