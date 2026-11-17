import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto dentro del Sistema de Inventario.
 */
public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int existencia;

    public Producto(String codigo, String nombre, double precio, int existencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencia = existencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getExistencia() {
        return existencia;
    }

    /**
     * Muestra la información del producto en pantalla.
     */
    public void mostrarInformacion() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Existencia: " + existencia + " unidades");
        System.out.println("Producto registrado y disponible");
    }

    /**
     * Carga el inventario desde un archivo CSV (codigo,nombre,precio,existencia).
     */
    static List<Producto> cargarInventario(Path archivo) throws IOException {
        List<Producto> inventario = new ArrayList<>();
        for (String linea : Files.readAllLines(archivo)) {
            if (linea.isBlank() || linea.startsWith("codigo")) {
                continue;
            }
            String[] c = linea.split(",");
            inventario.add(new Producto(c[0], c[1], Double.parseDouble(c[2]), Integer.parseInt(c[3])));
        }
        return inventario;
    }

    public static void main(String[] args) throws IOException {
        List<Producto> inventario = cargarInventario(Path.of("inventario.csv"));

        System.out.println("=== Inventario (" + inventario.size() + " productos) ===");
        double valorTotal = 0;
        for (Producto p : inventario) {
            p.mostrarInformacion();
            valorTotal += p.getPrecio() * p.getExistencia();
            System.out.println("---");
        }
        System.out.println("Valor total del inventario: $" + valorTotal);
    }
}
