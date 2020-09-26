package Graph;

/**
 * Clase TestGraph. Verifica el correcto funcionamiento de un grafo dirigido.
 * @author Victoria Berti, alumna de la Universidad Nacional del Sur.
 *
 */
public class TestGraph {
	
	public static void main(String[] args) {
		
		/*------- INICIALIZAR GRAFO -------*/
		
		Graph grafo = new Graph();
		for(int i = 1; i < 8; i++) {
			grafo.addNode(i);
		}
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(2, 4);
		grafo.addEdge(3, 5);
		grafo.addEdge(4, 6);
		grafo.addEdge(5, 6);
		grafo.addEdge(6, 7);
		
		/**
		 * 
		 *     -->[2]
		 *    /     \
		 *   /       -->[4]
		 *  /             \
		 * [1]		       -->[6]--->[7]
		 *  \             /
		 *   \       -->[5]
		 *    \     /
		 *     -->[3]
		 */
		
		/*------- TEST METODOS -------*/
		
		/* 1. addNode funciona correctamente*/
		grafo.addNode(8);
		/* 2. addNode con un nodo ya existente*/
		grafo.addNode(7);
		/* 3. addNode funciona correctamente*/
		grafo.addNode(9);
		
		/* 4. addEdge funciona correctamente */
		grafo.addEdge(4, 5);
		grafo.addEdge(2, 3);
		/* 5. addEdge con dos parámetros iguales */
		grafo.addEdge(7, 7); 
		/* 6. addEdge de un arco que ya existe en la estructura */
		grafo.addEdge(6, 7); 
		/* 7. addEdge con un parámetro que no pertenece a la estructura */
		grafo.addEdge(7, 10);
		
		/* 8. removeNode funciona correctamente*/
		grafo.removeNode(4);
		/* 9. removeNode con un nodo que no pertenece a la estructura */
		grafo.removeNode(11);
		
		/* 10. removeEdge funciona correctamente */
		grafo.removeEdge(5, 6);
		/* 11. removeEdge de un arco que no pertenece a la estructura */
		grafo.removeEdge(11,2);
		/* 12. removeEdge de un arco que fue eliminado anteriormente */
		grafo.removeEdge(5, 6);
		
	}
	
}
