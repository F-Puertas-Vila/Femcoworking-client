package IOCaldades;

public class Usuari {

    public Usuari(String PROVEIDOR, String nom, String direccio, String cifEmpresa, String poblacio, String provincia, String email, String contrasenya) {
        this.rol = PROVEIDOR;
        this.nom = nom;
        this.direccio=direccio;
        this.cifEmpresa = cifEmpresa;
        this.poblacio = poblacio;
        this.provincia = provincia;
        this.email = email;
        this.contrasenya = contrasenya;
    }

    private String rol;
    private String nom;
    private String direccio;
    private String cifEmpresa;
    private String poblacio;
    private String provincia;
    private String email;
    private String contrasenya;
  

    public Usuari() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCifEmpresa() {
        return cifEmpresa;
    }

    public void setCifEmpresa(String cifEmpresa) {
        this.cifEmpresa = cifEmpresa;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Usuari(String nomUsuari, String contrasenya) {
        this.email = nomUsuari;
        this.contrasenya = contrasenya;
    }

    public String getNomUsuari() {
        return email;
    }

    public void setNomUsuari(String nomUsuari) {
        this.email = nomUsuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
