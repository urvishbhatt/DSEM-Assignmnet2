package com.example.appengine.java8;

import com.example.appengine.java8.Entity.Candidate;
import com.example.appengine.java8.Services.CandidateService;
import com.example.appengine.java8.Services.UploadEmailService;
import com.example.appengine.java8.Services.VotingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UploadEmailService uploadEmailService = new UploadEmailService();
        VotingService votingService = new VotingService();
        int CASTED_Votes = votingService.numberOfVote();
        int ELIGIBLE_Voter = uploadEmailService.numberOfVoter();
        long Percentage;

        if (CASTED_Votes == 0 || ELIGIBLE_Voter == 0) {
            Percentage = 0;
        }else {
            Percentage = (CASTED_Votes*100)/ELIGIBLE_Voter;
        }

        CandidateService candidateService = new CandidateService();
        List<Candidate> candidateList = candidateService.getCandidateList();

        List<Integer> candidateVotes = new ArrayList<>();
        for (Candidate candidate : candidateList){
            candidateVotes.add(votingService.candidateVote(candidate.key));
        }

        req.setAttribute("candidateName",candidateList);
        req.setAttribute("candidateVotes",candidateVotes);
        req.setAttribute("CASTED_Votes",CASTED_Votes);
        req.setAttribute("ELIGIBLE_Voter",ELIGIBLE_Voter);
        req.setAttribute("Percentage",Percentage);
        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
