package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import enums.PorteEnum;

public class PorteEnumConverter implements Converter{

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			return (value != "" && value != null) ? PorteEnum.from(value) : null;
		}
		@Override
		public String getAsString(FacesContext context, UIComponent componet, Object value) {
			if( value instanceof String) {
				return "";
			}
			if(!(value instanceof PorteEnum)) {
				return null;
			}
			return ((PorteEnum) value).name();
		}
		
}
