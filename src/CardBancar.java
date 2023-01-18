import java.time.LocalDate;

public class CardBancar {
    private final String nume;
    private final String numarCard;
    private final LocalDate expirationDate;
    private final String pin;
    private final String cvv;

    public CardBancar(String nume, String numarCard, String pin, String cvv) {
        this.nume = nume;
        this.numarCard = numarCard;
        this.pin = pin;
        this.cvv = cvv;
        expirationDate = LocalDate.now().plusYears(5);
    }

    public String getNume(){

        return nume;
    }

    public String getNumarCard() {
        return numarCard;
    }

    public LocalDate getExpirationDate() {

        return expirationDate;
    }

    public String getPin() {

        return pin;
    }

    public String getCvv() {

        return cvv;
    }
}
