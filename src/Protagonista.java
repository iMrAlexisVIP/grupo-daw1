public class Protagonista {
 private String nombre;
 private String atk;
 private String hp;
 private String oro;
 private Item item;
    public Protagonista(String nombre, String atk, String hp, String oro, Item item) {
        this.nombre = nombre;
        this.atk = atk;
        this.hp = hp;
        this.oro = oro;
        this.item = item;
    }
    public String toFile(String delimitador) {
        String linea= this.nombre + delimitador
        + this.atk + delimitador +
        this.hp + delimitador 
        + this.oro + delimitador +
         this.item + "\n";
        return linea;
    }
    @Override
    public String toString() {
        return "Protagonista: " + 
        "Nombre: " + nombre + "\n"
        + "Ataque: " + atk + "\n"+
         "Vida: " + hp + "\n"+
         "Oro: " + oro + "\n"+
         "Item: " + item + "\n";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAtk() {
        return atk;
    }

    public void setAtk(String atk) {
        this.atk = atk;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getOro() {
        return oro;
    }

    public void setOro(String oro) {
        this.oro = oro;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
