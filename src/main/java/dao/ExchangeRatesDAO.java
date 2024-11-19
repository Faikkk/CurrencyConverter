package dao;
import model.ExchangeRatesDTO;

import java.util.List;

public interface ExchangeRatesDAO {
     void addExchangeRates(int BaseCurrencyId, int TargetCurrencyId, long rate);
     void deleteExchangeRate(int BaseCurrencyId, int TargetCurrencyId);
     void updateExchangeRate (int BaseCurrencyId, int TargetCurrencyId, long rate);
     List<ExchangeRatesDTO> getAllExchangeRates();
     ExchangeRatesDTO getExchangeRate (String code);
}
