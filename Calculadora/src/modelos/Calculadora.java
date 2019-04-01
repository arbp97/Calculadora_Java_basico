package modelos;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
Algunos comentarios estan desactualizados...
*/

public class Calculadora extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JFrame frame;//ventana
	JTextField textBox;//caja de texto
	JPanel framePanel,mainPanel,textPanel,menuPanel;//paneles para los botones y la caja de texto
	JMenuBar menuBar;
	JMenu menu1,menu2;
	JMenuItem modo1,modo2,about;
	JButton n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,bDot,bClear,bEquals,bSuma,bResta,bDiv,bMult,bPow;//todos los botones
	ImageIcon img,img2,img3;//iconos
	String nOperando1,nOperando2,nOperador;

	int flagModos=-1;/*Empieza en modo default, que setea todos los botones
					*modo normal: solo los correspondientes
					*modo binario: solo los correspondientes
					*/

	public Calculadora() {

		this.nOperador = "";
		this.nOperando1 = "";
		this.nOperando2 = "";
		
		img = new ImageIcon(this.getClass().getResource("/icons/calc_icon.png"));
		img2 = new ImageIcon(this.getClass().getResource("/icons/info48x48.png"));
		img3 = new ImageIcon(this.getClass().getResource("/icons/info16x16.png"));
		
		frameConfig();//setea y configura la ventana

		panelConfig();//setea y configura los paneles

		compConfig();//setea y configura los botones y la caja de texto

		framePanel.add(menuPanel);
		
		framePanel.add(textPanel);

		framePanel.add(mainPanel);

		frame.add(framePanel);


	}

	private void frameConfig() {

		//inicializando la ventana
		frame = new JFrame();
       
		frame.setIconImage(img.getImage());
		frame.setSize(315,390);//largo y ancho de la ventana
		frame.setTitle("Calculadora");//titulo de la ventana
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);//setea que hace la ventana cuando se presiona la X
		frame.setLocationRelativeTo(null);//setea la posicion al centro de la pantalla
		frame.setResizable(false);

	}

	private void panelConfig() {

		//seteando el panel

		mainPanel = new JPanel();
		textPanel = new JPanel();
		framePanel = new JPanel();
		menuPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5,4));
		mainPanel.setPreferredSize(new Dimension(310,240));
		

	}

	private void compConfig() {
		
		//configurando la barra de menus
		menuBar = new JMenuBar();
		menu1 = new JMenu("Modos");
		menu2 = new JMenu("Ayuda");
		modo1 = new JMenuItem("Normal");
		modo2 = new JMenuItem("Binario");
		about = new JMenuItem("Acerca de");
		about.setIcon(img3);
		menuBar.setPreferredSize(new Dimension(300,25));
		
		menu1.add(modo1);
		menu1.add(modo2);
		menu2.add(about);
		menuBar.add(menu1);
		menuBar.add(menu2);

		//configurando la caja de texto
		textBox = new JTextField(20);
		Font Calc = new Font("OCR A EXTENDED",Font.PLAIN,22);
		textBox.setFont(Calc);
		textBox.setForeground(Color.BLACK);
		textBox.setBackground(Color.ORANGE.darker());
		textBox.setEditable(false);
		textBox.setPreferredSize(new Dimension(320,50));
		
		//Seteando botones
		n1 = new JButton("1");n1.setFont(Calc);
		n2 = new JButton("2");n2.setFont(Calc);
		n3 = new JButton("3");n3.setFont(Calc);
		n4 = new JButton("4");n4.setFont(Calc);
		n5 = new JButton("5");n5.setFont(Calc);
		n6 = new JButton("6");n6.setFont(Calc);
		n7 = new JButton("7");n7.setFont(Calc);
		n8 = new JButton("8");n8.setFont(Calc);
		n9 = new JButton("9");n9.setFont(Calc);
		n0 = new JButton("0");n0.setFont(Calc);

		//botones de operaciones
		bEquals = new JButton("=");bEquals.setFont(Calc);
		bSuma = new JButton("+");bSuma.setFont(Calc);
		bResta = new JButton("-");bResta.setFont(Calc);
		bDiv = new JButton("/");bDiv.setFont(Calc);
		bMult = new JButton("*");bMult.setFont(Calc);
		bPow = new JButton("^");bPow.setFont(Calc);

		//otros botones
		bDot = new JButton(".");bDot.setFont(Calc);
		bClear = new JButton("C");bClear.setFont(Calc);

		setButtons(flagModos);//seteando botones en modo default
		flagModos++;//seteando bandera para el modo normal

		//Layout(en este orden aparecen estos componentes en la ventana)
		
		
		menuPanel.add(menuBar);
		textPanel.add(textBox); 
		mainPanel.add(bSuma); mainPanel.add(n1); mainPanel.add(n2); mainPanel.add(n3); 
		mainPanel.add(bResta); mainPanel.add(n4); mainPanel.add(n5); mainPanel.add(n6); 
		mainPanel.add(bMult); mainPanel.add(n7); mainPanel.add(n8);  mainPanel.add(n9);
		mainPanel.add(bDiv); mainPanel.add(bDot);  mainPanel.add(n0); mainPanel.add(bClear); 
		mainPanel.add(bPow); mainPanel.add(bEquals);



	}
	
	private void setButtons(int buttonMode) {
		
		/*
		 * Este metodo añade funcionamiento a los botones y sus respectivos colores, dependiendo del modo
		 */
		
		if(buttonMode == -1) {//DEFAULT
		

			//digitos
			n1.addActionListener(this);n1.setForeground(Color.red.darker());n1.setBackground(Color.ORANGE.darker());
			n2.addActionListener(this);n2.setForeground(Color.red.darker());n2.setBackground(Color.ORANGE.darker());
			n3.addActionListener(this);n3.setForeground(Color.red.darker());n3.setBackground(Color.ORANGE.darker());
			n4.addActionListener(this);n4.setForeground(Color.red.darker());n4.setBackground(Color.ORANGE.darker());
			n5.addActionListener(this);n5.setForeground(Color.red.darker());n5.setBackground(Color.ORANGE.darker());
			n6.addActionListener(this);n6.setForeground(Color.red.darker());n6.setBackground(Color.ORANGE.darker());
			n7.addActionListener(this);n7.setForeground(Color.red.darker());n7.setBackground(Color.ORANGE.darker());
			n8.addActionListener(this);n8.setForeground(Color.red.darker());n8.setBackground(Color.ORANGE.darker());
			n9.addActionListener(this);n9.setForeground(Color.red.darker());n9.setBackground(Color.ORANGE.darker());
			n0.addActionListener(this);n0.setForeground(Color.red.darker());n0.setBackground(Color.ORANGE.darker());

			//botones de operaciones
			bEquals.addActionListener(this);bEquals.setForeground(Color.black.darker());bEquals.setBackground(Color.ORANGE.darker());
			bSuma.addActionListener(this);bSuma.setForeground(Color.black.darker());bSuma.setBackground(Color.ORANGE.darker());
			bResta.addActionListener(this);bResta.setForeground(Color.black.darker());bResta.setBackground(Color.ORANGE.darker());
			bDiv.addActionListener(this);bDiv.setForeground(Color.black.darker());bDiv.setBackground(Color.ORANGE.darker());
			bMult.addActionListener(this);bMult.setForeground(Color.black.darker());bMult.setBackground(Color.ORANGE.darker());
			bPow.addActionListener(this);bPow.setForeground(Color.black.darker());bPow.setBackground(Color.ORANGE.darker());

			//otros botones
			bDot.addActionListener(this);bDot.setForeground(Color.red.darker());bDot.setBackground(Color.ORANGE.darker());
			bClear.addActionListener(this);bClear.setForeground(Color.black);bClear.setBackground(Color.ORANGE.darker());
			
			//el programa entra en modo default, que realmente seria el modo normal original, asi que
			//no hace falta que el boton para pasar a modo normal funcione
			//si el modo normal esta activado, solo funciona el boton para binario y viceversa
			menu1.addActionListener(this);
			menu2.addActionListener(this);
			modo2.setForeground(Color.black);
			modo1.setForeground(Color.LIGHT_GRAY.darker());
			modo1.setText("->Normal");
			modo2.addActionListener(this);
			about.addActionListener(this);
			
			
			
			
		}else if(buttonMode == 0) {//NORMAL
			
			n2.addActionListener(this);n2.setForeground(Color.red.darker());
			n3.addActionListener(this);n3.setForeground(Color.red.darker());
			n4.addActionListener(this);n4.setForeground(Color.red.darker());
			n5.addActionListener(this);n5.setForeground(Color.red.darker());
			n6.addActionListener(this);n6.setForeground(Color.red.darker());
			n7.addActionListener(this);n7.setForeground(Color.red.darker());
			n8.addActionListener(this);n8.setForeground(Color.red.darker());
			n9.addActionListener(this);n9.setForeground(Color.red.darker());
			
			bDiv.addActionListener(this);bDiv.setForeground(Color.blue.darker());
			bMult.addActionListener(this);bMult.setForeground(Color.blue.darker());
			bPow.addActionListener(this);bPow.setForeground(Color.blue.darker());
			
			modo2.setText("Binario");modo2.addActionListener(this);
			modo2.setForeground(Color.black);
			modo1.setForeground(Color.LIGHT_GRAY.darker());
			modo1.removeActionListener(this);modo1.setText("->Normal");
			
			
		}else {//BINARIO
			
			n2.removeActionListener(this);n2.setForeground(Color.LIGHT_GRAY);
			n3.removeActionListener(this);n3.setForeground(Color.LIGHT_GRAY);
			n4.removeActionListener(this);n4.setForeground(Color.LIGHT_GRAY);
			n5.removeActionListener(this);n5.setForeground(Color.LIGHT_GRAY);
			n6.removeActionListener(this);n6.setForeground(Color.LIGHT_GRAY);
			n7.removeActionListener(this);n7.setForeground(Color.LIGHT_GRAY);
			n8.removeActionListener(this);n8.setForeground(Color.LIGHT_GRAY);
			n9.removeActionListener(this);n9.setForeground(Color.LIGHT_GRAY);
			
			bPow.removeActionListener(this);bPow.setForeground(Color.LIGHT_GRAY); 
			bMult.removeActionListener(this);bMult.setForeground(Color.LIGHT_GRAY);
			bDiv.removeActionListener(this);bDiv.setForeground(Color.LIGHT_GRAY); 
			
			modo1.setText("Normal");modo1.addActionListener(this);
			modo1.setForeground(Color.black);
			modo2.setForeground(Color.LIGHT_GRAY.darker());
			modo2.removeActionListener(this);modo2.setText("->Binario");
			
			
		}
		
		
		nOperando1 = nOperando2 = nOperador = "";
		textBox.setText("0");
		
		
	}
	
	private void operacionDecimal(String aux,double temp) {
		
		if(((aux.charAt(0) >= '0')&&(aux.charAt(0) <= '9') || aux.charAt(0) == '.')) {
			//si el boton presionado esta entre los numeros permitidos, o es un punto, se esta tipeando un operando
			if(nOperador == "") {
				//si no hay operador, significa que todavia estamos en el primer operand

				nOperando1 = nOperando1 + aux;


			}else {
				//si lo hay, entonces ya se puede escribir en el segundo operando
				nOperando2 = nOperando2 + aux;

			}

			textBox.setText(nOperando1+nOperador+nOperando2);//seteamos la caja del texto

		}else if(aux.charAt(0) == 'C') {
			//si el boton presionado es bClear, se limpian las entradas y la caja de texto

			nOperando1 = nOperando2 = nOperador = "";
			textBox.setText("0");

		}else if(aux.charAt(0) == '=') {
			//si se presiona bEquals, se procede a hacer las operaciones correspondientes

			switch(nOperador) {

			case "+": temp = Double.parseDouble(nOperando1) + Double.parseDouble(nOperando2);break;//suma
			case "-": temp = Double.parseDouble(nOperando1) - Double.parseDouble(nOperando2);break;//resta
			case "*": temp = Double.parseDouble(nOperando1) * Double.parseDouble(nOperando2);break;//multi
			case "/": temp = Double.parseDouble(nOperando1) / Double.parseDouble(nOperando2);break;//div
			case "^": temp = Math.pow(Double.parseDouble(nOperando1), Double.parseDouble(nOperando2));break;//potencia

			}

			textBox.setText(nOperando1+nOperador+nOperando2+ "= "+temp);//se muestra el resultado por pantalla
			/*
			 * cuando el resultado ya esta por pantalla, se iguala el 1er operando al resultado
			 */
			nOperando1 = Double.toString(temp);
			/*
			 * se iguala el operando 1 al resultado, y se limpian los otros dos campos, esto sirve para que, en la siguente
			 * entrada, se pase a la proxima instancia else {}
			 */
			nOperador = nOperando2 = "";


		}else {

			if((nOperando1=="")||(nOperando2=="")) {

				nOperador = aux;/*si en alguno de los dos operandos no hay nada, se posiciona en pantalla el operador para que,
									en la proxima entrada, se ingrese el operando 2
				 */

			}else {

				/*
				 * Esta parte del algoritmo sirve cuando, luego de haber apretado el boton bEquals, se quiere seguir calculando con
				 * el resultado obtenido (o sea se presionan + * - /)
				 */


				switch(nOperador) {

				case "+": temp = Double.parseDouble(nOperando1) + Double.parseDouble(nOperando2);break;//suma
				case "-": temp = Double.parseDouble(nOperando1) - Double.parseDouble(nOperando2);break;//resta
				case "*": temp = Double.parseDouble(nOperando1) * Double.parseDouble(nOperando2);break;//multi
				case "/": temp = Double.parseDouble(nOperando1) / Double.parseDouble(nOperando2);break;//div
				case "^": temp = Math.pow(Double.parseDouble(nOperando1), Double.parseDouble(nOperando2));break;

				}

				nOperando1 = Double.toString(temp);

				nOperador = aux;

				nOperando2 = "";

				textBox.setText(nOperando1+nOperador+nOperando2);

			}

		}
		
	}
	
	private void operacionBinaria(String aux,double temp) {
		
		/*
		 * La operacion en binario consiste en pasar los numeros ingresados a base 10, hacer los calculos en
		 * base 10, y pasar el resultado a base 2
		 * por el momento solo suma.
		 */
		
		
		if((aux.charAt(0) >= '0')&&(aux.charAt(0) <= '1')) {
			//si el boton presionado esta entre los numeros permitidos se esta ingresando un operando
			if(nOperador == "") {
				//si no hay operador, significa que todavia estamos en el primer operando

				nOperando1 = nOperando1 + aux;


			}else {
				//si lo hay, entonces ya se puede escribir en el segundo operando
				nOperando2 = nOperando2 + aux;

			}

			textBox.setText(nOperando1+nOperador+nOperando2);//seteamos la caja del texto

		}else if(aux.charAt(0) == 'C') {
			//si el boton presionado es bClear, se limpian las entradas y la caja de texto

			nOperando1 = nOperando2 = nOperador = "";
			textBox.setText("0");

		}else if(aux.charAt(0) == '=') {
			//si se presiona bEquals, se procede a hacer las operaciones correspondientes

			switch(nOperador) {

			case "+": temp = pasarBase10(nOperando1) + pasarBase10(nOperando2);break;//suma
			//case "-": temp = Double.parseDouble(nOperando1) - Double.parseDouble(nOperando2);break;//resta

			}

			textBox.setText(nOperando1+nOperador+nOperando2+ "= "+pasarBase2((int) temp));//se muestra el resultado por pantalla
			/*
			 * cuando el resultado ya esta por pantalla, se iguala el 1er operando al resultado
			 */
			nOperando1 = pasarBase2((int) temp);
			
			/*
			 * se iguala el operando 1 al resultado, y se limpian los otros dos campos, esto sirve para que, en la siguente
			 * entrada, se pase a la proxima instancia else {}
			 */
			nOperador = nOperando2 = "";


		}else {

			if((nOperando1=="")||(nOperando2=="")) {

				nOperador = aux;/*si en alguno de los dos operandos no hay nada, se posiciona en pantalla el operador para que,
									en la proxima entrada, se ingrese el operando 2
				 */

			}else {

				/*
				 * Esta parte del algoritmo sirve cuando, luego de haber apretado el boton bEquals, se quiere seguir calculando con
				 * el resultado obtenido (o sea se presionan + * - /)
				 */


				switch(nOperador) {

				case "+": temp = pasarBase10(nOperando1) + pasarBase10(nOperando2);break;//suma
				//case "-": temp = Double.parseDouble(nOperando1) - Double.parseDouble(nOperando2);break;//resta
	
				}

				nOperando1 = pasarBase2((int) temp);

				nOperador = aux;

				nOperando2 = "";

				textBox.setText(nOperando1+nOperador+nOperando2);

			}

		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {

		String aux = event.getActionCommand();//entrada de eventos
		double temp=0;//resultado de la operacion
		//flagModos		0-Normal | 1-Binario
		
		//se chequea si el evento ocurrio debido al menu... si es asi, cambia de modo

		 if(aux == "Normal"||aux == "->Normal") {
			aux = "";
			flagModos = 0;
			setButtons(flagModos);

		 }else if(aux == "Binario"|| aux =="->Binario") {
			aux = "";
			flagModos = 1;
			JOptionPane.showMessageDialog(menuBar,"WORK IN PROGRESS");
			setButtons(flagModos);
			
		 }else if(aux == "Acerca de") {
			 
			 JOptionPane.showMessageDialog(menuBar, 
			 "Autor   -   Alan Blangille\nVersion  -  1.0\nwww.github.com/arbp97/Calculadora_Java_basico", "Acerca de Calculadora", 1,img2);
			 aux = "";
		 }
		 
		 //entra en la operacion correspondiente segun el modo de la calculadora
		switch(flagModos) {
		
		case 0: operacionDecimal(aux,temp);
			break;
			
		case 1: operacionBinaria(aux,temp);

			break;
			
			
		}//endswitch flagmodos
		
			
	}
	
	private String pasarBase2(int num) {
		
		String binario = "";
		int aux = num;
		
		if(aux == 0) {
			
			binario = "0";
			
		}else if(aux > 0) {
		
			while(aux > 0) {
			
				if(aux % 2 == 0) {
				
					binario = "0" + binario; // de esta manera el numero binario se va escribiendo en el orden correcto *
				
				}else {
				
					binario = "1" + binario; // * poniendo el resultado delante del conjunto
				
					}
			
				aux = aux / 2;
				
			}
		
		}	else {
			
			binario = "numero negativo";
			
		}
		
		
		return binario;
		
	}
	
	private double pasarBase10(String num) {

		double decimal=0;
		double multiplicador=1;
		char nAux;
		int i;

		for(i=num.length()-1;i>=0;i--) {

			nAux = num.charAt(i);
			
			if(nAux == '1') {
				
				decimal += multiplicador;
				
			}

			multiplicador = multiplicador * 2;
			
		}

		return decimal;

	}



	public JButton getN1() {
		return n1;
	}



	public void setN1(JButton n1) {
		this.n1 = n1;
	}



	public JButton getN2() {
		return n2;
	}



	public void setN2(JButton n2) {
		this.n2 = n2;
	}



	public JButton getN3() {
		return n3;
	}



	public void setN3(JButton n3) {
		this.n3 = n3;
	}



	public JButton getN4() {
		return n4;
	}



	public void setN4(JButton n4) {
		this.n4 = n4;
	}



	public JButton getN5() {
		return n5;
	}



	public void setN5(JButton n5) {
		this.n5 = n5;
	}



	public JButton getN6() {
		return n6;
	}



	public void setN6(JButton n6) {
		this.n6 = n6;
	}



	public JButton getN7() {
		return n7;
	}



	public void setN7(JButton n7) {
		this.n7 = n7;
	}



	public JButton getN8() {
		return n8;
	}



	public void setN8(JButton n8) {
		this.n8 = n8;
	}



	public JButton getN9() {
		return n9;
	}



	public void setN9(JButton n9) {
		this.n9 = n9;
	}



	public JButton getN0() {
		return n0;
	}



	public void setN0(JButton n0) {
		this.n0 = n0;
	}



	public JButton getbDot() {
		return bDot;
	}



	public void setbDot(JButton bDot) {
		this.bDot = bDot;
	}



	public JButton getbClear() {
		return bClear;
	}



	public void setbClear(JButton bClear) {
		this.bClear = bClear;
	}



	public JButton getbEquals() {
		return bEquals;
	}



	public void setbEquals(JButton bEquals) {
		this.bEquals = bEquals;
	}



	public JButton getbSuma() {
		return bSuma;
	}



	public void setbSuma(JButton bSuma) {
		this.bSuma = bSuma;
	}



	public JButton getbResta() {
		return bResta;
	}



	public void setbResta(JButton bResta) {
		this.bResta = bResta;
	}



	public JButton getbDiv() {
		return bDiv;
	}



	public void setbDiv(JButton bDiv) {
		this.bDiv = bDiv;
	}



	public JButton getbMult() {
		return bMult;
	}



	public void setbMult(JButton bMult) {
		this.bMult = bMult;
	}



	public String getnOperando1() {
		return nOperando1;
	}



	public void setnOperando1(String nOperando1) {
		this.nOperando1 = nOperando1;
	}



	public String getnOperando2() {
		return nOperando2;
	}



	public void setnOperando2(String nOperando2) {
		this.nOperando2 = nOperando2;
	}



	public String getnOperador() {
		return nOperador;
	}



	public void setnOperador(String nOperador) {
		this.nOperador = nOperador;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public String toString() {
		return "Calculadora [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + ", n5=" + n5 + ", n6=" + n6
				+ ", n7=" + n7 + ", n8=" + n8 + ", n9=" + n9 + ", n0=" + n0 + ", bDot=" + bDot + ", bClear=" + bClear
				+ ", bEquals=" + bEquals + ", bSuma=" + bSuma + ", bResta=" + bResta + ", bDiv=" + bDiv + ", bMult="
				+ bMult + ", nOperando1=" + nOperando1 + ", nOperando2=" + nOperando2 + ", nOperador=" + nOperador
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bClear == null) ? 0 : bClear.hashCode());
		result = prime * result + ((bDiv == null) ? 0 : bDiv.hashCode());
		result = prime * result + ((bDot == null) ? 0 : bDot.hashCode());
		result = prime * result + ((bEquals == null) ? 0 : bEquals.hashCode());
		result = prime * result + ((bMult == null) ? 0 : bMult.hashCode());
		result = prime * result + ((bResta == null) ? 0 : bResta.hashCode());
		result = prime * result + ((bSuma == null) ? 0 : bSuma.hashCode());
		result = prime * result + ((n0 == null) ? 0 : n0.hashCode());
		result = prime * result + ((n1 == null) ? 0 : n1.hashCode());
		result = prime * result + ((n2 == null) ? 0 : n2.hashCode());
		result = prime * result + ((n3 == null) ? 0 : n3.hashCode());
		result = prime * result + ((n4 == null) ? 0 : n4.hashCode());
		result = prime * result + ((n5 == null) ? 0 : n5.hashCode());
		result = prime * result + ((n6 == null) ? 0 : n6.hashCode());
		result = prime * result + ((n7 == null) ? 0 : n7.hashCode());
		result = prime * result + ((n8 == null) ? 0 : n8.hashCode());
		result = prime * result + ((n9 == null) ? 0 : n9.hashCode());
		result = prime * result + ((nOperador == null) ? 0 : nOperador.hashCode());
		result = prime * result + ((nOperando1 == null) ? 0 : nOperando1.hashCode());
		result = prime * result + ((nOperando2 == null) ? 0 : nOperando2.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculadora other = (Calculadora) obj;
		if (bClear == null) {
			if (other.bClear != null)
				return false;
		} else if (!bClear.equals(other.bClear))
			return false;
		if (bDiv == null) {
			if (other.bDiv != null)
				return false;
		} else if (!bDiv.equals(other.bDiv))
			return false;
		if (bDot == null) {
			if (other.bDot != null)
				return false;
		} else if (!bDot.equals(other.bDot))
			return false;
		if (bEquals == null) {
			if (other.bEquals != null)
				return false;
		} else if (!bEquals.equals(other.bEquals))
			return false;
		if (bMult == null) {
			if (other.bMult != null)
				return false;
		} else if (!bMult.equals(other.bMult))
			return false;
		if (bResta == null) {
			if (other.bResta != null)
				return false;
		} else if (!bResta.equals(other.bResta))
			return false;
		if (bSuma == null) {
			if (other.bSuma != null)
				return false;
		} else if (!bSuma.equals(other.bSuma))
			return false;
		if (n0 == null) {
			if (other.n0 != null)
				return false;
		} else if (!n0.equals(other.n0))
			return false;
		if (n1 == null) {
			if (other.n1 != null)
				return false;
		} else if (!n1.equals(other.n1))
			return false;
		if (n2 == null) {
			if (other.n2 != null)
				return false;
		} else if (!n2.equals(other.n2))
			return false;
		if (n3 == null) {
			if (other.n3 != null)
				return false;
		} else if (!n3.equals(other.n3))
			return false;
		if (n4 == null) {
			if (other.n4 != null)
				return false;
		} else if (!n4.equals(other.n4))
			return false;
		if (n5 == null) {
			if (other.n5 != null)
				return false;
		} else if (!n5.equals(other.n5))
			return false;
		if (n6 == null) {
			if (other.n6 != null)
				return false;
		} else if (!n6.equals(other.n6))
			return false;
		if (n7 == null) {
			if (other.n7 != null)
				return false;
		} else if (!n7.equals(other.n7))
			return false;
		if (n8 == null) {
			if (other.n8 != null)
				return false;
		} else if (!n8.equals(other.n8))
			return false;
		if (n9 == null) {
			if (other.n9 != null)
				return false;
		} else if (!n9.equals(other.n9))
			return false;
		if (nOperador == null) {
			if (other.nOperador != null)
				return false;
		} else if (!nOperador.equals(other.nOperador))
			return false;
		if (nOperando1 == null) {
			if (other.nOperando1 != null)
				return false;
		} else if (!nOperando1.equals(other.nOperando1))
			return false;
		if (nOperando2 == null) {
			if (other.nOperando2 != null)
				return false;
		} else if (!nOperando2.equals(other.nOperando2))
			return false;
		return true;
	}




}
