package siit;

import org.thymeleaf.context.WebContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import siit.model.Customer;

@WebServlet(name = "CustomerServletJSP", urlPatterns = {"/customersWithJsp"})
public class CustomerServletJSP extends HttpServlet {
    List<Customer> customers = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            customers.add(new Customer(1, "Ion", "07689544444", "Bucuresti"));
            customers.add(new Customer(1, "Ion", "07689544444", "Bucuresti"));
            customers.add(new Customer(1, "Ion", "07689544444", "Bucuresti"));
            customers.add(new Customer(1, "Ion", "07689544444", "Bucuresti"));
            customers.add(new Customer(1, "Ion", "07689544444", "Bucuresti"));
            customers.add(new Customer(1, "Ion", "07689544444", "Bucuresti"));
            customers.add(new Customer(1, "Ion", "07689544444", "Bucuresti"));

            // Facem forward catre alt servlet/ pagina jsp folosind RequestDispacher
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Customer_Details.jsp");
            // adaugam un attribut pe care o sa il preluam in pagina JSP
            request.setAttribute("customers", customers);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
