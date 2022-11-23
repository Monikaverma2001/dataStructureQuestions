
//approach1.
class PrimeOrNot
{
  public boolean isPrime(int n)
  {
    for(int i=2;i<n-1;i++)
    {
      if(n%i==0)
        return false;
    }
    return true;
  }
  public static void main(String[] args)
  {
    int num=2;
    System.out.println(isPrime(num));
  }
}

//approach2 update the function isPrime as follows
public boolean isPrime(int n)
  {
    for(int i=2;i*i<=n;i++)
    {
      if(n%i==0)
        return false;
    }
    return true;
  }
