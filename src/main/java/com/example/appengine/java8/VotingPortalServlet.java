package com.example.appengine.java8;

import com.example.appengine.java8.Entity.Candidate;
import com.example.appengine.java8.Services.CandidateService;
import com.example.appengine.java8.Services.VotingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adding_vote_database")
public class VotingPortalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateService candidateService = new CandidateService();
        List<Candidate> candidateList = candidateService.getCandidateList();
        req.setAttribute("CandidateList",candidateList);
        req.getRequestDispatcher("/voting_portal.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Candidate_Name = req.getParameter("candidate_name_vote").trim();
        String Token_Number = req.getParameter("student_key").trim();

        VotingService votingService = new VotingService();
        votingService.AddingTODatabase(Candidate_Name, Token_Number);
    }
}
