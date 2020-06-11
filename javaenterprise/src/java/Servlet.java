package java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "servlet", urlPatterns = "/sample")
public class Servlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(Servlet.class);

    @Override
    public void init() {
        log.info("App Servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter responseBody = resp.getWriter();

        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">Sample Servlet GET method processing</h1>");


        String client = req.getParameter("client");
        if (client == null) {
            client = "anonymous user";
        }

        responseBody.println("<h3 align=\"center\">Hi, " + client + " </h3>");
    }

    @Override
    public void destroy() {
        log.info("App Servlet destroyed");
    }
}