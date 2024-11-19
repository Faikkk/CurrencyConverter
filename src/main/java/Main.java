import model.CurrenciesDTO;
import model.ExchangeRatesDTO;
import service.CurrenciesService;
import service.ExchangeRatesService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        CurrenciesService currenciesService = new CurrenciesService();
        ExchangeRatesService exchangeRatesService = new ExchangeRatesService();

        CurrenciesDTO currency = new CurrenciesDTO();

        String baseCurCode = "AUD";
        String targetCurCode = "USD";
        int baseCurId = currenciesService.getCurrencyByCode(baseCurCode).getId();
        int targetCurId = currenciesService.getCurrencyByCode(targetCurCode).getId();
        System.out.println(baseCurId + targetCurId);
        int amount = 10;
        double amountConv = 0d;
        // check if such an entry is present:
        // loop through each entry and check if at each point, there is one with baseCode and targetCode

        List<ExchangeRatesDTO> listOfExchangeRates = exchangeRatesService.getAllExchangeRates();
        System.out.println(listOfExchangeRates);
        for (ExchangeRatesDTO DTO : listOfExchangeRates) {

            if (baseCurId == DTO.getBaseCurrencyId() && targetCurId == DTO.getTargetCurrencyId())
            {
//                convertedAmount = amount * DTO.getRate();
                System.out.println("YES");
                amountConv = DTO.getRate() * amount;
                System.out.println(amountConv);
            }
        }

//        String one = String.valueOf(convertedAmount);
//        System.out.println(convertedAmount);
//        currency.setCode("AZN");
//        currency.setSign("₼");
//        currency.setFullName("Azerbaijani Manat");
//
        // WORKS
//        currenciesDAO.addCurrency(currency);


        // WORKS
//        currenciesDAO.deleteCurrency("AZN");

//        System.out.println(currenciesService.getCurrencyByCode("USD"));
//        System.out.println(currenciesService.getAllCurrencies());
    }
}
