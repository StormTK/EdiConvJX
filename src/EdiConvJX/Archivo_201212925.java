package EdiConvJX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivo_201212925 {
	
	JTextArea Archivo;
	String RutaArchivo;
	String nameArchivo;
	
	public Archivo_201212925(JTextArea Archivo) {
		this.Archivo = Archivo;
	}
	
	public void AbrirArchivo(){
		String TextoLeido = "";
        try {
            JFileChooser CuadoBuscar = new JFileChooser(System.getProperty("user.dir"));
            CuadoBuscar.showOpenDialog(CuadoBuscar);  
            
            File AbrirArchivo = CuadoBuscar.getSelectedFile();
            RutaArchivo = AbrirArchivo.getPath();
            nameArchivo = AbrirArchivo.getName();
            //Agregamos un filtro de extensiones
            
            if (AbrirArchivo != null) {
            	Archivo.setText("");
                FileReader Fichero = new FileReader(AbrirArchivo);
                BufferedReader leer = new BufferedReader(Fichero);
                while ((TextoLeido = leer.readLine()) != null) {
                	Archivo.append(TextoLeido + "\n");
                }
                leer.close();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
            
	}
	
	public String Nombre(){
		return nameArchivo;
	}
	
	public void NuevoArchivo(){
		Archivo.setText("");
		nameArchivo = "sin nombre";
	}
	
	public void GuardarArchivo(){
		
	}
	
}
