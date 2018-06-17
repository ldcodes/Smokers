package Smokers;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class S {//Solution
	
	public static Semaphore mutex = new Semaphore(1);
	public static Semaphore nothing = new Semaphore(1);
	public static Semaphore something = new Semaphore(0);
	public static ArrayList<AtomicBoolean> smoke = new ArrayList<AtomicBoolean>();
	public static ArrayList<String> name = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicBoolean paper = new AtomicBoolean(false);
		AtomicBoolean tobacco = new AtomicBoolean(false);
		AtomicBoolean match = new AtomicBoolean(false);
		smoke.add(paper);
		smoke.add(tobacco);
		smoke.add(match);
		name.add("paper");
		name.add("tobacco");
		name.add("match");
	
		
		ArrayList<Smoker> smokers =new ArrayList<Smoker>();
		Smoker s_p = new Smoker();
		Smoker s_t = new Smoker();
		Smoker s_m = new Smoker();
		s_p.setDaemon(true);
		s_t.setDaemon(true);
		s_m.setDaemon(true);
		s_p.number = 0;
		s_t.number = 1;
		s_m.number = 2;
		
		
		smokers.add(s_p);
		smokers.add(s_t);
		smokers.add(s_m);		
	
		Agent agent = new Agent();
		s_p.start();
		s_m.start();
		s_t.start();
		agent.start();
		
	}

}
