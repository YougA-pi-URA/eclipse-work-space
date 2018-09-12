package mycalculator;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Play {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();

				int appWidth = 300;
				int appHeight = 400;
				int scrWidth = GraphicsEnvironment.getLocalGraphicsEnvironment()
						.getDefaultScreenDevice().getDisplayMode().getWidth();
				int scrHeight = GraphicsEnvironment.getLocalGraphicsEnvironment()
						.getDefaultScreenDevice().getDisplayMode().getHeight();
				int x = (scrWidth - appWidth) / 2;
				int y = (scrHeight - appHeight) / 2;
				frame.setBounds(x, y, appWidth, appHeight);

				ImageIcon icon = new ImageIcon("./img/icon_105830_128.png");
				frame.setIconImage(icon.getImage());

				frame.setTitle("My Calculator");

				frame.setLayout(new GridLayout(4,4));
				for(int i = 0; i < 16; i++){
					JButton btn = new JButton("No."+(i+1));
					frame.add(btn);
				}


				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});
	}

}