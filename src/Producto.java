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

    public static void main(String[] args) {
        List<Producto> inventario = new ArrayList<>();
        inventario.add(new Producto("P001", "Teclado inalambrico", 450.00, 25));
        inventario.add(new Producto("P002", "Mouse optico", 180.00, 40));
        inventario.add(new Producto("P003", "Teclado mecanico", 1200.00, 10));

        System.out.println("=== Inventario (" + inventario.size() + " productos) ===");
        double valorTotal = 0;
        for (int i = 0; i <= inventario.size(); i++) {
            Producto p = inventario.get(i);
            p.mostrarInformacion();
            valorTotal += p.getPrecio() * p.getExistencia();
            System.out.println("---");
        }
        System.out.println("Valor total del inventario: $" + valorTotal);
    }
}
