package controller;

import com.google.gson.Gson;
import model.ExchangeRatesDTO;
import service.CurrenciesService;
import service.ExchangeRatesService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/exchangeRates"})
public class ExchangeRatesController extends HttpServlet {
    ExchangeRatesService exchangeRatesService;
    CurrenciesService currenciesService;


    public void init() {
        this.exchangeRatesService = new ExchangeRatesService();
        this.currenciesService = new CurrenciesService();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        String action = request.getParameter("action");
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();

        if ("conversion".equals(action)) {
            String baseCurCode = (request.getParameter("from"));
            String targetCurCode = (request.getParameter("to"));
            int baseCurId = currenciesService.getCurrencyByCode(baseCurCode).getId();
            int targetCurId = currenciesService.getCurrencyByCode(targetCurCode).getId();
            int dollarCurId = currenciesService.getCurrencyByCode("USD").getId();
            int amount = Integer.parseInt(request.getParameter("amount"));
            double convertedAmount = 0;
//            double USDtoBase = 0;
//            double USDtoTarget = 0;
//            double BaseToTarget = 0;
            // check if such an entry is present;
            // loop through each entry and check if at each point if conversion AB is present in the table;
            // otherwise, check for BA and calculate AB from that

            // which pattern can be applied here?
            List<ExchangeRatesDTO> listOfExchangeRates = exchangeRatesService.getAllExchangeRates();
            for (ExchangeRatesDTO DTO : listOfExchangeRates) {
                if (baseCurId == DTO.getBaseCurrencyId() && targetCurId == DTO.getTargetCurrencyId()) {
                    convertedAmount = amount * DTO.getRate();
                } else if (baseCurId == DTO.getTargetCurrencyId() && targetCurId == DTO.getBaseCurrencyId()) {
                    convertedAmount = amount * (1 / DTO.getRate());
                }

                // check if the rates for conversion to dollars exist
//                else if ((dollarCurId == DTO.getBaseCurrencyId() && baseCurId == DTO.getTargetCurrencyId()) &&
//                        (dollarCurId == DTO.getBaseCurrencyId() && targetCurId == DTO.getTargetCurrencyId())) {
//
//                }

            }
            out.write(String.valueOf(convertedAmount));

        } else if ("getAll".equals(action)) {
            String AllExchangeRatesJSON = gson.toJson(exchangeRatesService.getAllExchangeRates());
            response.setStatus(HttpServletResponse.SC_OK);
            out.write(AllExchangeRatesJSON);
        }
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        String action = request.getParameter("action");
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
    }

}
