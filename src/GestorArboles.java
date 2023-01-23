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

		PreparedStatement preparest;
		
		// AQUI SE CONECTA.
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");

			Statement st = cx.createStatement();
			

			int opc;

			do {

				System.out.println("-------------------BIENVENIDO-------------------\n");
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

					String sentenciaInsert = "INSERT INTO eh_garden (nombre_comun, nombre_cientifico ,habitad ,altura ,origen) VALUES (?,?,?,?,?)";
					
					PreparedStatement preparsetinser = cx.prepareStatement(sentenciaInsert);
					
					preparsetinser.setString(1, arbol.getNombre_comun());
					preparsetinser.setString(2, arbol.getNombre_cientifico());
					preparsetinser.setString(3, arbol.getHabitat());
					preparsetinser.setInt(4, arbol.getAltura());
					preparsetinser.setString(5, arbol.getOrigen());
					
					preparsetinser.executeUpdate();
					
					System.out.println("-------------------REGISTRADO-------------------\n");

					break;

				case ELIMINAR_ARBOL:

					System.out.println("Introduce el id del que quieres borrar.");

					int id = Integer.parseInt(sc.nextLine());

					String sentenciaDelete = "DELETE FROM eh_garden WHERE id = ?";
					
					PreparedStatement prepstatedel = cx.prepareStatement(sentenciaDelete);
					
					prepstatedel.setInt(1, id);
					
					prepstatedel.executeUpdate();

					System.out.println("-------------------ELIMINADO-------------------\n");
					
					break;

				case MODIFICAR_ARBOL:

					System.out.println("Introduce el id del arbol que quieres modificar");
					int arbolmod = Integer.parseInt(sc.nextLine());
					
					System.out.println("Introduce nuevo nombre comun");
					arbol.setNombre_comun(sc.nextLine());
					
					System.out.println("Introduce nuevo nombre cientifico.");
					arbol.setNombre_cientifico(sc.nextLine());
					
					System.out.println("Introduce nuevo habitad.");
					arbol.setHabitat(sc.nextLine());
					
					System.out.println("Introduce la nueva altura.");
					arbol.setAltura(Integer.parseInt(sc.nextLine()));
					
					System.out.println("Introduce nuevo origen.");
					arbol.setOrigen(sc.nextLine());
					
					
					preparest = cx.prepareStatement("UPDATE eh_garden SET nombre_comun = ? ,nombre_cientifico = ? ,habitad = ?,altura = ?,origen = ? WHERE id =?");
					preparest.setString(1, arbol.getNombre_comun());
					preparest.setString(2, arbol.getNombre_cientifico());
					preparest.setString(3, arbol.getHabitat());
					preparest.setInt(4, arbol.getAltura());
					preparest.setString(5, arbol.getOrigen());
					preparest.setInt(6, arbolmod);
					preparest.executeUpdate();
					
					System.out.println("-------------------MODIFICADO-------------------\n");
					
					break;

				case VISUALIZAR_ARBOL:

					
					String sentenciaSelect = "SELECT * FROM eh_garden";
					ResultSet resultSet = st.executeQuery(sentenciaSelect);
					
					System.out.println("-------------------RESULTADO-------------------\n");
					
					while(resultSet.next()) {
						//System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2)+" - "+resultSet.getString(3)+" - "+resultSet.getString(4)+" - "+resultSet.getInt(5)+" - "+resultSet.getString(6));
					
						
					}
					
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
