package visual;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import de.simplicit.vjdbc.server.config.ConfigurationException;
import de.simplicit.vjdbc.server.config.VJdbcConfiguration;
import de.simplicit.vjdbc.server.rmi.ConnectionServer;

import persistencia.DaoConfig;
import util.ResolvedProperties;
import visual.app.ControllerFAlumno;
import visual.app.ControllerFFacultad;
import visual.app.ControllerLAlumno;
import visual.app.FAlumno;
import visual.app.LBuscador;
import visual.util.Mensaje;
import visual.util.WindowUtils;
import visual.util.login.ControllerFLogin;
import visual.util.login.FLogin;
import visual.util.process_blocker.ProcessBlocker;

public final class MainVisual extends JFrame {
	private static Log logger = LogFactory.getLog(MainVisual.class);
	
	static {
		try
		{
		  UIManager.setLookAndFeel("net.java.plaf.windows.WindowsLookAndFeel");
		}
		catch ( Exception e ) {}
	}
	
	private ControllerFLogin cfl;
	private JPanel jContentPane = null;
	private JMenuBar mnbApp = null;
	private JMenu mnuInicio = null;
	private JMenu mnuAdministracion = null;
	private JMenu mnuAlumnosEgresados = null;
	private JMenuItem mniListadoAlumnosEgresados = null;
	private JMenuItem mniFacultad = null;
	private JMenuItem mniSalir = null;
	private JMenuItem mniIngresarAlumno = null;

	public MainVisual() {
		super();
		// TODO Auto-generated constructor stub
		initialize();
	}

