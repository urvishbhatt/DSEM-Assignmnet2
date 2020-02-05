package com.example.appengine.java8;

import com.example.appengine.java8.Services.DateSetter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/backend/date_pick_form")
public class DatePickerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/datepicker.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        try {
            java.util.Date begin_date = formatter.parse(req.getParameter("begin_date"));
            java.util.Date end_date = formatter.parse(req.getParameter("ending_date"));

            DateSetter dateSetter = new DateSetter();
            dateSetter.create(begin_date,end_date);

            req.getRequestDispatcher("/").forward(req,resp);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}