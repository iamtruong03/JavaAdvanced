package threadings;

import java.util.Iterator;

public class MyThread1 extends Thread {

	private int order;

	public MyThread1(int order, ThreadGroup tg) {
		super(tg, "T" + order);
		this.order = order;
	}

	public void run() {
		int ID = (int) (Math.random() * 10000);
		int pri = 1 + (int) (Math.random() * 10);
		try {
			Thread.sleep(3000);
			this.setPriority(pri);// Thiết lập mức độ ưu tiên
			if (pri < 5) {
				// this.setDaemon(true);
				// Thread.yield();// nhường điều khiển thực thi
				// System.out.println(ID + "-Yield");

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(this.getName() + " Pri=" + pri + "  Phan tuyen ID = " + ID);

	}

	public static void main(String[] args) {
		int n = 5 + (int) (Math.random() * 6);

		// khai báo phân tuyến
		Thread t;

		ThreadGroup tg = new ThreadGroup("random");

		for (int i = 1; i < n; i++) {
			// cấp phát bộ nhớta
			t = new MyThread1(i, tg);
			t.start();

		}

		System.out.println("Tong so phan tuyen: " + tg.activeCount());
		
		
	}
}