import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class GestorArboles {

	private static final int INSERTAR_ARBOL = 1;
	private static final int ELIMINAR_ARBOL = 2;
	private static final int MODIFICAR_ARBOL = 3;
	private static final int VISUALIZAR_ARBOL = 4;
	private static final int SALIR = 5;

	public void run() {
		
		ArrayList<Arbol> arboles = new ArrayList<Arbol>();
		
		Scanner sc = new Scanner(System.in);
		
		int opc = Integer.parseInt(sc.nextLine());
		
		do {
			
		}while(opc != SALIR);
		
	}

}
