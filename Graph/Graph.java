package Graph;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Filter;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Clase Graph. Implementa un grafo dirigido no pesado.
 * @author Victoria Berti, alumna de la Universidad Nacional del Sur.
 */
public class Graph {
	
	protected LinkedList<Node> listaNodos;
	protected LinkedList<Edge> listaArcos;
	protected static Logger logger;
	
	/**
	 * Inicializa un nuevo grafo vacío.
	 */
	public Graph() {
		listaNodos = new LinkedList<Node>();
		listaArcos = new LinkedList<Edge>();
		if(logger == null) {
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler handler = new ConsoleHandler();
			handler.setLevel(Level.FINE);
			logger.addHandler(handler);
			
			logger.setLevel(Level.INFO);
			
			Logger rootLogger = logger.getParent();
			for(Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
	}

	/**
	 * Agrega un nodo sin arcos al grafo, si el nodo no se encuentra en el grafo.
	 * @param node Elemento del nuevo nodo.
	 */
	public void addNode(int node) {
		Node nodo;
		if(buscarNodo(node) == null) {
			nodo = new Node(node);
			listaNodos.add(nodo);
			logger.info("El nodo fue insertado correctamente con "+node+" como elemento.");
		}
		else
			logger.warning("El grafo ya contiene un nodo con el elemento "+node+".");
	}
	
	/**
	 * Agrega un arco entre dos nodos, si aún no existe el arco y ambos parámetros son nodos pertenecientes al grafo.
	 * @param node1 Nodo origen del arco.
	 * @param node2 Nodo destino del arco.
	 */
	public void addEdge(int node1, int node2) {
		Iterator<Node> itNodos = listaNodos.iterator();
		Node nodo1 = null, nodo2 = null, posicion;
		Edge arco;
		boolean encontre = false;
		if(node1 != node2) {
			while(!encontre && itNodos.hasNext()) {
				posicion = itNodos.next();
				if(posicion.element() == node1)
					nodo1 = posicion;
				else if(posicion.element() == node2)
					nodo2 = posicion;
				if(nodo1 != null && nodo2 != null)
					encontre = true;
			}
			arco = existeArco(node1,node2);
			if(encontre && arco == null) {
				arco = new Edge(nodo1, nodo2);
				nodo1.addEmergent(arco);
				nodo2.addIncident(arco);
				listaArcos.add(arco);
				logger.info("El arco con origen en "+node1+" y destino en "+node2+" fue insertado correctamente.");
			}
			else if(arco != null)
				logger.warning("El grafo ya contiene un arco con origen en "+node1+" y destino en "+node2+".");
			else if(!encontre)
				logger.severe("Al menos uno de los parámetros no corresponde a un nodo del grafo.");
		}
		else
			logger.warning("No es posible generar un arco entre los nodos "+node1+" y "+node2+".");	
	}
	
	/**
	 * Remueve el nodo parametrizado del grafo, si este nodo pertenece al grafo. 
	 * @param node Nodo a remover.
	 */
	public void removeNode(int node) {
		Node nodo = buscarNodo(node);
		Edge arco;
		Iterator<Edge> itArcos;
		LinkedList <Edge> aEliminar;
		if(nodo != null) {
			itArcos = listaArcos.iterator();
			aEliminar = new LinkedList<Edge>();
			while(itArcos.hasNext()) {
				arco = itArcos.next();
				if(arco.getPred().element().equals(node)) {
					arco.getPred().addEmergent(null);
					aEliminar.add(arco);
				}
				if(arco.getSuces().element().equals(node)) {
					arco.getSuces().addIncident(null);
					aEliminar.add(arco);
				}
			}
			listaArcos.removeAll(aEliminar);
			nodo.setElement(null);
			listaNodos.remove(nodo);
			logger.info("El nodo "+node+" ha sido eliminado correctamente.");
		}
		else
			logger.severe("El grafo no contiene ningún nodo con elemento "+node+".");
	}
	
	/**
	 * Remueve el arco que emerge desde el nodo "node1" e incide en el nodo "node2", si este arco pertenece a la estructura.
	 * @param node1 Nodo predecesor del arco a remover.
	 * @param node2 Nodo sucesor del arco a remover.
	 */
	public void removeEdge(int node1, int node2){
		Edge arco = existeArco(node1,node2);
		if(arco!=null) {
			arco.getPred().addEmergent(null);
			arco.getSuces().addIncident(null);
			listaArcos.remove(arco);
			logger.info("El arco con origen en "+node1+" y destino en "+node2+" ha sido eliminado correctamente.");
		}
		else if(buscarNodo(node1) == null || buscarNodo(node2) == null)
			logger.severe("Al menos uno de los parámetros no corresponde a un nodo del grafo.");
		else
			logger.warning("El grafo no contiene ningún arco con origen en "+node1+" y destino en "+node2+".");
	}
	
	/**
	 * Verifica si el grafo contiene un arco con origen en "nodo1" y destino en "nodo2".
	 * @param nodo1 Nodo origen del arco.
	 * @param nodo2 Nodo destino del arco.
	 * @return Un arco desde "nodo1" hasta "nodo2" si este arco existe en la estructura, null en caso contrario.
	 */
	protected Edge existeArco(int nodo1, int nodo2) {
		boolean existe = false;
		Iterator<Edge> itArcos = listaArcos.iterator();
		Edge arco = null;
		while(!existe && itArcos.hasNext()) {
			arco = itArcos.next();
			if(arco.getPred().element().equals(nodo1) && arco.getSuces().element().equals(nodo2))
				existe = true;
		}
		if(!existe)
			arco = null;
		return arco;
		
	}
	
	/**
	 * Verifica si el grafo contiene un nodo con "num" como elemento.
	 * @param num Elemento del nodo a buscar.
	 * @return Un nodo si existe un nodo con "num" como elemento, null en caso contrario.
	 */
	protected Node buscarNodo(int num) {
		Node nodo = null;
		boolean encontre = false;
		Iterator<Node> itNodos = listaNodos.iterator();
		while(itNodos.hasNext() && !encontre) {
			nodo = itNodos.next();
			if(nodo.element()==num)
				encontre = true;
		}
		if(!encontre)
			nodo = null;
		return nodo;
	}

}