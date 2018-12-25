package visual.util;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dialog;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

public class DReportPrint extends JDialog {

	private JPanel jContentPane = null;

	public DReportPrint() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		initialize();
	}


	
	public DReportPrint(Dialog parent, boolean modal, String resource, List beanList, Map params) {
		super(parent, modal);
		URL url = ClassLoader.getSystemResource(resource);
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		try {
			jasperReport = (JasperReport)JRLoader.loadObject(url.openStream());
			jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(beanList));
			this.jContentPane = new JRViewer(jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}
	
	public DReportPrint(Dialog parent, boolean modal, String resource, List beanList) {
		super(parent, modal);
		URL url = ClassLoader.getSystemResource(resource);
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		try {
			jasperReport = (JasperReport)JRLoader.loadObject(url.openStream());
			jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(beanList));
			this.jContentPane = new JRViewer(jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}
	
	public DReportPrint(Dialog parent, boolean modal, String resource, TableModel tm) {
		super(parent, modal);
		URL url = ClassLoader.getSystemResource(resource);
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		try {
			jasperReport = (JasperReport) JRLoader.loadObject(url.openStream());
			jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRTableModelDataSource(tm));
			this.jContentPane = new JRViewer(jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}
	
	public DReportPrint(Dialog parent, boolean modal, JasperPrint jasperPrint) {
		super(parent, modal);
		this.jContentPane = new JRViewer(jasperPrint);
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Vista Previa de Impresión");
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.pack();
		
		Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = toolkit.getScreenSize();
		int screenResolution = toolkit.getScreenResolution();
		float zoom = ((float) screenResolution) / JRViewer.REPORT_RESOLUTION;

		int height = (int) (550 * zoom);
		if (height > screenSize.getHeight()) {
			height = (int) screenSize.getHeight();
		}
		int width = (int) (750 * zoom);
		if (width > screenSize.getWidth()) {
			width = (int) screenSize.getWidth();
		}
		
		java.awt.Dimension dimension = new java.awt.Dimension(width, height);
		setSize(dimension);
		setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
	}

	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
		}
		return jContentPane;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
