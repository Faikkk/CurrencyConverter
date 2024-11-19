package dao;

import model.CurrenciesDTO;

import java.util.List;

public interface CurrenciesDAO {
    // define CRUD operations
     void addCurrency (String code, String fullName, String sign);
     void deleteCurrency (String code);
     void updateCurrency (CurrenciesDTO currency);
     List<CurrenciesDTO> getAllCurrencies();
     CurrenciesDTO getCurrencyByCode (String code);
}
