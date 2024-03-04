package Modelo;

import java.awt.HeadlessException;
import Control.Main;

import javax.swing.JOptionPane;

public class Calculadora {
	
	public long valor1;
	public long valor2;
	
	
	public void menu() {
		Main main = new Main();
		int opc1;
		do {
		
			String c;
			opc1 = 0;
			c = "///////////Calculadora.///////////\n"; 
			c +="Elija la operacion que desea hacer\n";
			c +="1. Division.\n";
			c +="2. Factorial.\n";
			c +="3. Combinatoria.\n";
			c +="4. Salir.";
			
			opc1 = Integer.parseInt(JOptionPane.showInputDialog(c));
			if(opc1 == 1) {
				valor1 = Long.parseLong(JOptionPane.showInputDialog("Por favor ingrese el dividendo: "));
				valor2 = Long.parseLong(JOptionPane.showInputDialog("Por favor ingrese el divisor: "));
				
				division(valor1, valor2);
			}
			else if(opc1 == 2) {
				valor1 = Long.parseLong(JOptionPane.showInputDialog("Por favor ingrese un numero para calcular factorial. \nRecuerde que el numero debe ser mayor a 0 "));			
				
				try {
					JOptionPane.showMessageDialog(null, "El factorial es: "+factorial(valor1));
				}catch (Exception e) {
					e.printStackTrace();
					main.exit();
				}
			}
			else if(opc1 ==3) {
				valor1 = Long.parseLong(JOptionPane.showInputDialog("Por favor ingrese el numero total de elementos: "));
				valor2 = Long.parseLong(JOptionPane.showInputDialog("Por favor ingrese el numero de elementos por grupo: "));
				

				try {
					JOptionPane.showMessageDialog(null, "El numero de posibles combinaciones es: "+combinatoria(valor1,valor2));
				}catch (Exception e) {
					e.printStackTrace();
					main.exit();
				}
			}
			else if(opc1 ==4) {
				
				main.exit();
			}
			else {
				JOptionPane.showMessageDialog(null, "Opcion Invalida, Por favor seleccione una opcion que si exista. ");
				
			}
			
		}while(opc1 >=1 || opc1 <=4 );
		
		
	}
	
	
	public void division(Long valor1, Long valor2) {
		double resultado = 0;
		
		try {
			resultado = valor1/valor2;
			JOptionPane.showMessageDialog(null,"El resultado de la division es:"+resultado);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede dividir por cero");
		}
	}
	
	public long factorial(long valor1) throws Exception  {
		Main main = new Main();
		if(valor1 == 1 || valor1 == 0) {
			return 1;	
		}
		
		else if(valor1 < 0) {
			throw new Exception("No se puede calcular el factorial de un numero negativo");
		}
		else if(valor1 > 11) {
			throw new Exception("Por limitaciones tecnicas, no se puede calcular el factorial de un numero mayor que 12");
		}
		
		return valor1 * factorial(valor1 - 1);
	}
	public double combinatoria(long valor1, long valor2) throws Exception {
		long nf = 1,nkf = 0, cancelar = 0;
		double resultado = 0;
		for(long i = valor1; i != valor2; i--) {
			nf *= i;
			cancelar = valor2;
		}
		
		try {
			nkf = factorial(valor1 - valor2);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		if (nkf >= 0 || nf >= 0 ) {
			resultado = (nf/(nkf));
		}
		else if (nkf == 0 || nf == 0){ 
			throw new Exception("Error, no se puede dividir por 0");
		}
		
		return resultado;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
