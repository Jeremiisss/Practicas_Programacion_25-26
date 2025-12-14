// esta clase gestiona el array de animales
public class Inventario {
    private Mascotas[] animales;
    private int numAnimalesActuales;
    private static final int MAX_ANIMALES = 100;

    public Inventario() {
        this.animales = new Mascotas[MAX_ANIMALES];
        this.numAnimalesActuales = 0;
    }

    // Devuelve el animal de una posicion concreta del array
    public Mascotas getAnimal(int indice) {
        if (indice >= 0 && indice < numAnimalesActuales) {
            return animales[indice];
        }
        return null;
    }

    // Devuelve cuantos animales hay
    public int getNumAnimalesActuales() {
        return numAnimalesActuales;
    }

    // para añadir un animal
    public boolean insertarAnimal(Mascotas animal) {
        if (numAnimalesActuales < MAX_ANIMALES) {
            animales[numAnimalesActuales] = animal;
            numAnimalesActuales++;
            return true;
        }
        return false;
    }

    // para eliminar un animal
    public boolean eliminarAnimal(String nombre) {
        int indiceAEliminar = -1;
        for (int i = 0; i < numAnimalesActuales; i++) {
            if (animales[i].getNombre().equalsIgnoreCase(nombre)) {
                indiceAEliminar = i;
                break;
            }
        }

        if (indiceAEliminar != -1) {
            for (int i = indiceAEliminar; i < numAnimalesActuales - 1; i++) {
                animales[i] = animales[i + 1];
            }
            animales[numAnimalesActuales - 1] = null;
            numAnimalesActuales--;
            return true;
        }
        return false;
    }

    // vaciar inventario
    public void vaciarInventario() {
        for (int i = 0; i < numAnimalesActuales; i++) {
            animales[i] = null;
        }
        numAnimalesActuales = 0;
    }
}