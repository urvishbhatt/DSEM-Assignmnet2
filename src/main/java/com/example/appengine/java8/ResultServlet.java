package com.example.appengine.java8;

import com.example.appengine.java8.Entity.Candidate;
import com.example.appengine.java8.Entity.SortbyVote;
import com.example.appengine.java8.Entity.Votes;
import com.example.appengine.java8.Entity.VotingResult;
import com.example.appengine.java8.Services.CandidateService;
import com.example.appengine.java8.Services.UploadEmailService;
import com.example.appengine.java8.Services.VotingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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
//        List<String> candidateKey = new ArrayList<>();

        List<Votes> votesList = votingService.getVote();
        List<String> vote_to_List = new ArrayList<>();

        for (Votes votes : votesList){
            vote_to_List.add(votes.getVote_to());
        }

//        for (Candidate candidate : candidateList){
//            candidateKey.add(candidate.getKey());
//        }

        Map<String, Integer> countMap = new HashMap<>();

        for (String item: vote_to_List) {
            if (countMap.containsKey(item))
                countMap.put(item, countMap.get(item) + 1);
            else
                countMap.put(item, 1);
        }

        List<VotingResult> votingResultList = new ArrayList<>();
        for (Candidate candidate : candidateList){
            if (countMap.containsKey(candidate.key)){
                VotingResult votingResult = new VotingResult(candidate.name,candidate.faculty,countMap.get(candidate.key));
                votingResultList.add(votingResult);
            }else {
                VotingResult votingResult = new VotingResult(candidate.name,candidate.faculty,0);
                votingResultList.add(votingResult);
            }
        }

        Collections.sort(votingResultList, new SortbyVote());

        List<Integer> integerList = new ArrayList<>();
        for (VotingResult votingResult : votingResultList){
            integerList.add(votingResult.getVotes());
        }

        int maxVote = Collections.max(integerList);

        String winner = "Not yet";
        for (VotingResult votingResult : votingResultList){
            if (maxVote == votingResult.getVotes()){
                winner = votingResult.getName();
            }
        }

        req.setAttribute("winner",winner);
        req.setAttribute("votingResultList",votingResultList);
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
