package webajax;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	public static String objetoParaJson(Object lista) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(lista);
		return json;
	}

}
