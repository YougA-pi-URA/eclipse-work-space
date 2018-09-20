package mycalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Play extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Play play = new Play();
				play.setVisible(true);
				}
			});
	}

	JLabel info = new JLabel();
	JLabel calculation = new JLabel();
	JLabel modulo = new JLabel();
	JLabel result = new JLabel("0 ");

	String regA = "";
	String regB = "";

	double a = 0, b = 0, memory = 0, mod = 0;
	String modeTag = "";

	boolean isZero = true;
	boolean dotUsed = false;

	short mode = 0;

	public Play(){

		setTitle("My Calculator");

		ImageIcon icon = new ImageIcon("./img/icon_105830_128.png");
		setIconImage(icon.getImage());

		int appWidth = 300;
		int appHeight = 400;
		int scrWidth = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice().getDisplayMode().getWidth();
		int scrHeight = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice().getDisplayMode().getHeight();
		int x = (scrWidth - appWidth) / 2;
		int y = (scrHeight - appHeight) / 2;
		setBounds(x, y, appWidth, appHeight);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		setContentPane(panel);

		JPanel register = new JPanel();
		register.setLayout(new GridLayout(2,2));
		register.setBackground(Color.WHITE);

		calculation.setHorizontalAlignment(JLabel.RIGHT);
		result.setHorizontalAlignment(JLabel.RIGHT);

		register.add(info);
		register.add(calculation);
		register.add(modulo);
		register.add(result);

		panel.add(register,BorderLayout.PAGE_START);


		JPanel keyboard = new JPanel();
		keyboard.setLayout(new GridLayout(6,4));


		JButton keyMC = new JButton("MC");
		keyMC.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				memory = 0;
				info.setText("");
			}
		});
		keyboard.add(keyMC);


		JButton keyMR = new JButton("MR");
		keyMR.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				regB = String.valueOf(memory);
				viewRegen();
			}
		});
		keyboard.add(keyMR);


		JButton keyMS = new JButton("MS");
		keyMS.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				memory = Double.parseDouble(result.getText());
				if(memory == 0){
					info.setText("");
				}else{
					info.setText(" M = " + String.valueOf(memory));
				}
			}
		});
		keyboard.add(keyMS);


		JButton keyCLR = new JButton("CLR");
		keyCLR.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(regB.isEmpty()){
					regA = "";
					mode = 0;
					modeTag = "";
					calculation.setText("");
					modulo.setText("");
					result.setText("0 ");
				}else{
					regB = "";
				}
				isZero = true;
				dotUsed = false;

				viewRegen();
			}
		});
		keyboard.add(keyCLR);


		JButton keySqrt = new JButton("√");
		keySqrt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberForm(2);
			}
		});
		keyboard.add(keySqrt);

		JButton keyPer = new JButton("%");
		keyPer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberForm(1);
			}
		});
		keyboard.add(keyPer);

		JButton keySign = new JButton("±");
		keySign.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberForm(0);
			}
		});
		keyboard.add(keySign);

		JButton keyMod = new JButton("÷余り");
		keyMod.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				opelate(mode);
				mode = 5;
				modeTag = "％";
				viewRegen();
			}
		});
		keyboard.add(keyMod);


		JButton key7 = new JButton("7");
		key7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(7);
			}
		});
		keyboard.add(key7);

		JButton key8 = new JButton("8");
		key8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(8);
			}
		});
		keyboard.add(key8);

		JButton key9 = new JButton("9");
		key9.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(9);
			}
		});
		keyboard.add(key9);

		JButton keyDvd = new JButton("÷");
		keyDvd.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				opelate(mode);
				mode = 4;
				modeTag = "÷";
				viewRegen();
			}
		});
		keyboard.add(keyDvd);



		JButton key4 = new JButton("4");
		key4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(4);
			}
		});
		keyboard.add(key4);

		JButton key5 = new JButton("5");
		key5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(5);
			}
		});
		keyboard.add(key5);

		JButton key6 = new JButton("6");
		key6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(6);
			}
		});
		keyboard.add(key6);

		JButton keyMlt = new JButton("×");
		keyMlt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				opelate(mode);
				mode = 3;
				modeTag = "×";
				viewRegen();
			}
		});
		keyboard.add(keyMlt);


		JButton key1 = new JButton("1");
		key1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(1);
			}
		});
		keyboard.add(key1);

		JButton key2 = new JButton("2");
		key2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(2);
			}
		});
		keyboard.add(key2);

		JButton key3 = new JButton("3");
		key3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(3);
			}
		});
		keyboard.add(key3);

		JButton keyMns = new JButton("－");
		keyMns.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				opelate(mode);
				mode = 2;
				modeTag = "－";
				viewRegen();
			}
		});
		keyboard.add(keyMns);


		JButton key0 = new JButton("0");
		key0.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(0);
			}
		});
		keyboard.add(key0);

		JButton keyDot = new JButton(".");
		keyDot.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInput(10);
			}
		});
		keyboard.add(keyDot);

		JButton keyEql = new JButton("＝");
		keyEql.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				opelate(mode);
				mode = 0;
				modeTag = "";
				viewRegen();
			}
		});
		keyboard.add(keyEql);

		JButton keyPls = new JButton("＋");
		keyPls.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				opelate(mode);
				mode = 1;
				modeTag = "＋";
				viewRegen();
			}
		});
		keyboard.add(keyPls);

		//button place comp.
		panel.add(keyboard, BorderLayout.CENTER);
	}

	public void opelate(short mode){
		mod = 0;
		if(regA.isEmpty()){
			a = 0;
		}else{
			a = Double.parseDouble(regA);
		}
		try{
			b = Double.parseDouble(regB);
		}catch(Exception e){
			b = 0;
		}

		switch(mode){
		case 0:	a = b;
				break;

		case 1:	a += b;
		modeTag = "＋";
				break;

		case 2:	a -= b;
				break;

		case 3:	a *= b;
				break;

		case 4:	try{
					a /= b;
				}catch(Exception e){	//ゼロ分はcatchしない。 ==> a == infinity
					a = ERROR;
				}
				break;

		case 5:	try{
					mod = a % b;
					a = (int) (a / b);
					modulo.setText(" あまり " + String.valueOf(mod));
				}catch(Exception e){
					a =ERROR;
				}
				break;
		}

		if(mode != 5 || a == ERROR){
			modulo.setText("");
			mod = 0;
		}



		regA = String.valueOf(a);
		regB = "";

		isZero = true;
		dotUsed = false;
	}

	public void numberForm(int action){
		if(isZero == true){
			b = 0;
		}else{
			b = Double.parseDouble(regB);
		}

		switch(action){
		case 0:	regB = String.valueOf(b * -1);
				break;

		case 1:	regB = String.valueOf(b * 0.01);
				break;

		case 2:	if(b > 0){
					regB = String.valueOf(Math.sqrt(b));
				}
				break;
		}
		viewRegen();
	}

	public void numberInput(int num){
		switch(num){
		case 0:	if(isZero == false || dotUsed == true){
					regB += "0";
				}
				break;

		case 10:if(dotUsed == false){
					if(isZero ==true){
						regB += "0";
					}
					regB += ".";
					dotUsed = true;
				}
				break;

		default:regB += String.valueOf(num);
				isZero = false;
				break;
		}
		viewRegen();
	}

	public void viewRegen(){
		calculation.setText(regA + modeTag + regB + " ");
		if(regB != ""){
			result.setText(regB + " ");
		}else if(regA != ""){
			result.setText(regA + " ");
		}else{
			result.setText("0 ");
		}
		if(mode == 0){
			regA = "";
		}
	}

}
