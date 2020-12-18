package windows;
//Marco con lamina y botones

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Rocket.Cohete;
import Rocket.Propulsor;

public class Marco extends JFrame {

	public JPanel laminaPropulsores = new JPanel();
	private Cohete cohete;
	private List<Propulsor> propulsores;
//
//	public JPanel panelPropulsores = new JPanel();
//	public LaminaPropulsores laminaPropulsores;

	private static final long serialVersionUID = 1L;

	public Marco(Cohete cohete) throws Exception {

		this.cohete = cohete;
		this.propulsores = cohete.getPropulsores();

//		for (Propulsor propulsor : propulsores) {
//			this.laminaPropulsores.add(propulsor.getPanel());
//		}
//		this.laminaPropulsores = new LaminaPropulsores(this.propulsores);

//		this.laminaPropulsores = new LaminaPropulsores(panelPropulsores, propulsores);

//		setBounds(400, 300, 500, 400);
//		setPreferredSize(new Dimension(600, 450));
//		pack();
//		setTitle("Código Cohete: " + this.cohete.getCode());
//		setLayout(new BorderLayout());

		createWindow();
	}

	// crear ventana
	public void createWindow() {
		setBounds(400, 300, 500, 400);
		setPreferredSize(new Dimension(600, 450));
		pack();
		setTitle("Código Cohete: " + this.cohete.getCode());
//		setLayout(new BorderLayout());
		laminaPropulsores.setLayout(new BoxLayout(laminaPropulsores, BoxLayout.PAGE_AXIS));

		ponerPropulsores(laminaPropulsores);
//		
//		add(panelPropulsores);

//		this.panelPropulsores.removeAll();
//		add(laminaPropulsores);

//		this.laminaPropulsores.panelContenedor.setLayout(new BoxLayout(laminaPropulsores.panelContenedor, BoxLayout.PAGE_AXIS));

//		ponerPropulsores(Container c); 

//		ponerPropulsores(this.laminaPropulsores.panelContenedor);
//		laminaPropulsores.panelContenedor.removeAll();

		JPanel laminaBotones = new JPanel();
		laminaBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		ponerBoton(laminaBotones, "Acelera", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.acelerar();
//					laminaPropulsores.removeAll();
//					ponerPropulsores(laminaPropulsores);
//					laminaPropulsores.validate();
//					laminaPropulsores.repaint();
//					add(laminaPropulsores);
//					actualizaPanelPropulsor();
//					actualizaPanelPropulsor(laminaPropulsores);
//					ponerPropulsores(laminaPropulsores);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ponerBoton(laminaBotones, "  Frena  ", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.frenar();
//					panelPropulsores.removeAll();
//					ponerPropulsores(laminaPropulsores);
//					laminaPropulsores.validate();
//					laminaPropulsores.repaint();
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

//		System.out.println("poenrpro");
		c.validate();
		c.repaint();
		add(c);

	}

	
	public void ponerPropulsores2(Container c) {
		
		c.removeAll();
		
		for (Propulsor propulsor : propulsores) {
			
			JPanel panel = propulsor.getPanel();
			c.add(panel);
		}
		
		System.out.println("poenrpro222");
		c.validate();
		c.repaint();
		add(c);
		
	}
	
	
	
	
	
	
	
	
	
	

//			String text = "<html>" + rocket.showPropulsores() + "<br><br></html>";

//			c.remove(panel);
//			c.invalidate();
//				c.validate();
//				c.repaint();

//		}
//		c.remove(0);

//		System.out.println(c.getComponentCount());

//		add(c, BorderLayout.NORTH);

	// actualizar paneles de propulsor
	public void actualizaPanelPropulsor() {

		for (Propulsor propulsor : propulsores) {

//			propulsor.refreshPanel();

//			c.remove(i);
//			System.out.println(c.getComponentCount());
//	add(this.laminaPropulsores.panelContenedor, BorderLayout.NORTH);
//		
//		System.out.println(propulsor.getPotenciaActual());

//			JPanel panel = propulsores.get(i).getPanel();
//			panel.getp
//			c.validate();
//			c.repaint();
//			
//			this.panelPropulsores.add(panel);
		}

		System.out.println("actututut");

	}

//ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

}
