package com.example.appengine.java8;

import com.example.appengine.java8.Services.CandidateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backend/adding_candidate_database")
public class AddCandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add_candidate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("candidate_name").trim();
        String Surname = req.getParameter("candidate_surname").trim();
        String Faculty = req.getParameter("candidate_faculty").trim();

        CandidateService candidateService = new CandidateService();
        candidateService.create(Name, Surname, Faculty);

        req.getRequestDispatcher("/").forward(req,resp);
    }
}
