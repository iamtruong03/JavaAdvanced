package threadings;

public class MyThread2 implements Runnable {


	private int order;
	
	public MyThread2(int order) {
		this.order=order;
	}
	
	public void run() {
		int ID=(int)(Math.random()*10000);
		
		//Nghỉ thực thi
		
		System.out.println(order+"Phân tuyến ID="+ID);
		
	}
	public static void main(String[] args) {
		int n=5+(int)(Math.random()*6);
		
		
		Thread t;
		//long bt=System.nanoTime();
		long minisecond = 0;

		
		
;		for(int i=1;i<10;i++) {
			//cấp phát bộ nhớta
			t=new Thread(new MyThread2(i));
			t.start();
			
			
			 minisecond = (int)(Math.random()*1000);
			 
			 //dua phân tuyến vào trạng thái ngủ
			 
			 try {
				t.sleep(minisecond);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		//System.out.println("Nanotimes:"+(System.nanoTime()-bt));
	}

}