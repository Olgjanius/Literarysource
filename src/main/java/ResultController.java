/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * @author olgadakischew
 */
@Named
@SessionScoped
public class ResultController implements Serializable
{
    private Result result = null;

    @Inject
    private Library library;

    public List<Result> getSource()
    {
        return library.getSource();
    }

    public void postValidateStuff(ComponentSystemEvent ev) throws AbortProcessingException
    {
        System.out.println("----------------> postValidateStuff!");
        UIComponent comp = ev.getComponent();
        comp.getAttributes().put("styleClass", "ui-input-valid");
    }

    public Library getLibrary()
    {
        return library;
    }

    public void setLibrary(Library library)
    {
        this.library = library;
    }

    public Result getResult()
    {
        if(result == null) System.err.println("aaargh, result is null");
        return result;
    }

    public String setResult(Result result)
    {
        this.result = result;
        return "article";
    }

    public String edit(Result result)
    {
        this.result = result;
        return "edit";
    }

    public String add()
    {
        result = new Result();
        return "edit";
    }

    public String remove(Result result)
    {
        return "index";
    }

    public String saveEdit()
    {
        library.saveResult(this.result);
        return "";
    }

    public String cancelEdit()
    {
        this.result = null;
        return "index";
    }
}
