//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int num;
            num = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[][] Q = IntMatrix.input(br, num, 3);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.solveQueries(N, num, A, Q);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {

    public static ArrayList<Integer> solveQueries(int N, int num, int[] A, int[][] Q) {

        // code here

        ArrayList<Integer> arrl =new ArrayList<>();

        

        for(int row=0;row<num;row++){

 

            int l=Q[row][0];

            int r=Q[row][1];

            int k=Q[row][2];

            

            HashMap<Integer,Integer> hm=new HashMap<>();

            for(int i=l;i<N;i++){

                if(hm.containsKey(A[i])){

                    hm.put(A[i],hm.get(A[i])+1);

                }

                else{

                    hm.put(A[i],1);

                }

            }

            int count=0;

            

            for(int i=l;i<=r;i++){

                int c=hm.get(A[i]);

                if(c==k){

                    count++;

                }

                if(c==1){

                    hm.remove(A[i]);

                }

                else{

                    hm.put(A[i],c-1);

                }

                

            }

            arrl.add(count);

        }

        return arrl;

        

    }

}

 
