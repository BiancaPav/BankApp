public class ClientBancar {
    private String nume;
    private String prenume;
    public ContBancar contBancar;

    public ClientBancar(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    @Override
    public String toString() {
        return "ClientBancar{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
    public void adaugaContBancar(ContBancar contBancar){
        this.contBancar = contBancar;
    }
    public ContBancar getContBancar(){
        return contBancar;
    }
}
