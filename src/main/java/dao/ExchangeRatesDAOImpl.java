package dao;

import model.ExchangeRatesDTO;
import util.DataSourceFactory;
import util.MySQLDataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRatesDAOImpl implements ExchangeRatesDAO {
    DataSourceFactory dataSource;

    public ExchangeRatesDAOImpl()
    {
     this.dataSource = new MySQLDataSourceFactory();
    }

    @Override
    public void addExchangeRates(int BaseCurrencyId, int TargetCurrencyId, long rate) {

    }

    @Override
    public void deleteExchangeRate(int BaseCurrencyId, int TargetCurrencyId) {

    }

    @Override
    public void updateExchangeRate(int BaseCurrencyId, int TargetCurrencyId, long rate) {

    }

    @Override
    public List<ExchangeRatesDTO> getAllExchangeRates() {
        String query = "SELECT * FROM ExchangeRates;";
        List<ExchangeRatesDTO> list = new ArrayList<>();

        try(Connection conn = dataSource.getDataSource().getConnection();
            PreparedStatement stms = conn.prepareStatement(query);
            ResultSet rs = stms.executeQuery();)
        {

            while (rs.next())
            {
                int baseCurrencyId = rs.getInt("BaseCurrencyId");
                int targetCurrencyId = rs.getInt("TargetCurrencyId");
                double rate = rs.getDouble("Rate");
                list.add(new ExchangeRatesDTO(baseCurrencyId,targetCurrencyId,rate));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public ExchangeRatesDTO getExchangeRate(String code) {
        return null;
    }
}
