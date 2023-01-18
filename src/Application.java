public class Application {
    public static void main(String[] args) {

        Persoana andreea = new Persoana("Alexe", "Andreea");
        ServiciulBancar bt = new ServiciulBancar();
        ServiciulBancar bcr = new ServiciulBancar();
        ServiciulBancar ing = new ServiciulBancar();
        CardBancar cardBancar = bt.creeazaCont(andreea);
        andreea.preiaCardul(cardBancar);
        ATM btAtm = new ATM(bt);
        ATM ingAtm = new ATM(ing);
        andreea.introduCardul(btAtm);
        andreea.introduCardul(ingAtm);
    }
}
