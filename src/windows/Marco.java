package windows;
//Marco con lamina y botones

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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

		setTitle("Código Cohete: " + this.cohete.getCode());

		JPanel laminaPropulsores = new JPanel(new FlowLayout(FlowLayout.LEFT));

		ponerPropulsores(this.cohete, laminaPropulsores);

		add(laminaPropulsores, BorderLayout.NORTH);

		JPanel laminaBotones = new JPanel();
		laminaBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); 

		ponerBoton(laminaBotones, "Acelera", new ActionListener() {


			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.acelerar();
					laminaPropulsores.removeAll();
					ponerPropulsores(cohete, laminaPropulsores);
					laminaPropulsores.validate();
					laminaPropulsores.repaint();
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
					laminaPropulsores.removeAll();
					ponerPropulsores(cohete, laminaPropulsores);
					laminaPropulsores.validate();
					laminaPropulsores.repaint();
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
		String text = "<html>" + rocket.showPropulsores() + "<br><br></html>";
		prop1.setText(text);
		c.add(prop1);
	}

//ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

}
