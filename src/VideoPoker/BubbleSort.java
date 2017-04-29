package VideoPoker;


public class BubbleSort extends SortInteger{

	/* Protected methods */
	
	protected void doSort(){
		boolean bswap;
		do {
			bswap = false;
			for (int i=0; i<getDataLength()-1; i++) {
				if (compare(i,i+1)>0){
					swap(i,i+1);
					bswap = true;
				}
			}
		} while (bswap); 
	}
	
	/* Public constructors */
	public BubbleSort(int[] v){
		super(v);
	}
	
}
