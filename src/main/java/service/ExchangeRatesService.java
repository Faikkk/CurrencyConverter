package service;

import dao.ExchangeRatesDAO;
import dao.ExchangeRatesDAOImpl;
import model.ExchangeRatesDTO;

import java.util.List;

public class ExchangeRatesService {

    private final ExchangeRatesDAO exchangeRatesDAO;

    public ExchangeRatesService(){
        this.exchangeRatesDAO = new ExchangeRatesDAOImpl();
    }

    public List<ExchangeRatesDTO> getAllExchangeRates(){
    return exchangeRatesDAO.getAllExchangeRates();
    }
}
