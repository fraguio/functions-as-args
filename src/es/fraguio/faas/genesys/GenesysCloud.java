package es.fraguio.faas.genesys;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import es.fraguio.faas.exception.MajorNumericException;
import es.fraguio.faas.exception.NumericException;

public class GenesysCloud {

	private static List<String> MEMBERS = null;
	private static Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

	public GenesysCloud() {
		GenesysCloud.MEMBERS = new ArrayList<>();
		GenesysCloud.MEMBERS.add("Pepe");
		GenesysCloud.MEMBERS.add("Manolo");
		GenesysCloud.MEMBERS.add("Javier");
		GenesysCloud.MEMBERS.add("Santiago");
		GenesysCloud.MEMBERS.add("Adrian");
		GenesysCloud.MEMBERS.add("Antonio");
	}

	private boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		return GenesysCloud.PATTERN.matcher(strNum).matches();
	}

	public List<String> getMembers(String filter) throws ApiException {

		if (isNumeric(filter)) {
			if (Double.valueOf(filter) > 10) {
				throw new ApiException(100, "Default: es un valor numérico > 10");
			} else {
				throw new ApiException(200, "Default: es un valor numérico");
			}
		}
		return GenesysCloud.MEMBERS.parallelStream().filter(m -> m.contains(filter)).collect(Collectors.toList());

	}
}
