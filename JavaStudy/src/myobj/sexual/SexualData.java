package myobj.sexual;

public class SexualData {
	
	static int kor;
	static int eng;
	static int math;

	
	final static int MAX_SCORE = 100;
    
    public SexualData() {
    	kor = randomScore();
    	eng = randomScore();
    	math = randomScore();
    }
    
    public static int randomScore() {
		return (int)(Math.random() * (MAX_SCORE +1));
	}
    
    public double average() {
    	return (kor + eng + math) / 3.0;
    }
    
}
