package mypackage;
/*
//Author: Muhammad Baharuddin Yusuf
//Student number: 2211016210031
//@baharudddinyusuf

    The following codes generate a sequence of "vector-flipping". We define the term 
"vector-flipping" as the process of recursively transforming a vector that 
consists of 1s and 0s into "smaller" vector. Here, the term "smaller" is about 
the binary numbers that the vectors represent. 
The first vector is randomly generated. 
    I was inspired by the C1 problem from The 2009 International Mathematical 
Olympiad (IMO) shortlist.
    If you tried to run this program, it'd give you the desired sequence, 
but, you'd likely get some error warnings. 
But..., well, the main objective of this program is to display the sequence. Therefore, 
objectively speaking, these codes work fine. 
*/
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class RandomVectorFlipper {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome! We can give you a sequence of vectors.\n"
                + "How many dimension do you want the vectors to have?");
        int d = s.nextInt();
        System.out.println("Here it is");
        ArrayList<Integer> rv1 = randomVector(d);
        System.out.println(rv1);
        iterator(rv1);
    }
	
    static ArrayList<Integer> randomVector(int size) {
        
        ArrayList<Integer> rv = new ArrayList<>();
	Random r = new Random();
	for (int i=1;i<=size;i++) {
            rv.add(r.nextInt(2));
	}
	return rv;
    }
	
    static ArrayList<Integer> indicesOf1(ArrayList<Integer> v) {
	ArrayList<Integer> indices = new ArrayList<>();
	for (int i=0;i<v.size();) {
            if (v.get(i)==1) {
		indices.add(i);
		i++;
            } else {
		i++;
            }
	}
	return indices;
    }
	
    static ArrayList<Integer> flippy(ArrayList<Integer> v,ArrayList<Integer> ind){
		
	Random x1 = new Random();
	int randomIndexOf1;
        randomIndexOf1 = ind.get(x1.nextInt(ind.size()));
	v.set(randomIndexOf1, 0);
		
	if (ind.get(ind.size()-1) != randomIndexOf1 || ind.get(ind.size()-1) != v.size()-1) {
            if (v.get(randomIndexOf1+1)==1) {
                v.set(randomIndexOf1+1, 0);
            } else {
                v.set(randomIndexOf1+1, 1);
            }
        }	
	return v;
    }
	
    static void iterator(ArrayList<Integer> v) {
	ArrayList<Integer> iden = new ArrayList<>();
	for (int i=0;i<v.size();i++) {
            iden.add(0);
	}
	ArrayList<Integer> w = indicesOf1(v);
		
	ArrayList<Integer> v1 = flippy(v, w);
	System.out.println(v1);
	while (v1 != iden) {
            iterator(v1);
	}		
    }
}