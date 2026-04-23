public class Item {
    String nombre, tipo;
    int precio;
    public Item(String nombre, String tipo, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "nombre=" + this.nombre + 
        "\n tipo=" + this.tipo 
        + "\n precio=" + this.precio;
    }
    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public int getPrecio() {
        return precio;
    }
    
}
