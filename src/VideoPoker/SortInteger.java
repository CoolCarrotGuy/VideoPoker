package VideoPoker;

import java.util.Arrays;

public abstract class SortInteger {
	
	/* Fields */
	final int[] values;
	
	
	/* Protected methods */
	
	protected final int compare(int i, int j){
		
		int i1=values[i], i2=values[j];
		if (i1==i2) return 0;
		else return (i1<i2 ? -1 : 1); //e.g: max = (a > b) ? a : b;
	}
	
	protected final void swap(int i, int j){
		
		int tmp=values[i];
		values[i]=values[j];
		values[j]=tmp;
	}
	
	protected abstract void doSort();
	
	protected int getDataLength(){
		return values.length;
	}
	
	/* Public constructor and methods */
	
	public SortInteger(int[] v){
		values=v;
	}
	
	public final void sort(){
		
		doSort();
	}
	
	@Override
	public String toString() {
		return "SortInteger [values=" + Arrays.toString(values)+"]";
	}

	
	

}

