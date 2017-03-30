package view.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("textValidator")
public class TextValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		
	    if (!value.toString().matches("[a-zA-Z\\s-]*")) {
	      FacesMessage msg =
	              new FacesMessage(" Die Eingabe ist fehlerhaft.",
	              "Bitte nutzen Sie nur Buchstaben für die Eingabe in die entsprechenden Textfelder");
	      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	    
	      throw new ValidatorException(msg);
	    }
		
	}

}
