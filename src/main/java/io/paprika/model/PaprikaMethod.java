package io.paprika.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaprikaMethod extends Entity{
    private PaprikaClass paprikaClass;
    private String returnType;
    private boolean isFunction;
    private boolean isStatic;


    private Set<PaprikaVariable> usedVariables;
    private Set<Entity> calledMethods;
    private List<PaprikaArgument> arguments;
    public String getReturnType() {
        return returnType;
    }

    private PaprikaMethod(String name, String returnType, PaprikaClass paprikaClass, boolean isFunction, boolean isStatic) {
        this.setName(name);
        this.paprikaClass = paprikaClass;
        this.usedVariables = new HashSet<>(0);
        this.calledMethods = new HashSet<>(0);
        this.arguments = new ArrayList<>(0);
        this.returnType = returnType;
        this.isFunction = isFunction;
        this.isStatic = isStatic;
    }

    public static PaprikaMethod createPaprikaMethod(String name, String returnType,  PaprikaClass paprikaClass, boolean isFunction, boolean isStatic) {
        PaprikaMethod paprikaMethod = new PaprikaMethod(name,  returnType, paprikaClass, isFunction, isStatic);
        paprikaClass.addPaprikaMethod(paprikaMethod);
        return  paprikaMethod;
    }

    public PaprikaClass getPaprikaClass() {
        return paprikaClass;
    }

    public void setPaprikaClass(PaprikaClass paprikaClass) {
        this.paprikaClass = paprikaClass;
    }

    @Override
    public String toString() {
        return this.getName() + "#" + paprikaClass;
    }

    public void useVariable(PaprikaVariable paprikaVariable) {
        usedVariables.add(paprikaVariable);
    }

    public Set<PaprikaVariable> getUsedVariables(){
        return this.usedVariables;
    }

    public void callMethod(Entity paprikaMethod) { calledMethods.add(paprikaMethod);}

    public Set<Entity> getCalledMethods() { return this.calledMethods; }

    public boolean haveCommonFields(PaprikaMethod paprikaMethod){
        Set<PaprikaVariable> otherVariables = paprikaMethod.getUsedVariables();
        for(PaprikaVariable paprikaVariable : usedVariables){
            if(otherVariables.contains(paprikaVariable)) return true;
        }
        return false;
    }

    public void addArgument(PaprikaArgument paprikaArgument){
        this.arguments.add(paprikaArgument);
    }

    public List<PaprikaArgument> getArguments(){
        return arguments;
    }

    public Boolean getFunction() {
        return isFunction;
    }

    public void setFunction(Boolean function) {
        isFunction = function;
    }

    public Boolean getStatic() {
        return isStatic;
    }

    public void setStatic(Boolean aStatic) {
        isStatic = aStatic;
    }

}
