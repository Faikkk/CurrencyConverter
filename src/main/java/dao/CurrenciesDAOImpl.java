package dao;

import model.CurrenciesDTO;
import util.MySQLDataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrenciesDAOImpl implements CurrenciesDAO {
    private final MySQLDataSourceFactory mySQLDataSourceFactory;

    // Manual DI inside the default constructor
    public CurrenciesDAOImpl() {
        this.mySQLDataSourceFactory = new MySQLDataSourceFactory();
    }

    @Override
    public void addCurrency(String codeV, String fullNameV, String signV) {

        // validate

        if (codeV.length() != 3){
            throw new IllegalArgumentException("Currency code is not of length 3.");
        }


        String query = "INSERT INTO Currencies (code,fullName,sign) VALUES (?,?,?);";

        try (Connection conn = mySQLDataSourceFactory.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);) {
            stmt.setString(1,codeV);
            stmt.setString(2,fullNameV);
            stmt.setString(3,signV);
            int rowsAdded = stmt.executeUpdate();
            System.out.println("The number of rows added: " + rowsAdded);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

// don't implement that just yet, learn more security measures
    private String sanitizeInput(String input){
        if (input!=null){
            return input.replaceAll("<", "&lt;").replaceAll(">", "&gt;").trim();
        }
        return null;
    }
    @Override
    public void deleteCurrency(String code) {
        String query = "DELETE FROM Currencies WHERE code = ?;";
        try (Connection conn = mySQLDataSourceFactory.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, code);
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("The row with code " + code + " is deleted.\n"
                    + "Overall, " + rowsDeleted + " rows are deleted.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateCurrency(CurrenciesDTO currency) {
        String query = "UPDATE Currencies SET fullName = ?, sign = ? WHERE code = ?;";

        try (Connection conn = mySQLDataSourceFactory.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, currency.getFullName());
            stmt.setString(2, currency.getSign());
            stmt.setString(3, currency.getCode());
            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Number of row(s) updated: " + rowsUpdated);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<CurrenciesDTO> getAllCurrencies() {
        String query = "SELECT * FROM Currencies;";
        List<CurrenciesDTO> currenciesDTOList = new ArrayList<>();
        try (Connection conn = mySQLDataSourceFactory.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CurrenciesDTO currency = new CurrenciesDTO();
                currency.setId(rs.getInt("id"));
                currency.setCode(rs.getString("code"));
                currency.setFullName(rs.getString("fullName"));
                currency.setSign(rs.getString("sign"));
                currenciesDTOList.add(currency);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currenciesDTOList;
    }

    @Override
    public CurrenciesDTO getCurrencyByCode(String code) {
        String query = "SELECT * FROM Currencies WHERE code = ?;";
        CurrenciesDTO currency = new CurrenciesDTO();
        try (Connection conn = mySQLDataSourceFactory.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);) {
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                System.out.println("Such an entry is not present.");
            }
            while (rs.next()) {
                currency.setId(rs.getInt("id"));
                currency.setCode(rs.getString("code"));
                currency.setFullName(rs.getString("fullName"));
                currency.setSign(rs.getString("sign"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return currency;
    }
}
