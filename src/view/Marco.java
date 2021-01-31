package view;
//Marco con lamina y botones

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.rocket.domain.Cohete;
import com.rocket.domain.Propulsor;

public class Marco extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel laminaPropulsores = new JPanel();
	private Cohete cohete;
	private List<Propulsor> propulsores;

	private Marco(Cohete cohete) throws Exception {

		this.cohete = cohete;
		this.propulsores = cohete.getPropulsores();

		createWindow();
	}

	private static Marco instance = null;

	public static Marco getInstance(Cohete cohete) throws Exception {
		if (instance == null) {
			instance = new Marco(cohete);
		}
		return instance;
	}

	// crear ventana
	public void createWindow() {
		setBounds(400, 300, 500, 400);
		setPreferredSize(new Dimension(600, 450));
		pack();
		setTitle("Código Cohete: " + this.cohete.getCodigo());

		laminaPropulsores.setLayout(new BoxLayout(laminaPropulsores, BoxLayout.PAGE_AXIS));

		ponerPropulsores(laminaPropulsores);

		JPanel laminaBotones = new JPanel();
		laminaBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		ponerBoton(laminaBotones, "Acelera", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.acelerar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ponerBoton(laminaBotones, "  Frena  ", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.frenar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		add(laminaBotones, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

//ponemos texto de los propulsores
	public void ponerPropulsores(Container c) {
		c.removeAll();

		for (Propulsor propulsor : propulsores) {
			JPanel panel = propulsor.getPanel();
			c.add(panel);
		}

		c.validate();
		c.repaint();
		add(c);

	}

//ponemos botones
	public void ponerBoton(Container c, String titulo, ActionListener oyente) {
		JButton boton = new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}

}
