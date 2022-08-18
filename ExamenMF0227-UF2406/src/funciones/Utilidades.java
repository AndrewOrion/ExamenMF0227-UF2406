package funciones;

/**
 * 
 * @author Andrew
 * Clase que define una funci�n para calcular nota de un alumno
 * 
 */
public class Utilidades {
	
/**
 * M�todo que recibe como par�metro una nota y devuelve si esa nota significa:
 * -Suspenso entre 0 y menos de 5
 * -Bien entre 5 y menos de 6.5
 * -Notable entre 6.5 y menos de 8.5
 * -Sobresaliente entre 8.5 y menos de 10
 * -Matr�cula nota de 10
 * 
 * @param nota : es el par�metro que indica la nota num�rica que ha obtenido el alumno
 * @return devuelve una cadena con el texto (Suspenso, Bien, Notable, Sobresaliente o Matr�cula)
 */

	public String devuelveNota(double nota) {
		String descripcion = "Matr�cula";
		
		if (nota<0.0 || nota >10) {
			throw new ArithmeticException("La nota debe estar entre 0.0 y 10");
		} else if (nota<5.0) {
			descripcion="Suspenso";
		} else if (nota <6.5) {
			descripcion = "Bien";
		} else if (nota<8.5) {
			descripcion ="Notable";
		} else if (nota<10) {
			descripcion ="Sobresaliente";
		} else {
			descripcion = "Matr�cula";
		}
		return descripcion;
	}
}
