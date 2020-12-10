package windows;
//Marco con lamina y botones

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Rocket.Cohete;

class Marco extends JFrame {

	protected Cohete cohete;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Marco(Cohete cohete) throws Exception {

		this.cohete = cohete;
		
		createWindow();

		

	}
	
	// crear ventana
	public void createWindow() {
		setBounds(400, 300, 500, 400);
		setPreferredSize(new Dimension(600, 450));
		pack();

		setTitle("C�digo Cohete: " + this.cohete.getCode());
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new BorderLayout());

		JPanel laminaPropulsores = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JPanel laminaPropulsores = new JPanel();
//		setContentPane(laminaPropulsores);
//		laminaPropulsores.setLayout(new BoxLayout(laminaPropulsores, BoxLayout.PAGE_AXIS));

		ponerPropulsores(this.cohete, laminaPropulsores);

		add(laminaPropulsores, BorderLayout.NORTH);
		
		
		
		
		
//		JPanel p = new JPanel();
//		setContentPane(p);
//		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
//
//		JPanel panel1 = new JPanel();
//		panel1.setBackground(Color.RED);
//		JPanel panel2 = new JPanel();
//		panel2.setBackground(Color.GREEN);
//		p.add(panel1);
//		p.add(panel2);
//		
		
		
		
		
		

		JPanel laminaBotones = new JPanel();
		laminaBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); 

		ponerBoton(laminaBotones, "Acelera", new ActionListener() {


			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.acelerar();
//					laminaPropulsores.removeAll();
//					ponerPropulsores(cohete, laminaPropulsores);
//					laminaPropulsores.validate();
//					laminaPropulsores.repaint();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		ponerBoton(laminaBotones, "Frena", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.frenar();
//					laminaPropulsores.removeAll();
//					ponerPropulsores(cohete, laminaPropulsores);
//					laminaPropulsores.validate();
//					laminaPropulsores.repaint();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		add(laminaBotones, BorderLayout.SOUTH);
	}

//ponemos texto de los propulsores
	public void ponerPropulsores(Cohete rocket, Container c) {
		JLabel prop1 = new JLabel();		
		prop1.setBackground(Color.RED);
		
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.GREEN);
		
		
		
		
//		JLabel jj = new JLabel();
//		jj.setBorder(BorderFactory.createTitledBorder("Sub Panel 1"));
//		
//		jj.setText("propulsor 1: jsdfjskdflsj sjdfkslfjkslf");
//
//		JLabel kk = new JLabel();
//		kk.setBorder(BorderFactory.createTitledBorder("Sub Panel 2"));
//		
//		kk.setText("propulsor 1: jsdfjskdflsj sjdfkslfjkslf");
		
		
		String text = "<html>" + rocket.showPropulsores() + "<br><br></html>";
		prop1.setText(text);
		c.add(prop1);
		c.add(panel2);
//		add(c, BorderLayout.NORTH);
	}

//ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

}
