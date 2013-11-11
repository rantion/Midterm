package com.company;

/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 11/9/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class PerformAction {
    private String prompt;

    public PerformAction(String prompt){
        this.prompt = prompt;

    }

    public String getPrompt() {
        return prompt;
    }

    public abstract void execute_Action();

}

