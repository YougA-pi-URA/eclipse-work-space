package windowapp;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements ActionListener, ItemListener, WindowListener {

	Label label;
	Button btns[] = new Button[16];
	List list;
	Checkbox check;
	String btnLabels[] ={
			"7","8","9","[＋]",
			"4","5","6","[－]",
			"1","2","3","[×]",
			"0",".","INS","[÷]"
	};
	String regA,regB;
	double toRad;

	WindowTest(){
		regA = "";
		regB = "";
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		addWindowListener(this);
		setSize(240,240);
		setLayout(gridbag);

		label = new Label(regB);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 1;
		gridbag.setConstraints(label, c);
		add(label);

		c.gridwidth = 1;
		c.gridheight = 1;
		for(int i=0;i<16;i++){
			btns[i] = new Button(btnLabels[i]);
			btns[i].addActionListener(this);
			c.gridx = i % 4;
			c.gridy = (i/4) + 1;
			gridbag.setConstraints(btns[i], c);
			add(btns[i]);
		}

		toRad = 1.0;

		list = new List();
		list.add("√");
		list.add("sin");
		list.add("cos");
		list.add("tan");
		list.addItemListener(this);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 3;
		gridbag.setConstraints(list, c);
		add(list);

		check = new Checkbox("Degree");
		check.setState(false);
		check.addItemListener(this);
		c.gridx = 3;
		c.gridwidth = 1;
		gridbag.setConstraints(check, c);
		add(check);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button)e.getSource();
		String lbl = btn.getLabel();
				double a,b,c = 0;

				if(lbl.length()==1)
					regB+=lbl;
				else if(lbl.equals("INS")){
					regA = regB;
					regB = "";
				}else try{
					a = Double.parseDouble(regA);
					b = Double.parseDouble(regB);

					if(lbl.equals("[＋]")) c = a + b;
					if(lbl.equals("[－]")) c = a - b;
					if(lbl.equals("[×]")) c = a * b;
					if(lbl.equals("[÷]")) c = a / b;

					regB = String.valueOf(c);

				}catch(Exception err){
					regB = "Error";
				}

				label.setText(regB);
				System.out.println(regA);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object scr = e.getSource();
		if(scr == list){
			int itemNo = list.getSelectedIndex();
			try{
				double b = Double.parseDouble(regB);
				double c;
				switch(itemNo){
					case 0:
						c = Math.sqrt(b);
						break;
					case 1:
						c = Math.sin(toRad * b);
						break;
					case 2:
						c = Math.cos(toRad * b);
						break;
					case 3:
						c = Math.tan(toRad * b);
						break;
					default:
						c = 0;
				}
				regB = String.valueOf(c);
			}catch(Exception err){
				regB = "Error";
			}

		}
		if(scr == check){
			if(check.getState())
				toRad = Math.PI/180;
			else
				toRad = 1;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Closing");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated");
	}

}
