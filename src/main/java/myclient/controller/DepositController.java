package myclient.controller;

import bankservice.Account;
import bankservice.MyService;
import bankservice.MyServiceServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepositController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(DepositController.class.getSimpleName());

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
        req.getRequestDispatcher("/deposit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String content = req.getParameter("content");
        double balance = Double.valueOf(req.getParameter("balance"));

        LOGGER.log(Level.INFO, String.format("Content: %s", content));
        Account result = service.deposit(username, password, balance, content);
        if (result == null) {
            resp.sendError(400, "Bad request");
        } else {
            resp.getWriter().println("okie");
        }
    }
}
