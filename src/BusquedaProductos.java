import java.util.ArrayList;
import java.util.List;

/**
 * Permite buscar productos dentro del inventario.
 */
public class BusquedaProductos {

    /**
     * Busca un producto por su código. Regresa null si no existe.
     */
    public static Producto buscarPorCodigo(List<Producto> productos, String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Busca los productos cuyo nombre contiene el texto indicado.
     */
    public static List<Producto> buscarPorNombre(List<Producto> productos, String texto) {
        List<Producto> resultados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    public static void main(String[] args) {
        List<Producto> inventario = new ArrayList<>();
        inventario.add(new Producto("P001", "Teclado inalambrico", 450.00, 25));
        inventario.add(new Producto("P002", "Mouse optico", 180.00, 40));
        inventario.add(new Producto("P003", "Teclado mecanico", 1200.00, 10));

        System.out.println("Busqueda por codigo P002:");
        Producto encontrado = buscarPorCodigo(inventario, "P002");
        if (encontrado != null) {
            encontrado.mostrarInformacion();
        } else {
            System.out.println("Producto no encontrado");
        }

        System.out.println();
        System.out.println("Busqueda por nombre 'teclado':");
        for (Producto producto : buscarPorNombre(inventario, "teclado")) {
            producto.mostrarInformacion();
            System.out.println("---");
        }
    }
}
