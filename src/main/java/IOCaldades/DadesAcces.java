package IOCaldades;

public class DadesAcces {

    private String email;
    private String contrasenya;

    public DadesAcces(String email, String contrasenya) {
        this.email = email;
        this.contrasenya = contrasenya;
    }

    public DadesAcces() {

    }

    public String getEmail() {
        return email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}
