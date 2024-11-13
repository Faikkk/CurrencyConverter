package dao;

import model.Currencies;

import java.util.List;

public interface CurrenciesDAO {
    // define CRUD operations
    public void addCurrency (int id);
    public void deleteCurrency (int id);
    public void updateUser (Currencies currency);
    public List<Currencies> getAllCurrencies();
    public Currencies getCurrencyById (int id);
}
