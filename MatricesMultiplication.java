package mypackage;
import java.util.ArrayList;

class MatricesMultiplication {
	//you must group the right hand side matrix according to its columns
	public static void main(String[] args) {
		
		double[][] x = {{1,2,1},{-1,2,3}};
		double[][] y = {{1,2,1},{1,1,0}};
		
		if(x[0].length == y[0].length) {
			display(xmatrices(x,y));
		} else {
			System.out.println("The two matrices cannot be multiplied");
		}
		
	}
	
	static double dotprod(double[] row,double[] col) {
		
		ArrayList<Double> res = new ArrayList<>();
		for(int i=0;i<row.length;i++) {
			res.add(row[i]*col[i]);
		}
		for(int i=1;i<res.size();i++) {
			res.set(i, res.get(i)+res.get(i-1));
		}
		double result = res.get(res.size()-1);
		return result;
	}
	
	static double[] createrow(double[] row,double[][] secmatr) {
		
		double[] rowel = new double[secmatr.length];
		for(int i=0;i<secmatr.length;i++) {
			rowel[i] = dotprod(row,secmatr[i]);
		}
		return rowel;
	}
	
	static double[][] xmatrices(double[][] left, double[][] right){
		
		double[][] theresult = new double[left.length][right.length];
		for(int i=0; i<theresult.length;i++) {
			theresult[i] = createrow(left[i],right); 
		}
		return theresult;
	}
	
	static void display(double[][] x) {
		
		for(double[] xi:x) {
			for(int j=0;j<x[0].length;j++) {
				System.out.print(xi[j]+"  ");
			}
			System.out.println();
		}
	}
}
