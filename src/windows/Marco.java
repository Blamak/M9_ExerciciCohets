package windows;
//Marco con lamina y botones

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Rocket.Cohete;

class Marco extends JFrame {
	
	private Cohete cohete;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Marco(Cohete cohete) throws Exception {
		
		this.cohete = cohete;

		setBounds(400, 300, 800, 400);

		setTitle("Código Cohete: " + cohete.getCode());

		JPanel laminaPropulsores = new JPanel(new FlowLayout(FlowLayout.LEFT));

		ponerPropulsores(this.cohete, laminaPropulsores, "<html><br/>&nbsp&nbsp&nbsp&nbsp Prop1<br/>nasjdkasldjas</html>");

		add(laminaPropulsores, BorderLayout.NORTH);

		JPanel laminaBotones = new JPanel();

		ponerBoton(laminaBotones, "Acelera", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

			}
		});

		ponerBoton(laminaBotones, "Frena", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {

			}
		});

		add(laminaBotones, BorderLayout.SOUTH);

	}

//ponemos texto de los propulsores
	public void ponerPropulsores(Cohete rocket, Container c, String propulsor) {
		JLabel prop1 = new JLabel();
		prop1.setText(rocket.showPropulsores());
		c.add(prop1);
	}

//ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

}
