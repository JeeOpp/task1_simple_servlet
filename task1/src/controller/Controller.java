package controller;

import entity.PersonBean;
import service.Service;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import org.apache.log4j.*;

/**
 * Created by DNAPC on 08.11.2017.
 */
public class Controller extends HttpServlet {
    private static final Logger log = Logger.getLogger(Controller.class.getClass());

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Service service = serviceFactory.getService();
        
        PersonBean person;

        try {
            person = service.findPerson(name, surname);

            req.setAttribute("person", person);
            req.getRequestDispatcher("/table.jsp").forward(req,resp);

            log.info("success");
        }catch (SQLException ex){
            log.error(ex);
        }
    }
}
