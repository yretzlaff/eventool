package view.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import model.User;
import service.UserService;



//@ManagedBean
@Named
@ApplicationScoped
public class UserConverter implements Converter {


	//@ManagedProperty("#{userService}")
	@Inject
	private UserService userService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if(null == value || value.isEmpty()){
			return null;
		}
		return userService.getUserByName(value).orElse(null);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return null;
		}
		return User.class.cast(value).getName();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
