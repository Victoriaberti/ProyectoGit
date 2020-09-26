package Graph;

/**
 * Clase Edge. Implementa un arco dirigido.
 * @author Victoria Berti, alumna de la Universidad Nacional del Sur.
 */
public class Edge {
	
	protected Node sucesor, predecesor;
	
	/**
	 * Inicializa un nuevo arco dirigido.
	 * @param predecesor Nodo del cual emerge el arco.
	 * @param sucesor Nodo en el cual incide el arco.
	 */
	public Edge(Node predecesor, Node sucesor) {
		this.predecesor = predecesor;
		this.sucesor = sucesor;
	}

	/**
	 * Retorna el nodo del cual emerge el arco.
	 * @return Nodo del cual emerge el arco.
	 */
	public Node getPred() {
		return predecesor;
	}

	/**
	 * Retorna el nodo en el cual incide el arco.
	 * @return Nodo en el cual incide el arco.
	 */
	public Node getSuces() {
		return sucesor;
	}

}
