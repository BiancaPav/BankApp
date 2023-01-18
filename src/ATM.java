import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class ATM {
    private ServiciulBancar serviciulBancar;

    private Scanner scanner = new Scanner(System.in);
    private Scanner scannerInt = new Scanner(System.in);

    public ATM(ServiciulBancar serviciulBancar) {
        this.serviciulBancar = serviciulBancar;
    }

    public void acceptaCardul(CardBancar cardBancar) {
        if(cardBancar.getExpirationDate().isBefore(LocalDate.now())){
            System.out.println("Cardul este expirat");
            return;
        }
        String PIN;
        int nrMaxIncercari = 3;

        do {
            if (nrMaxIncercari == 3) {
                System.out.print("Introdu pin: ");
            } else {
                System.out.print("Reintrodu pin: ");
            }

            PIN = scanner.nextLine();

            nrMaxIncercari--;
        } while (nrMaxIncercari > 0 && !PIN.equals(cardBancar.getPin()));
        if (PIN.equals(cardBancar.getPin())) {
            ContBancar contBancar = serviciulBancar.findBankAccountByCard(cardBancar);

            if(contBancar == null){
                System.out.println("Nu s-a gasit cont bancar asociat cardului.");
                return;
            }

            while (true) {
                afisareMeniu();
                int optiune = selectareOptiune();
                gestionareOptiune(optiune, contBancar);

                System.out.println("Doriti sa continuati? Da/Nu");
                String raspuns = scanner.nextLine();
                if (raspuns.equalsIgnoreCase("Nu")) {
                    return;
                }
            }
        } else {
            System.out.println("Pin incorect, tranzactie esuata.");
        }
    }

    private void afisareMeniu() {
        System.out.println("1.Depunere numerar");
        System.out.println("2.Retragere numerar");
        System.out.println("3.Verificare sold");
    }

    private int selectareOptiune() {
        System.out.print("Alege optiune: ");
        int optiune = scannerInt.nextInt();
        return optiune;
    }

    private void gestionareOptiune(int optiune, ContBancar contBancar) {
        switch (optiune) {
            case 1:
                gestioneazaDepunereBani(contBancar);
                break;
            case 2:
                gestioneazaRetragereNumerar(contBancar);
                break;
            case 3:
                gestioneazaSold(contBancar);
                break;
            default:
                System.out.println("Optiune gresita");
        }
    }

    private void gestioneazaSold(ContBancar contBancar) {
        System.out.println("Sold disponibil: " + contBancar.getSumaDisponibila() + contBancar.getValuta());
    }

    private void gestioneazaDepunereBani(ContBancar contBancar) {
        System.out.println("Ce suma de bani doriti sa depuneti?");
        String sumaDeBani;
        sumaDeBani = scanner.nextLine();
        BigDecimal bani = new BigDecimal(sumaDeBani);
        contBancar.adaugaBani(bani);
    }
    private void gestioneazaRetragereNumerar(ContBancar contBancar){
        System.out.println("Ce suma de bani doriti sa retrageti?");
        System.out.println("1. 10 Lei");
        System.out.println("2. 50 Lei");
        System.out.println("3. 100 Lei");
        System.out.println("4. Alta suma");

        int optiune = selectareOptiune();
        BigDecimal sumaDeRetras = BigDecimal.ZERO;
        switch (optiune) {
            case 1:
                sumaDeRetras = new BigDecimal(10);
                break;
            case 2:
                sumaDeRetras = new BigDecimal(50);
                break;
            case 3:
                sumaDeRetras = new BigDecimal(100);
                break;
            case 4:
                System.out.print("Introduceti suma de bani dorita: ");
                sumaDeRetras= scanner.nextBigDecimal();
                break;
            default:
                System.out.println("Optiune gresita");
        }
        if(contBancar.getSumaDisponibila().compareTo(sumaDeRetras) >=0){
            contBancar.retrageBani(sumaDeRetras);
        } else{
            System.out.println("Fonduri insuficiente: " + contBancar.getSumaDisponibila() + contBancar.getValuta());
        }
    }
}

