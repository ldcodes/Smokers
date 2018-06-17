package Smokers;

import java.util.Random;

public class Agent extends Thread{


	public void run() {
		int time  = 0;
		while(true) {
			try {
				S.nothing.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				S.mutex.acquire();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(time>5)
				break;
			place();
			S.something.release();
			S.mutex.release();
			time++;
		}
		
	}
	
	public void place() {
		Random r =new Random();
		StringBuilder result = new StringBuilder();
		result.append(" agent put ");
		int m = r.nextInt(3);
		for(int i =0 ;i<3;i++) {
			if(i!=m) {
				S.smoke.get(i).set(true);
				result.append("   "+S.name.get(i));
			}
		}		
		System.out.println(result.toString());
	}
	
	

}
