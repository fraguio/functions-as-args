package es.fraguio.faas;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import es.fraguio.faas.genesys.ApiException;
import es.fraguio.faas.genesys.GenesysCloud;

public class Service {

	private GenesysCloud genesysCloud = new GenesysCloud();

	// Segunda prueba de git reset
	
	// Opción 1
	public List<String> getMembers1(String filter, Consumer<Throwable> throwableHandler) {
		List<String> members = null;
		try {
			members = genesysCloud.getMembers(filter).parallelStream().map(m -> m.toUpperCase())
					.collect(Collectors.toList());
		} catch (ApiException e) {
			throwableHandler.accept(e);
		}
		return members;
	}
}
