/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
/**
 *
 * @author olgadakischew
 */


@ManagedBean
@SessionScoped
public class ResultController {
            private Result result = null;
	  
	
            public List<Result> getSource() {
              return Library.getInstance().getSource();
            }


	public void postValidateStuff(ComponentSystemEvent ev) throws AbortProcessingException {
		System.out.println("----------------> postValidateStuff!");
		UIComponent comp = ev.getComponent();
		comp.getAttributes().put("styleClass", "ui-input-valid");
	}
	
	public Result getResult() {
		return this.result;
		//return Library.getInstance().getResult(result);
	}

	

	public String result(Result result) {
		this.result = result;
		return "article";
	}
  
  public String edit(Result result) {
		this.result = result; 
		return "edit";
	}

	public String add() {
		this.result = new Result();
	Result res = new Result();
		return "edit";
	}
	
	public String remove(Result result) {
		return "index";
	}
	
	public String saveEdit() {
		Library.getInstance().saveResult(this.result);
		//return "index";
		return "";

	}

	public String cancelEdit() {
		this.result = null;
		return "index";
	}

    
}
