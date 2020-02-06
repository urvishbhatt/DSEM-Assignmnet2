package com.example.appengine.java8;

import com.example.appengine.java8.Entity.Emails;
import com.example.appengine.java8.Services.UploadEmailService;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet("/backend/send_mail")
public class BackendServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/backendservlet.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        User user = UserServiceFactory.getUserService().getCurrentUser();

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(user.getEmail()));

            UploadEmailService uploadEmailService = new UploadEmailService();
            List<Emails> uploadEmailServiceList = uploadEmailService.getMail();

            for (Emails emails : uploadEmailServiceList){
                msg.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(emails.getEmail()));
            }
            msg.setSubject("DSG - Email Reminder");
            msg.setText("Please use this link to assign vote https://dsg-assignmnet2.appspot.com/user/voting_portal");
            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
