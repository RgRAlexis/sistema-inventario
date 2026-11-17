import java.util.ArrayList;
import java.util.List;

/**
 * Pruebas automatizadas de las clases Producto y BusquedaProductos.
 * Si alguna prueba falla, el programa termina con codigo 1
 * para que GitHub Actions marque la ejecucion como fallida.
 */
public class ProductoTest {

    private static int total = 0;
    private static int fallidas = 0;

    private static void verificar(String descripcion, boolean condicion) {
        total++;
        if (condicion) {
            System.out.println("OK     " + descripcion);
        } else {
            fallidas++;
            System.out.println("FALLA  " + descripcion);
        }
    }

    public static void main(String[] args) {
        Producto producto = new Producto("P001", "Teclado inalambrico", 450.00, 25);

        verificar("getCodigo devuelve P001", "P001".equals(producto.getCodigo()));
        verificar("getNombre devuelve Teclado inalambrico", "Teclado inalambrico".equals(producto.getNombre()));
        verificar("getPrecio devuelve 450.0", producto.getPrecio() == 450.00);
        verificar("getExistencia devuelve 25", producto.getExistencia() == 25);

        List<Producto> inventario = new ArrayList<>();
        inventario.add(producto);
        inventario.add(new Producto("P002", "Mouse optico", 180.00, 40));
        inventario.add(new Producto("P003", "Teclado mecanico", 1200.00, 10));

        Producto encontrado = BusquedaProductos.buscarPorCodigo(inventario, "P002");
        verificar("buscarPorCodigo encuentra P002", encontrado != null && "Mouse optico".equals(encontrado.getNombre()));
        verificar("buscarPorCodigo regresa null si el codigo no existe", BusquedaProductos.buscarPorCodigo(inventario, "X999") == null);
        verificar("buscarPorNombre encuentra 2 teclados", BusquedaProductos.buscarPorNombre(inventario, "teclado").size() == 2);

        System.out.println();
        System.out.println("Pruebas ejecutadas: " + total + ", fallidas: " + fallidas);

        if (fallidas > 0) {
            System.exit(1);
        }
    }
}
