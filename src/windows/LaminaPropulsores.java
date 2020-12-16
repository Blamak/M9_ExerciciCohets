package windows;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Rocket.Propulsor;

public class LaminaPropulsores implements Runnable {

//	private List<Propulsor> propulsores = new ArrayList<>();
	public JPanel panelContenedor = new JPanel();
	private Thread runner;
	private List<Propulsor> propulsores = new ArrayList<>();
	Propulsor propulsor;
	JFrame frame;
	
	public JPanel getPanelContenedor() {
		return this.panelContenedor;
	}


	public LaminaPropulsores(JPanel panel, List<Propulsor> propulsores, JFrame frame) {
		this.propulsores = propulsores;
		this.panelContenedor = panel;
		this.frame = frame;
		
		if (runner == null) {
			runner = new Thread(this);
		}
		runner.start();
	}

	@Override
	public void run() {
		
//		propulsores = propulsores;
		panelContenedor.removeAll();
		for (Propulsor propulsor : this.propulsores) {
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createTitledBorder("Propulsor " + (propulsor.identificador)));
			label.setText("Potencia máxima: " + Integer.toString(propulsor.getPotenciaMax()) + "  Potencia actual: " + propulsor.getPotenciaActual());
//			System.out.println(identificador + " " + this.getPotenciaActual());
			panel.add(label);
			panelContenedor.add(panel);
			frame.add(panelContenedor);
			panelContenedor.validate();
			panelContenedor.repaint();
			
//			this.panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
//			this.panelContenedor.add(propulsor.getPanel());
//			System.out.println(propulsor.getPotenciaActual());
//			panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
//			panelContenedor.validate();
//			panelContenedor.repaint();
		}
		
		
		
//		add(panelContenedor);
//		this.propulsores.get(2).getPanel().removeAll();
		
		
		
		
		
		
		
		
//		this.panelContenedor.removeAll();
//		Propulsores(this.panelContenedor);
//		this.panelContenedor.validate();
//		this.panelContenedor.repaint();
		
//		panelContenedor.setLayout(new BoxLayout(this.panelContenedor, BoxLayout.PAGE_AXIS));
		// TODO Auto-generated method stub

	}

}
