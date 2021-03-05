package de.gothar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class SenderSeite {

	public static void main(final String[] args) throws Exception {
		new SenderSeite().run();
	}

	private void run() throws Exception {

		final ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		final List<Future<Integer>> futures = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			futures.add(service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					try {
						Thread.sleep((long) (Math.random() * 20000));
					} catch (final InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 42;
				}
			}));
		}
		service.shutdown();
		System.out.println("##################");
		futures.stream().mapToInt(f -> {
			try {

				return f.get();
			} catch (final Exception e) {
				return -1;
			}
		}).forEach(System.out::println);

		System.out.println("##################");
//		

////
//		final List<String> liste = List.of("1", "2", "drei", "4");
//
//		try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>()){
//			
//			//publisher.subscribe(subscriber);
//			
//			final Transformer<String, Integer> processor = new Transformer<>(i->Integer.valueOf(i));
//			
//			final EndSubscriber<Integer> subscriber = new EndSubscriber<>();
//			processor.subscribe(subscriber);
//			
//			publisher.subscribe(processor);
//			
//			
//			liste.forEach(publisher::submit);
//			
//			
//		}
//		
//		
//		
//		service.shutdown();
//		 
//			
//		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
//		
//		final Supplier<String> s = foo();
//		System.out.println(s.get());
	}

	Supplier<String> foo() {
		final Object x = new Object();

		return () -> "" + x;
	}

}
