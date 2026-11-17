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
        this.nombre = nombre
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
        Producto producto = new Producto("P001", "Teclado inalambrico", 450.00, 25);
        producto.mostrarInformacion();
    }
}
