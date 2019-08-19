package myclient.controller;

import bankservice.Account;
import bankservice.MyService;
import bankservice.MyServiceServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {

    private static MyServiceServiceLocator locator = new MyServiceServiceLocator();
    private static MyService service;

    static {
        try {
            if (service == null) {
                service = locator.getMyServicePort();
            }
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        double balance = Double.valueOf(req.getParameter("balance"));
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setBalance(balance);
        Account result = service.createAccount(account);
        if (result == null) {
            resp.sendError(400, "Bad request");
        } else {
            resp.getWriter().println("okie");
        }
    }
}
