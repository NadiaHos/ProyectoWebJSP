package entidades;

public enum EstadoPrestamo {
    PENDIENTE("pendiente"),
    APROBADO("aprobado"),
    PAGADO("pagado"),
    RECHAZADO("rechazado");

    private String valor;

    EstadoPrestamo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static EstadoPrestamo fromString(String texto) {
        for (EstadoPrestamo estado : EstadoPrestamo.values()) {
            if (estado.valor.equalsIgnoreCase(texto)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Estado no válido: " + texto);
    }
}
