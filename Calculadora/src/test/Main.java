package test;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelos.Calculadora;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub UIManager.getSystemLookAndFeelClassName()
		
		 try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calculadora calculadora = new Calculadora();
		
		calculadora.setVisible(true);
		
			
	}

}
