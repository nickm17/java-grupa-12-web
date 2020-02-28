package siit;

import org.thymeleaf.context.WebContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import siit.model.Customer;

@WebServlet(urlPatterns = "/customersWithThymeleaf", loadOnStartup = 1)
public class CustomerServletThymeleaf extends HttpServlet {

    private List<Customer> customers = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // afisam in pagina utilizand thymeleaf
        // procedeul este similar cu folosirea paginilor JSP doar ca aici folosim pagini html
        // paginile html contin acum si atribute si taguri specifice librariei thymeleaf
        // iar pentru directionarea spre o pagina html a unor atribute folosim clasa WebContext din thymeleaf si TemplateEngine configurat in clasa ThymeleafAppUtil
        WebContext ctx = new WebContext(request, response, request.getServletContext(),
                request.getLocale());

        customers.add(new Customer(1, "Ion Thymeleaf", "07689544444", "Bucuresti"));
        customers.add(new Customer(1, "Ion Thymeleaf", "07689544444", "Bucuresti"));
        customers.add(new Customer(1, "Ion Thymeleaf", "07689544444", "Bucuresti"));
        customers.add(new Customer(1, "Ion Thymeleaf", "07689544444", "Bucuresti"));

        // aici trimitem lista de customers catre pagina html pentru afisare
        ctx.setVariable("customers", customers);

        // specificam pagina html din din folderul templates in care sa mearga sa afiseze customerii
        ThymeleafAppUtil.getTemplateEngine().process("Customers", ctx, response.getWriter());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // pentru a face un obiect de tipul Customer din request procedam astfel:
        Customer customer = new Customer();
        customer.setName(request.getParameter("name").toString());
        customer.setPhone(request.getParameter("phone").toString());
        // aici am putea apela layer-ul de DAO pentru a persista un customer
        customers.add(customer);
        // Folosim acest
        WebContext ctx = new WebContext(request, response, request.getServletContext(),
                request.getLocale());

        // adaugam variabile pe care le folosim in pagina html
        ctx.setVariable("customers", customers);
        ctx.setVariable("customerCreated", "Customer " + request.getParameter("name") + "  created successfully");

        // specificam in ce pagina sa mearga
        ThymeleafAppUtil.getTemplateEngine().process("Customers", ctx, response.getWriter());
    }
}
