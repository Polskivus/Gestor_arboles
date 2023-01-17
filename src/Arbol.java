
public class Arbol {

	private int ID;
	private String nombre_comun;
	private String nombre_cientifico;
	private String habitat;
	private int altura;
	private String origen;

	public Arbol() {

	}

	public Arbol(int ID, String nombre_comun, String nombre_cientifico, String habitat, int altura, String origen) {
		this.ID = ID;
		this.nombre_comun = nombre_comun;
		this.nombre_cientifico = nombre_cientifico;
		this.habitat = habitat;
		this.altura = altura;
		this.origen = origen;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre_comun() {
		return nombre_comun;
	}

	public void setNombre_comun(String nombre_comun) {
		this.nombre_comun = nombre_comun;
	}

	public String getNombre_cientifico() {
		return nombre_cientifico;
	}

	public void setNombre_cientifico(String nombre_cientifico) {
		this.nombre_cientifico = nombre_cientifico;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

}
