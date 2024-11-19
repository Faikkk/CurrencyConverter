package controller;

import com.google.gson.Gson;
import model.CurrenciesDTO;
import service.CurrenciesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"/currencies"})
public class CurrenciesController extends HttpServlet {
    CurrenciesService currenciesService;

    // Manual dependency injection
    public void init() {
        this.currenciesService = new CurrenciesService();
        // Optionally inject a custom DAO if needed
    }

    // Handle POST and GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");



        Gson gson = new Gson();
        String allCurrenciesJSON = gson.toJson(currenciesService.getAllCurrencies());

        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.write(allCurrenciesJSON);
        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        // get 'action' parameter and execute logic based on that
        String action = request.getParameter("action");

        Gson gson = new Gson();
        PrintWriter out = response.getWriter();

        if ("add".equals(action)) {
            //        try {
            // add the currency
            // remember that the attributes come with REQUEST
            String code = request.getParameter("Code");
            String fullName = request.getParameter("Full_name");
            String sign = request.getParameter("Sign");

            currenciesService.addCurrency(code, fullName, sign);

            out.write("The currency with the code " + code + " is added");
//        }

//        catch (IllegalArgumentException e)
//        {
//            System.out.println();
//        }
        } else if ("update".equals(action)) {
            // validate input in the DAOImpl - LATER
            String code = request.getParameter("Code");
            String fullName = request.getParameter("Full_name");
            String sign = request.getParameter("Sign");

            currenciesService.updateCurrency(new CurrenciesDTO(code, fullName, sign));
            out.write("The currency with the code " + code + " is updated");
        }
        else if ("delete".equals(action)) {
            // validate input in the DAOImpl - LATER
            String code = request.getParameter("Code");

            currenciesService.deleteCurrency(code);
            out.write("The currency with the code " + code + " is deleted");
        }

        else if ("getByCode".equals(action)) {
            // validate input in the DAOImpl - LATER
            String code = request.getParameter("Code");

            CurrenciesDTO currency = currenciesService.getCurrencyByCode(code);
            out.write("The currency with the code " + code + " is " + currency.getFullName());
        }

        out.close();


    }


}
