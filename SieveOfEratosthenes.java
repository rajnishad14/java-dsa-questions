public class SieveOfEratosthenes {
    boolean prime[];
    int n;
    public SieveOfEratosthenes(int n){
        this.prime=new boolean[n+1];
        this.n=n;
    }
    public void primes(){
        for(int i=2;i*i<=this.n;i++){
            if(this.prime[i]==false){
                for(int j=i*i;j<=n;j+=i){
                    this.prime[j]=true;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(this.prime[i]==false){
                System.out.print(i+" ");
            }
        }
    }
}