	/**
	 * This method initializes mnbApp	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getMnbApp() {
		if (mnbApp == null) {
			mnbApp = new JMenuBar();
			mnbApp.add(getMnuInicio());
			mnbApp.add(getMnuAdministracion());
			mnbApp.add(getMnuAlumnosEgresados());
		}
		return mnbApp;
	}

	/**
	 * This method initializes mnuInicio	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnuInicio() {
		if (mnuInicio == null) {
			mnuInicio = new JMenu();
			mnuInicio.setText("Inicio");
			mnuInicio.add(getMniSalir());
		}
		return mnuInicio;
	}

	/**
	 * This method initializes mnuAdministracion	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnuAdministracion() {
		if (mnuAdministracion == null) {
			mnuAdministracion = new JMenu();
			mnuAdministracion.setText("Administracion");
			mnuAdministracion.add(getMniFacultad());
		}
		return mnuAdministracion;
	}

	/**
	 * This method initializes mnuAlumnosEgresados	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getMnuAlumnosEgresados() {
		if (mnuAlumnosEgresados == null) {
			mnuAlumnosEgresados = new JMenu();
			mnuAlumnosEgresados.setText("Alumnos");
			mnuAlumnosEgresados.setMnemonic(java.awt.event.KeyEvent.VK_A);
			mnuAlumnosEgresados.add(getMniListadoAlumnosEgresados());
			mnuAlumnosEgresados.add(getMniIngresarAlumno());
		}
		return mnuAlumnosEgresados;
	}

	/**
	 * This method initializes mniListadoAlumnosEgresados	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMniListadoAlumnosEgresados() {
		if (mniListadoAlumnosEgresados == null) {
			mniListadoAlumnosEgresados = new JMenuItem();
			mniListadoAlumnosEgresados.setText("Listado");
			mniListadoAlumnosEgresados.setMnemonic(java.awt.event.KeyEvent.VK_L);
			mniListadoAlumnosEgresados.addActionListener(new ActionListener () {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new ControllerLAlumno(new LBuscador(MainVisual.this));
				}
				
			});
		}
		return mniListadoAlumnosEgresados;
	}

	/**
	 * This method initializes mniFacultad	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMniFacultad() {
		if (mniFacultad == null) {
			mniFacultad = new JMenuItem();
			mniFacultad.setText("Facultades UNI");
			mniFacultad.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					new ControllerFFacultad(MainVisual.this);
				}
			});
		}
		return mniFacultad;
	}

	/**
	 * This method initializes mniSalir	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMniSalir() {
		if (mniSalir == null) {
			mniSalir = new JMenuItem();
			mniSalir.setText("Salir");
			mniSalir.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					MainVisual.this.setVisible(false);
					MainVisual.this.dispose();
				}
			});
		}
		return mniSalir;
	}

	/**
	 * This method initializes mniIngresarAlumno	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMniIngresarAlumno() {
		if (mniIngresarAlumno == null) {
			mniIngresarAlumno = new JMenuItem();
			mniIngresarAlumno.setMnemonic(java.awt.event.KeyEvent.VK_I);
			mniIngresarAlumno.setText("Ingresar Nuevo");
			mniIngresarAlumno.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					new ControllerFAlumno(new FAlumno(MainVisual.this));
				}
			});
		}
		return mniIngresarAlumno;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ResolvedProperties _properties = new ResolvedProperties();
			InputStream isProps = null;
			InputStream isConfig = null;
			try {
				String log4jPropertiesFile = "propiedades/log4j.properties";
				URL log4jProps = ClassLoader.getSystemClassLoader().getResource(log4jPropertiesFile);
				PropertyConfigurator.configure(log4jProps);
			
				//isProps = Thread.currentThread().getContextClassLoader().getResourceAsStream("propiedades/databaseNative.properties");
				//isConfig = Thread.currentThread().getContextClassLoader().getResourceAsStream("propiedades/vjdbc_server_config.xml");
				try {
					/**
					 * http://forums.java.net/jive/thread.jspa?messageID=212448
					 * */
					isConfig = Thread.currentThread().getContextClassLoader().getResourceAsStream("propiedades/config.properties");
					_properties.load(isConfig);
					String command = _properties.getProperty("pathCommand");
					//Runtime runtime = Runtime.getRuntime();
					//runtime.exec(command);
				}
				catch (Exception e) {
					
				}
				Thread.sleep(2000);
				//VJdbcConfiguration.init(isConfig, _properties);
	            //ConnectionServer connectionServer = new ConnectionServer();
	            //connectionServer.serve();
				DaoConfig.getDaomanager();
			}
			//catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
			//catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
			finally {
	            /*if(isProps != null) {
	            	isProps.close();
	            }
	            if(isConfig != null) {
	            	isConfig.close();
	            }*/
	        }
			new MainVisual();
		} catch (Throwable e) {
            e.printStackTrace();
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(654, 292);
		this.setJMenuBar(getMnbApp());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new WindowAdapter () {
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				ProcessBlocker.instance().initialize(MainVisual.this);
				ProcessBlocker.instance().showMessage("Sacando una Copia de Seguridad antes de Cerrar...");
				MainVisual.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				//URL urlOrigen = ClassLoader.getSystemResource("basedatos/postgrado_central.mdb");
				String urlOrigen = "." + "\\" + "basedatos"+"\\"+"postgrado_central.mdb";
				//URL urlDestino = ClassLoader.getSystemResource("basedatos");
				String urlDestino = "."+ "\\" + "basedatos"+"\\"+System.currentTimeMillis()+".mdb";
				try {
					//urlOrigen.toString();
					//copy(new File(urlOrigen.toURI()), new File(urlDestino.getPath()+"/"+System.currentTimeMillis()+".mdb"));
					copy(new File(urlOrigen), new File(urlDestino));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} /*catch (URISyntaxException e) {
					e.printStackTrace();
				}*/
				ProcessBlocker.instance().removeMessage();
				//MainVisual.this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		this.setContentPane(getJContentPane());
		this.setTitle("Programa de Administracion de Alumnos Egresados - PostGrado Central");
		WindowUtils.centerFrameOnScreen(this);
		this.setVisible(true);
		try {
			cfl = new ControllerFLogin(new FLogin(this, true));
			if (!cfl.isValidate()) {
				System.exit(0);
			}
		} 
		catch (RuntimeException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Mensaje.error(this,"Algo no está bien, consulte con el desarrollador!!", "Error");
			System.exit(0);
		}
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
	
   
    static final int BUFF_SIZE = 100000;
    static final byte[] buffer = new byte[BUFF_SIZE];

    public static void copy(File src, File dst) throws IOException {
       InputStream in = null;
       OutputStream out = null; 
       try {
          in = new FileInputStream(src);
          out = new FileOutputStream(dst);
          while (true) {
             synchronized (buffer) {
                int amountRead = in.read(buffer);
                if (amountRead == -1) {
                   break;
                }
                out.write(buffer, 0, amountRead); 
             }
          } 
       } finally {
          if (in != null) {
             in.close();
          }
          if (out != null) {
             out.close();
          }
       }
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"
