package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Rocket.Cohete;
import Rocket.Propulsor;

public class PropulsoresThreads extends JFrame {

	private Cohete cohete;
	private List<Propulsor> propulsores;
	JPanel panelContenedor = new JPanel();

	public PropulsoresThreads() {
		
//		LaminaPropulsores laminaPropulsores = new LaminaPropulsores(panelContenedor);
//		laminaPropulsores.setLayout(new BoxLayout(laminaPropulsores, BoxLayout.PAGE_AXIS));
		
		

		for (int i = 0; i < propulsores.size(); i++) {
//			c.remove(i);
//			System.out.println(c.getComponentCount());
//		
//		System.out.println(propulsor.getPotenciaActual());

//			JPanel panel = propulsores.get(i).createPanel();
//			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
//			c.validate();
//			c.repaint();
//			
//			laminaPropulsores.add(panel);
		}
	}
}
