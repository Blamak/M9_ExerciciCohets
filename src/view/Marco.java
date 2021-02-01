package view;

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

import java.awt.BorderLayout;

/**
 * Clase que crea una ventana para mostrar los propulsores del cohete
 * y los botones de aceleraci�n y frenado. Hereda de JFrame
 * 
 * Contiene un objeto de tipo Cohete y una lista de sus propulsores,
 * adem�s de un atributo de tipo JPanel, l�mina para mostrar los propulsores
 * 
 * Se implementa con el patr�n Singleton, permitiendo crear un �nico objeto
 *
 */
public class Marco extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel laminaPropulsores = new JPanel();
	
	private Cohete cohete;
	private List<Propulsor> propulsores;

	/**
	 * Constructor que toma un Cohete como par�metro y almacena una lista con sus propulsores
	 * 
	 * Ejecuta el m�todo createWindow() para crear la ventana
	 * 
	 * @param cohete, objeto de tipo Cohete
	 * @throws Exception - en contructor de Cohete
	 */
	private Marco(Cohete cohete) throws Exception {
		this.cohete = cohete;
		this.propulsores = cohete.getPropulsores();

		createWindow();
	}

	/*
	 *  Implementaci�n del patr�n Singleton
	 */
	private static Marco instance = null;
	public static Marco getInstance(Cohete cohete) throws Exception {
		if (instance == null) {
			instance = new Marco(cohete);
		}
		return instance;
	}

	/**
	 * M�todo para crear la ventana con las l�minas
	 * de propulsores y botones
	 * 
	 */
	public void createWindow() {
		setBounds(400, 300, 500, 400);
		setPreferredSize(new Dimension(600, 450));
		pack();
		setTitle("C�digo Cohete: " + this.cohete.getCodigo());

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

	/**
	 * Crea una l�mina para cada propulsor y los a�ade a la l�mina con todos propulsores
	 * 
	 * @param contenedor, objeto de tipo Container con los paneles de cada propulsor
	 * incrustados en su interior 
	 */
	public void ponerPropulsores(Container contenedor) {
		contenedor.removeAll();

		for (Propulsor propulsor : propulsores) {
			JPanel panel = propulsor.getPanel();
			contenedor.add(panel);
		}

		contenedor.validate();
		contenedor.repaint();
		add(contenedor);

	}

	/**
	 * Crea los botones de frenar y acelerar con sus respectivos listeners
	 * 
	 * @param contenedor, objeto de tipo Container que incorpora los botones
	 * @param titulo, texto del bot�n
	 * @param oyente, listener que ejecutar� los m�todos de la clase Cohete,
	 * 				  acelerar() o frenar (), al pulsar el bot�n correspondiente
	 */
	public void ponerBoton(Container contenedor, String titulo, ActionListener oyente) {
		JButton boton = new JButton(titulo);
		contenedor.add(boton);
		boton.addActionListener(oyente);
	}

}
