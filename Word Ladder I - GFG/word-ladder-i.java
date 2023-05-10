//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends



// class Solution
// {
//     //TC: O(n * wordLen * 26)
//     public int wordLadderLength(String startWord, String targetWord, String[] wordList)
//     {
//         Set<String> visited = new HashSet<>(Arrays.asList(wordList));
// 		if (!visited.contains(targetWord)) {
// 			return 0;
// 		}
// 		Queue<String> queue = new LinkedList<>();
// 		queue.offer(startWord);
// 		visited.remove(startWord);
// 		int step = 1;
// 		while (!queue.isEmpty()) {
// 			int size = queue.size();
// 			for (int i = 0; i < size; i++) {
// 				String pollWord = queue.poll();
// 				if (targetWord.equals(pollWord)){
//                     return step;
//                 }
// 				for (int j = 0; j < pollWord.length(); j++) { // TC: O(wordLen)
// 					for (char ch = 'a'; ch <= 'z'; ch++) { // TC: O(26)
// 						char[] charArray = pollWord.toCharArray();
// 						charArray[j] = ch;
// 						String newWord = new String(charArray);
// 						if (visited.contains(newWord)) {
// 							queue.offer(newWord);
// 							visited.remove(newWord);
// 						}
// 					}
// 				}
// 			}
// 			step++;
// 		}
// 		return 0;
//     }
// }



class Solution
{
    class pair{
        String str;
        int step;
        pair(String s,int i)
        {
            str=s;
            step=i;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<pair> q=new ArrayDeque<>();
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.length;i++)
        {
            set.add(wordList[i]);
        }
        q.offer(new pair(startWord,1));
        if(set.contains(startWord))
        {
            set.remove(startWord);
        }
        while(!q.isEmpty())
        {
            pair p=q.poll();
            String cur=p.str;
            int s=p.step;
          // System.out.println(cur+" "+s);
            if(cur.equals(targetWord))
            {
                
                return s;
            }
                
            for(int i=0;i<cur.length();i++)
            {
                for(char c='a';c<='z';c++)
                {
                    // String news=cur.replace(i,c);
                  char[] chars = cur.toCharArray();
 
        // replace character at the specified position in a char array
                chars[i] = c;
 
        // convert the character array back into a string
                String news = String.valueOf(chars);
 
                    
                    if(set.contains(news))
                    {
                        q.offer(new pair(news,s+1));
                        set.remove(news);
                    }
                }
            }
        }
        return 0;
    }
}


