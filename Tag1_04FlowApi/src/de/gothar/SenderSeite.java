package de.gothar;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class SenderSeite {

	public static void main(String[] args) throws Exception{
		new SenderSeite().run();
	}

	private void run() throws Exception{
		
		
			
		
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//		
//		Runnable runnable  = new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					// Lange Operation
//					Thread.sleep(2000);
//					System.out.println (Thread.currentThread().getId() + "Fertig");
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		
//		for (int i = 0; i < 20; i++) {
//			service.execute(runnable);
//		}
//		
//		
//		service.shutdown();
//		
//		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
//		
//		System.out.println("##################");
//		
		
//
		List<String> liste = List.of("1", "2", "drei", "4");

		try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>(service, 1)){
			
			//publisher.subscribe(subscriber);
			
			Transformer<String, Integer> processor = new Transformer<>(i->Integer.valueOf(i));
			
			EndSubscriber<Integer> subscriber = new EndSubscriber<>();
			processor.subscribe(subscriber);
			
			publisher.subscribe(processor);
			
			
			liste.forEach(publisher::submit);
		}
		
		service.shutdown();
		
			
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
	}

}
