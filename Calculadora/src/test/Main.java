package test;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelos.Calculadora;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		 try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
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
		
		calculadora.getFrame().setVisible(true);
		
			
	}

}