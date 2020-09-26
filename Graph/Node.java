package Graph;

import java.util.LinkedList;

/**
 * Clase Nodo. Implementa un nodo de grafo con arcos dirigidos.
 * @author Victoria Berti, alumna de la Universidad Nacional del Sur.
 */
public class Node {
	
	protected Integer elemento;
	protected LinkedList<Edge> arcosIncidentes;
	protected LinkedList<Edge> arcosEmergentes;


	/**
	 * Inicializa un nodo con un elemento sin arcos.
	 * @param elemento Elemento del nuevo nodo.
	 */
	public Node(Integer elemento) {
		this.elemento = elemento;
		arcosIncidentes = new LinkedList<Edge>();
		arcosEmergentes = new LinkedList<Edge>();
	}
	
	/**
	 * Reemplaza el elemento del nodo por el elemento parametrizado.
	 * @param elemento Nuevo elemento del nodo.
	 */
	public void setElement(Integer elemento) {
		this.elemento = elemento;
	}

	/**
	 * Retorna el elemento contenido en el nodo.
	 * @return Elemento del nodo.
	 */
	public Integer element() {
		return elemento;
	}
	
	/**
	 * Agrega un arco incidente al nodo.
	 * @param arco Arco incidente al nodo.
	 */
	public void addIncident(Edge arco) {
		arcosIncidentes.add(arco);
	}
	
	/**
	 * Agrega un arco emergente del nodo.
	 * @param arco Arco emergente del nodo.
	 */
	public void addEmergent(Edge arco) {
		arcosEmergentes.add(arco);
	}
}
