package interfaz2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String signo = "";
	private float numeroUno = 0;
	private float numeroDos = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setBackground(new Color(204, 255, 204));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setFont(new Font("Arial", Font.BOLD, 10));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(UIManager.getBorder("SplitPaneDivider.border"));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 128, 192)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(20, 10, 252, 44);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("C");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("");
			}
		});
		btnNewButton.setBounds(20, 64, 46, 41);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("/");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeros = lblNewLabel.getText();

				boolean existe = !numeros.isEmpty() && Character.isDigit(numeros.charAt(numeros.length() - 1));

				if (existe) {
					numeroUno = Float.parseFloat(lblNewLabel.getText());
					lblNewLabel.setText(lblNewLabel.getText() + "/");
					signo = "/";
				}

			}
		});
		btnNewButton_1.setBounds(84, 64, 46, 41);
		contentPane.add(btnNewButton_1);

		JButton btnX = new JButton("X");
		btnX.setBackground(new Color(192, 192, 192));
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeros = lblNewLabel.getText();

				boolean existe = !numeros.isEmpty() && Character.isDigit(numeros.charAt(numeros.length() - 1));

				if (existe) {
					numeroUno = Float.parseFloat(lblNewLabel.getText());
					lblNewLabel.setText(lblNewLabel.getText() + "X");
					signo = "X";
				}
			}

		});
		btnX.setBounds(155, 64, 46, 41);
		contentPane.add(btnX);

		JButton btnNewButton_3 = new JButton("-");
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeros = lblNewLabel.getText();

				boolean existe = !numeros.isEmpty() && Character.isDigit(numeros.charAt(numeros.length() - 1));

				if (existe) {
					numeroUno = Float.parseFloat(lblNewLabel.getText());
					lblNewLabel.setText(lblNewLabel.getText() + "-");
					signo = "-";

				}
			}

		});
		btnNewButton_3.setBounds(226, 64, 46, 41);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeros = lblNewLabel.getText();

				boolean existe = !numeros.isEmpty() && Character.isDigit(numeros.charAt(numeros.length() - 1));

				if (existe) {
					numeroUno = Float.parseFloat(lblNewLabel.getText());
					lblNewLabel.setText(lblNewLabel.getText() + "+");
					signo = "+";

				}
			}

		});
		btnNewButton_2.setBounds(226, 164, 46, 83);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_5 = new JButton("=");
		btnNewButton_5.setBackground(new Color(192, 192, 192));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numeros = lblNewLabel.getText();

				for (int i = 0; i < numeros.length(); i++) {
					if (numeros.charAt(i) == '+' || numeros.charAt(i) == '-' || numeros.charAt(i) == 'X'
							|| numeros.charAt(i) == '/' || numeros.charAt(i) == '^') {

						String numeroParaDos = numeros.substring(i + 1, numeros.length());
						numeroDos = Float.parseFloat(numeroParaDos);
						System.out.println(numeroDos);
						break;
					}
				}

				switch (signo) {

				case "+":
					if ((numeroUno == (int) numeroUno) && (numeroDos == (int) numeroDos)) {
						lblNewLabel.setText(Integer.toString((int) (numeroUno + numeroDos)));
					} else {
						lblNewLabel.setText(Float.toString(numeroUno + numeroDos));
					}
					break;
				case "-":
					if ((numeroUno == (int) numeroUno) && (numeroDos == (int) numeroDos)) {
						lblNewLabel.setText(Integer.toString((int) (numeroUno - numeroDos)));
					} else {
						lblNewLabel.setText(Float.toString(numeroUno - numeroDos));
					}
					break;
				case "X":
					if ((numeroUno == (int) numeroUno) && (numeroDos == (int) numeroDos)) {
						lblNewLabel.setText(Integer.toString((int) (numeroUno * numeroDos)));
					} else {
						lblNewLabel.setText(Float.toString(numeroUno * numeroDos));
					}
					break;
				case "/":

					if (numeroDos != 0) {
						if (numeroUno % numeroDos == 0) {
							lblNewLabel.setText(Integer.toString((int) (numeroUno / numeroDos)));
						} else {
							lblNewLabel.setText(Float.toString(numeroUno / numeroDos));
						}
					} else {
						lblNewLabel.setText("Error");
					}
					break;
				case "^":
					if ((numeroUno == (int) numeroUno) && (numeroDos == (int) numeroDos)) {
						double pow = Math.pow(numeroUno, numeroDos);
						lblNewLabel.setText(Integer.toString((int) pow));
					} else {
						lblNewLabel.setText(Float.toString((float) Math.pow(numeroUno, numeroDos)));
					}
					break;

				}

			}
		});
		btnNewButton_5.setBounds(226, 257, 46, 75);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("1");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "1");

			}
		});
		btnNewButton_4.setBounds(20, 115, 46, 41);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_6 = new JButton("2");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "2");
			}
		});
		btnNewButton_6.setBounds(84, 115, 46, 41);
		contentPane.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("3");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "3");
			}
		});
		btnNewButton_7.setBounds(155, 115, 46, 41);
		contentPane.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("7");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "7");
			}
		});
		btnNewButton_8.setBounds(20, 234, 46, 41);
		contentPane.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("8");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "8");
			}
		});
		btnNewButton_9.setBounds(84, 234, 46, 41);
		contentPane.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("9");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "9");
			}
		});
		btnNewButton_10.setBounds(155, 234, 46, 41);
		contentPane.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("4");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "4");
			}
		});
		btnNewButton_11.setBounds(20, 176, 46, 41);
		contentPane.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("5");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "5");
			}
		});
		btnNewButton_12.setBounds(84, 176, 46, 41);
		contentPane.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("6");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "6");
			}
		});
		btnNewButton_13.setBounds(155, 176, 46, 41);
		contentPane.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("0");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(lblNewLabel.getText() + "0");
			}
		});
		btnNewButton_14.setBounds(20, 291, 46, 41);
		contentPane.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton(".");
		btnNewButton_15.setBackground(new Color(192, 192, 192));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numeros = lblNewLabel.getText();

				boolean existe = !numeros.isEmpty() && Character.isDigit(numeros.charAt(numeros.length() - 1));

				if (existe) {

					lblNewLabel.setText(lblNewLabel.getText() + ".");

				}
			}
		});
		btnNewButton_15.setBounds(84, 291, 46, 41);
		contentPane.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("<");
		btnNewButton_16.setBackground(new Color(192, 192, 192));
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = lblNewLabel.getText();
				if (currentText.length() > 0) {
					lblNewLabel.setText(currentText.substring(0, currentText.length() - 1));
				}
			}
		});
		btnNewButton_16.setBounds(155, 291, 46, 41);
		contentPane.add(btnNewButton_16);

		JButton btnNewButton_3_1 = new JButton("^");
		btnNewButton_3_1.setBackground(new Color(192, 192, 192));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numeros = lblNewLabel.getText();

				boolean existe = !numeros.isEmpty() && Character.isDigit(numeros.charAt(numeros.length() - 1));

				if (existe) {
					numeroUno = Float.parseFloat(lblNewLabel.getText());
					lblNewLabel.setText(lblNewLabel.getText() + "^");
					signo = "^";
				}
			}
		});
		btnNewButton_3_1.setBounds(226, 115, 46, 41);
		contentPane.add(btnNewButton_3_1);

	}
}
