package CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class UCL {

    static class Team{

        String name;
        int points;
        int goalDiff;
        public Team(String name, int points, int goalDiff) {
            this.name= name;
            this.points= points;
            this.goalDiff = goalDiff;
        }
    }

    public static void main(String args[]) throws java.lang.Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int testCases = Integer.parseInt(br.readLine().trim());
            for(int i=0;i<testCases;i++){
                HashMap<String,Team> teamDetails = new HashMap<>();
                for(int match = 0; match<12;match++){
                    StringTokenizer st = new StringTokenizer(br.readLine().trim());
                    String team1 = st.nextToken();
                    int goal1 = Integer.parseInt(st.nextToken());
                    st.nextToken();
                    int goal2 = Integer.parseInt(st.nextToken());
                    String team2 = st.nextToken();
                    if(!teamDetails.containsKey(team1)){
                        teamDetails.put(team1, new Team(team1,0,0));
                    }
                    if(!teamDetails.containsKey(team2)){
                        teamDetails.put(team2, new Team(team2,0,0));
                    }

                    if(goal1>goal2){
                        teamDetails.get(team1).points +=3;
                        teamDetails.get(team2).points +=0;
                    }
                    else if(goal2>goal1){
                        teamDetails.get(team2).points +=3;
                        teamDetails.get(team1).points +=1;
                    }
                    else{
                        teamDetails.get(team1).points +=1;
                        teamDetails.get(team2).points +=1;
                    }
                    teamDetails.get(team1).goalDiff +=(goal1-goal2);
                    teamDetails.get(team2).goalDiff +=(goal2-goal1);

                }
                PriorityQueue<Team> topTwo = new PriorityQueue<>(2, Comparator.comparing((Team t) ->t.points).thenComparing((Team t)->t.goalDiff).reversed());
                topTwo.addAll(teamDetails.values());
                System.out.println(topTwo.poll().name+" "+topTwo.poll().name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
