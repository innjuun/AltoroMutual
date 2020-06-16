import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public final class RequestWrapper extends HttpServletRequest {

    public RequestWrapper(HttpServletRequest servletRequest){
        super(servletRequest);
    }

    public String[] getParameterValues(String parameter){
        String[] values = super.getParameterValues(parameter);
        if (values=null){
            return null
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i=0; i < count; i++){
            encodedValues[i] = cleanXSS(values[i]);
        }
        return encodedValues;
    }

    public String getParameter(String parameter){
        String value = super.getParameter(parameter);
        if (value == null) {
            return null;
        }
        return cleanInput(value);
    }

    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null){
            return null;
        }
        return cleanInput(value);
    }

    private String cleanInput(String value){
        value = value.replaceAll("/", "");
        value = value.replaceAll("\\", "");
        value = value.replaceAll(".", " ");
        value = value.replaceAll("&", " ");
        return value;
    }
    }
}