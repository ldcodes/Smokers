package Smokers;

public class Smoker extends Thread{

	private boolean see =false;
	public int number ;
	public void run() {
		while(true) {
			
			if(!see) {
				
				try {
					S.something.acquire();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				try {
					S.mutex.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
					if(!S.smoke.get(number).get()) {
						for(int i =0; i<3 ;i++) {
							if( i != number) {
								S.smoke.get(i).set(false);
							}
						}				
						
						S.nothing.release();
						System.out.println("Smoker who has "+S.name.get(number)+" is smoking");
					}else {
						System.out.println("Smoker who has "+S.name.get(number)+"  is not  smoking");
					     S.something.release();
					    
					}						
				S.mutex.release();
				 try {
						this.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}//if 

			
		}//while
	}
}
