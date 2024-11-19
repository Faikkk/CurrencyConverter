package service;

import dao.CurrenciesDAO;
import dao.CurrenciesDAOImpl;
import model.CurrenciesDTO;

import java.util.List;

public class CurrenciesService {
    // Manually inject the DAO
    private final CurrenciesDAO currenciesDAO;

    public CurrenciesService() {
        this.currenciesDAO = new CurrenciesDAOImpl();
    }


    public List<CurrenciesDTO> getAllCurrencies (){
        List<CurrenciesDTO> currenciesDTOList = currenciesDAO.getAllCurrencies();
        return currenciesDTOList;
    }

    public CurrenciesDTO getCurrencyByCode(String code) {
        return currenciesDAO.getCurrencyByCode(code);
    }

    public void addCurrency (String code, String fullName, String sign){
        currenciesDAO.addCurrency(code,fullName,sign);
    }


    public void updateCurrency(CurrenciesDTO currency){
        currenciesDAO.updateCurrency(currency);
    }

    public void deleteCurrency(String code){
        currenciesDAO.deleteCurrency(code);
    }

}
