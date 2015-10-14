import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

	public class ComparaContenido {
		private File f1, f2;
		
	public ComparaContenido(){
		//DECLARACIÓN DE 2 FICHEROS
				f1 = new File("fichero1.txt");
				f2 = new File("fichero2.txt");
				
				//METODOS QUE EJECUTARAN LAS FUNCIONES
				
				//this.comparaContenido(f1, f2);
				int res = buscarPalabra(f1, "foyone", false);
				System.out.println(res);
				
				//Mostramos por consola el resultado
	}

	public boolean comparaContenido(File f1, File f2) throws IOException{
	    FileReader fr1 = new FileReader("fichero1.txt");
	    FileReader fr2 = new FileReader("fichero2.txt");
	     
	    BufferedReader bf1 = new BufferedReader(fr1);
	    BufferedReader bf2 = new BufferedReader(fr2);
		
	    String Cadena1 = bf1.readLine();
	    String Cadena2 = bf2.readLine();
	    boolean iguales = true;
	    
		while ((Cadena1!=null) && (Cadena2!=null) && iguales) {
	     
	      if (!Cadena1.equals(Cadena2))
	        iguales = false;
	     
	      Cadena1 = bf1.readLine();
	      Cadena2 = bf2.readLine();
	    } 
	    
	    if((iguales) && (Cadena1==null) && (Cadena2==null)){
			System.out.println("Ficheros Iguales");
	    	return true;

		}
		System.out.println("Ficheros diferentes");
		return false;

		
		
	}
	
	public int buscarPalabra(File f1, String palabra, Boolean primera){		
		//Declaramos un arrayList para poder almacenar las palabras encontradas
		ArrayList<String> palabrasEncontradas = new ArrayList<String>();
		String cadena1;
		Boolean encontrada=false;
		int contadorPalabras=0;
		int contadorLineas=0;
			try{
				if(f1.exists()==false){
					System.out.println("El fichero no existe");
					return -1;
				}
				
			FileReader fr1 = new FileReader("fichero1.txt");
		    BufferedReader bf1 = new BufferedReader(fr1);
		    cadena1 = bf1.readLine();
	
			    while ((cadena1!=null)){
			    	//Incrementamos el contador de las lineas del fichero
			    	contadorLineas++;
			    	if(cadena1.equals(palabra)){
			    		//Seteamos el booleano que nos indica que hemos encontrado la palabra a verdadero
			    		encontrada=true;
			    		//Imprimimos por consola la linea en la que se ha encontrado la palabra(mera info)
			    		System.out.println("Palabra "+palabra+" encontrada en la linea "+contadorLineas);
			    		//añadimos al ArrayList la palabra en la posicion correspondiente al orden en la que la encontramos
			    		palabrasEncontradas.add(String.valueOf(contadorLineas));
			    
			    	//Leemos nueva linea
			    	cadena1 = bf1.readLine();
		
			    	}else{
			    	cadena1 = bf1.readLine();
			    	}
			    }
			    bf1.close();
			    fr1.close();
		    
			}catch(IOException e){
				System.err.println("Error I/O");
				}
				
			//Aplicamos las condiciones de impresion y devolucion de dato
					if ((primera==true) && (encontrada==true)){
				    		System.out.println("La primera palabra ("+palabra+") se encuentra en la linea "+palabrasEncontradas.get(0));
				    		return Integer.parseInt(palabrasEncontradas.get(0));
				    }
						
					else if((primera==false) && (encontrada==true)){
				    		System.out.println("La última palabra ("+palabra+") se encuentra en la linea "+palabrasEncontradas.get(palabrasEncontradas.size()-1));
							return Integer.parseInt(palabrasEncontradas.get(palabrasEncontradas.size()-1));
					}
					else{
						return -1;
					}
						
			    		
	}
}
	
