//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static List<String> wordBreak(int n, List<String> dict, String s){

        List<String> li = new ArrayList<>();

        List<String> sentence = new ArrayList<>();

        String str = "";

        solve(li, dict, sentence, str, 0, s);

        return li;

    }

    

    

    static void addingSentence(List<String> li, List<String> sentence){

        String S = ""; 

        for(int i=0; i<sentence.size(); i++)

            S += sentence.get(i);

        li.add(S);    

        return;

    }

    

    

    static void solve(List<String> li, List<String> dict, List<String> sentence, String str, int i, String S){        

        str += S.charAt(i);        

        if(i==S.length()-1){

            if(dict.contains(str)){

                sentence.add(str);

                addingSentence(li, sentence);      //add to final answer

                sentence.remove(sentence.size()-1);

            }    

            return;    

        }

        

        if(dict.contains(str)){

            sentence.add(str);     //add string

            sentence.add(" ");    //add space

            

            String word = "";

            solve(li, dict, sentence, word, i+1, S); 

            

            sentence.remove(sentence.size()-1);   //remove space 

            sentence.remove(sentence.size()-1);  //remove last added string

            

        }

        solve(li, dict, sentence, str, i+1, S);

    }

}

