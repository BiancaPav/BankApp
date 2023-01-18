import java.math.BigDecimal;

public class ContBancar {
    private String iban;
    private String valuta;
    private BigDecimal sumaDisponibila;
    private CardBancar cardBancarAsociatContului;

    public ContBancar(String iban, String valuta){
        this.iban = iban;
        this.valuta = valuta;
        this.sumaDisponibila = BigDecimal.ZERO;
    }
    public void adaugaBani(BigDecimal bani){
        sumaDisponibila = sumaDisponibila.add(bani);
    }
    public BigDecimal getSumaDisponibila(){
        return sumaDisponibila;
    }
    public String getValuta(){
        return valuta;
    }
    public void setCardBancarAsociatContului(CardBancar cardBancar){
        cardBancarAsociatContului = cardBancar;
    }
    public CardBancar getCardBancar(){
        return cardBancarAsociatContului;
    }
    public void retrageBani(BigDecimal bani){
        sumaDisponibila = sumaDisponibila.subtract(bani);
    }
}
