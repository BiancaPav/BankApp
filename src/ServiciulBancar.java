public class ServiciulBancar {
    ClientBancar[] clientiiBancii = new ClientBancar[100];
    private int counterClienti = 0;

    public CardBancar creeazaCont(Persoana persoana) {
        for (ClientBancar client : clientiiBancii) {
            if (client == null) {
                continue;
            }
            if (persoana.getNume().equals(client.getNume()) && persoana.getPrenume().equals(client.getPrenume())) {
                System.out.println("Clientul deja exista: " + client);
                return null;
            }
        }
        ClientBancar clientBancar = new ClientBancar(persoana.getNume(), persoana.getPrenume());
        clientiiBancii[counterClienti] = clientBancar;
        counterClienti++;
        ContBancar contBancar = new ContBancar("RO666665", "RON");
        clientBancar.adaugaContBancar(contBancar);
        CardBancar cardBancar = new CardBancar(persoana.getNume() + " " + persoana.getPrenume(), "1111222233334444", "1234", "321");
        contBancar.setCardBancarAsociatContului(cardBancar);
        return cardBancar; //output
    }
    public ContBancar findBankAccountByCard(CardBancar cardBancar){
        for (ClientBancar client : clientiiBancii){
            if (client == null) {
                continue;
            }
            ContBancar cont = client.getContBancar();
            if(cont == null){
                continue;
            }
            CardBancar card = cont.getCardBancar();
            if(card == null){
                continue;
            }
            if(!card.getExpirationDate().equals(cardBancar.getExpirationDate())){
                continue;
            }
            if(!card.getPin().equals(cardBancar.getPin())){
                continue;
            }
            if(!card.getNumarCard().equals(cardBancar.getNumarCard())){
                continue;
            }
            if(!card.getNume().equals(cardBancar.getNume())){
                continue;
            }
            if(!card.getCvv().equals(cardBancar.getCvv())){
                continue;
            }
            return cont;
        }
        return null;
    }

}
