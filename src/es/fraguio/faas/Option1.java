package es.fraguio.faas;

import java.util.function.Consumer;

import es.fraguio.faas.exception.MajorNumericException;
import es.fraguio.faas.exception.NumericException;

public class Option1 {

	private static Consumer<Throwable> DEFAULT_THROWABLE_HANDLER = (t -> {
		System.out.println(t);
	});

	private static Consumer<Throwable> THROWABLE_HANDLER = (t -> {
		if (MajorNumericException.class.equals(t)) {
			throw new IllegalArgumentException(t.getMessage().replaceFirst("Default: ", "Custom: "));
		} else {
			throw new IllegalArgumentException(t.getMessage().replaceFirst("Default: ", "Custom: "));
		}
	});

	public static void main(String[] args) throws NumericException {

		Service service = new Service();
		System.out.println(service.getMembers1("1", Option1.THROWABLE_HANDLER));
	}
}

class SuperiorConsumer implements Consumer<Throwable> {

	@Override
	public void accept(Throwable t) {
		// TODO Auto-generated method stub

	}
}
