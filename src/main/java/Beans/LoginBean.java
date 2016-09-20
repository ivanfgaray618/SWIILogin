package Beans;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 
import org.primefaces.context.RequestContext;
 
@ManagedBean
public class LoginBean {
     
    private String username;
    private String email; 
    private String password;
 
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }   
    
    public void pass(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(email != null && email.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Su password es", "admin");
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid email");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
    }   
}
