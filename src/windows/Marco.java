package windows;
//Marco con lamina y botones

import java.awt.BorderLayout;
import java.awt.Component;
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

import Rocket.Cohete;
import Rocket.Propulsor;

public class Marco extends JFrame {

	private Cohete cohete;
	private List<Propulsor> propulsores;
	
//	public JPanel laminaPropulsores = new JPanel();

	private static final long serialVersionUID = 1L;

	public Marco(Cohete cohete) throws Exception {

		this.cohete = cohete;
		this.propulsores = cohete.getPropulsores();
		
		setBounds(400, 300, 500, 400);
		setPreferredSize(new Dimension(600, 450));
		pack();
		setTitle("Código Cohete: " + this.cohete.getCode());
		setLayout(new BorderLayout());
		
		

		createWindow();
	}

	// crear ventana
	public void createWindow() {
		setBounds(400, 300, 500, 400);
		setPreferredSize(new Dimension(600, 450));
		pack();
		setTitle("Código Cohete: " + this.cohete.getCode());
		setLayout(new BorderLayout());

		LaminaPropulsores laminaPropulsores = new LaminaPropulsores(propulsores);
		laminaPropulsores.panelContenedor.setLayout(new BoxLayout(laminaPropulsores.panelContenedor, BoxLayout.PAGE_AXIS));

//		ponerPropulsores();
//		ponerPropulsores();
		add(laminaPropulsores.panelContenedor, BorderLayout.NORTH);

		JPanel laminaBotones = new JPanel();
		laminaBotones.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		ponerBoton(laminaBotones, "Acelera", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.acelerar();
//					laminaPropulsores.removeAll();
//					actualizaPanelPropulsor(laminaPropulsores);
//					ponerPropulsores(laminaPropulsores);
//					laminaPropulsores.validate();
//					laminaPropulsores.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ponerBoton(laminaBotones, "  Frena  ", new ActionListener() {

			public void actionPerformed(ActionEvent evento) {
				try {
					cohete.frenar();
//					actualizaPanelPropulsor(laminaPropulsores);
//					laminaPropulsores.removeAll();
//					ponerPropulsores(laminaPropulsores);
//					laminaPropulsores.validate();
//					laminaPropulsores.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		add(laminaBotones, BorderLayout.SOUTH);
	}

//ponemos texto de los propulsores
	public void ponerPropulsores(Container c) {
//	public void ponerPropulsores() {

	
	
			for (int i = 0; i < propulsores.size(); i++) {
//				c.remove(i);
//				System.out.println(c.getComponentCount());
//			
//			System.out.println(propulsor.getPotenciaActual());

//				JPanel panel = propulsores.get(i).createPanel();
//				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
//				c.validate();
//				c.repaint();
//				
//				c.add(panel);
			
		
			
		}

//			String text = "<html>" + rocket.showPropulsores() + "<br><br></html>";

//			c.remove(panel);
//			c.invalidate();
//				c.validate();
//				c.repaint();
			

		}
//		c.remove(0);

//		System.out.println(c.getComponentCount());

//		add(c, BorderLayout.NORTH);
	

	// actualizar paneles de propulsor
	public void actualizaPanelPropulsor(Container c) {
		System.out.println("comps" + c.getComponentCount());
		int contador = 0;
		System.out.println("ACTPROP");
		for (Component panel : c.getComponents()) {
			c.removeAll();
			
			System.out.println("Prop " + contador++ + propulsores.get(contador).getPotenciaActual());			
//			panel = propulsores.get(contador).createPanel();
			
			c.validate();
			c.repaint();
//			ponerPropulsores(c);
			
			contador++;
			
		}
		
	}
	
	
//ponemos botones

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {

		JButton boton = new JButton(titulo);

		c.add(boton);

		boton.addActionListener(oyente);

	}

}
