import java.util.Scanner;
import java.sql.*;

public class GestorArboles {

	private static final int INSERTAR_ARBOL = 1;
	private static final int ELIMINAR_ARBOL = 2;
	private static final int MODIFICAR_ARBOL = 3;
	private static final int VISUALIZAR_ARBOL = 4;
	private static final int SALIR = 5;

	public void run() throws ClassNotFoundException {

		Connection cx = null;

		Scanner sc = new Scanner(System.in);

		Arbol arbol = new Arbol();

		// AQUI SE CONECTA.
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");

			Statement st = cx.createStatement();

			int opc;

			do {

				System.out.println("-------------------BIENVENIDO-------------------");
				System.out.println(INSERTAR_ARBOL + ".- Insertar arbol.");
				System.out.println(ELIMINAR_ARBOL + ".- Eliminar arbol.");
				System.out.println(MODIFICAR_ARBOL + ".- Modificar arbol.");
				System.out.println(VISUALIZAR_ARBOL + ".- Visualizar arboles.");
				System.out.println(SALIR + ".- salir.");

				opc = Integer.parseInt(sc.nextLine());

				switch (opc) {
				case INSERTAR_ARBOL:

					System.out.println("Introduce el nombre comun del arbol.");
					arbol.setNombre_comun(sc.nextLine());

					System.out.println("Introduce el nombre cientifico del arbol.");
					arbol.setNombre_cientifico(sc.nextLine());

					System.out.println("Introduce el habitat del arbol.");
					arbol.setHabitat(sc.nextLine());

					System.out.println("Introduce la altura del arbol");
					arbol.setAltura(Integer.parseInt(sc.nextLine()));

					System.out.println("Introduce el origen del arbol");
					arbol.setOrigen(sc.nextLine());

					String sentenciaInsert = "INSERT INTO eh_garden (nombre_comun, nombre_cientifico ,habitad ,altura ,origen) VALUES ('"
							+ arbol.getNombre_comun() + "','" + arbol.getNombre_cientifico() + "','"
							+ arbol.getHabitat() + "','" + arbol.getAltura() + "','" + arbol.getOrigen() + "')";
					st.execute(sentenciaInsert);

					break;

				case ELIMINAR_ARBOL:

					System.out.println("Introduce el id del que quieres borrar.");

					int id = Integer.parseInt(sc.nextLine());

					String sentenciaDelete = "DELETE FROM eh_garden WHERE id = id";
					st.execute(sentenciaDelete);

					break;

				case MODIFICAR_ARBOL:

					System.out.println("Introduce el nombre cientifico del arbol que quieres modificar");
					String arbolmod = sc.nextLine();
					
					
					String sentenciaUpdate = "UPDATE eh_garden SET nombre_comun = '" + arbol.getNombre_comun() + "', nombre_cientifico = '" + arbol.getNombre_cientifico() + "', habitad = '" + arbol.getHabitat() + "', altura = '"+arbol.getAltura()+"', origen = '"+arbol.getOrigen()+"' WHERE nombre_cientifico = '"+arbolmod+"'";
					st.executeUpdate(sentenciaUpdate);
					
					
					break;

				case VISUALIZAR_ARBOL:

					
					String sentenciaSelect = "SELECT * FROM eh_garden";
					ResultSet resultSet = st.executeQuery(sentenciaSelect);
					
					break;

				case SALIR:

					System.out.println("-------------------HASTA LA PROXIMA-------------------");

					break;

				}

			} while (opc != SALIR);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		sc.close();
	}

}
