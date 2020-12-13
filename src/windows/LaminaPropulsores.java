package windows;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Rocket.Propulsor;

public class LaminaPropulsores implements Runnable {

//	private List<Propulsor> propulsores = new ArrayList<>();
	public JPanel panelContenedor = new JPanel();
	private Thread runner;
	private List<Propulsor> propulsores = new ArrayList<>();
	Propulsor propulsor;
	
	public JPanel getPanelContenedor() {
		return this.panelContenedor;
	}


	public LaminaPropulsores(List<Propulsor> propulsores) {
		this.propulsores = propulsores;
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}

	@Override
	public void run() {
		panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.PAGE_AXIS));
		for (Propulsor propulsor : propulsores) {
			this.panelContenedor.add(propulsor.getPanel());
		}
		
		
		
		
		
		
		
//		this.panelContenedor.removeAll();
//		Propulsores(this.panelContenedor);
//		this.panelContenedor.validate();
//		this.panelContenedor.repaint();
		
//		panelContenedor.setLayout(new BoxLayout(this.panelContenedor, BoxLayout.PAGE_AXIS));
		// TODO Auto-generated method stub

	}

}
