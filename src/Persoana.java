public class Persoana {
    private String nume;
    private String prenume;
    private short varsta;
    private CardBancar cardBancar;

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {

        return prenume;
    }

    public void preiaCardul(CardBancar cardBancar){
        this.cardBancar = cardBancar;
    }

    public void introduCardul(ATM Atm) {
        Atm.acceptaCardul(this.cardBancar);
    }
}
