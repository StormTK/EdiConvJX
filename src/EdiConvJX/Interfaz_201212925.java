package EdiConvJX;

/****************
*** @StormTK  ***
*****************/

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Interfaz_201212925 extends JFrame{
	
	Archivo_201212925 ManipulacionArchivo;
    JScrollPane Scr_Codigo;
    JTextArea Txt_Codigo;
    JPanel Pnl_Info;
    JMenuBar Barra_Menu;
    JMenu Jmn_Archivo, Jmn_Editar, Jmn_Acerca;
    JMenuItem MnAr_Nuevo, MnAr_Abrir, MnAr_Guardar, MnAr_Guardar2, MnAr_Salir;
    Separator MnAr_Separador;
	
	public Interfaz_201212925() {
		Componentes();
	}
	
	public void Componentes(){
		setTitle("EdiConvJX by Kebyn");
		setSize(806,626);//El tamaño es de 800x600
		setLocationRelativeTo(null);//Lo coloca en el centro de la pantalla
		setDefaultCloseOperation(EXIT_ON_CLOSE);//Poder cerrar la aplicacion
		Image Icono = new ImageIcon(getClass().getResource("/Imagenes/Icon.png")).getImage();//imagen de icono
		setIconImage(Icono);
		
	    Barra_Menu = new JMenuBar();
	    Jmn_Archivo = new JMenu();
	    Jmn_Editar = new JMenu();
	    Jmn_Acerca = new JMenu();
	    MnAr_Nuevo = new JMenuItem();
	    MnAr_Abrir = new JMenuItem();
	    MnAr_Guardar = new JMenuItem();
	    MnAr_Guardar2 = new JMenuItem();
	    MnAr_Separador = new Separator();
	    MnAr_Salir = new JMenuItem();
		Txt_Codigo = new JTextArea();
		Scr_Codigo = new JScrollPane();
		ManipulacionArchivo = new Archivo_201212925 (Txt_Codigo);
		
		//-------------Menu-------------
		Jmn_Archivo.setText("Archivo");
		
		MnAr_Nuevo.setText("Nuevo");
		MnAr_Nuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		MnAr_Nuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent Abrir) {         	
            	ManipulacionArchivo.NuevoArchivo();
            	setTitle(ManipulacionArchivo.Nombre() + " - EdiConvJX by Kebyn");            
            }
        });
        Jmn_Archivo.add(MnAr_Nuevo);
        
        MnAr_Abrir.setText("Abrir");
        MnAr_Abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        MnAr_Abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent Abrir) {         	
            	ManipulacionArchivo.AbrirArchivo();
            	setTitle(ManipulacionArchivo.Nombre() + " - EdiConvJX by Kebyn");
            }
        });
        Jmn_Archivo.add(MnAr_Abrir);

        MnAr_Guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
        MnAr_Guardar.setText("Guardar");
        Jmn_Archivo.add(MnAr_Guardar);
        
        MnAr_Guardar2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
        MnAr_Guardar2.setText("Guardar como... ");
        Jmn_Archivo.add(MnAr_Guardar2);
        
        Jmn_Archivo.add(MnAr_Separador);

        MnAr_Salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        MnAr_Salir.setText("Salir");
        MnAr_Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent Abrir) {
            	System.exit(0);
            }
        });
        Jmn_Archivo.add(MnAr_Salir);

        Barra_Menu.add(Jmn_Archivo);

        Jmn_Editar.setText("Editar");
        Barra_Menu.add(Jmn_Editar);

        Jmn_Acerca.setText("Acerca de...");
        Barra_Menu.add(Jmn_Acerca);

		setJMenuBar(Barra_Menu);
		//-----------Fin del Menu-----------
		
		Scr_Codigo.setViewportView(Txt_Codigo);
		getContentPane().add(Scr_Codigo, BorderLayout.CENTER);
	}
}
