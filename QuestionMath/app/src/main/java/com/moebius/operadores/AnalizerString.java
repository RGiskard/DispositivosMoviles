package com.moebius.operadores;
import  java.util.regex.Pattern;
import java.util.regex.Matcher;
public class AnalizerString {
    private String statement;
    public  AnalizerString(String statemen){
        this.statement=statemen;
    }
    public boolean TriangleArea(String stream)
    {
        return
        isContainExactWord(stream,"area")&&
        isContainExactWord(stream,"triangulo");
    }
    public boolean isContainExactWord(String fullString, String partWord){
        String pattern = "\\b"+partWord+"\\b";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(fullString);
        return m.find();
        /*boolean find=false;
        if (fullString.toLowerCase().indexOf(partWord.toLowerCase()) > -1) {

            find = true;
        }
        return find;*/
    }
    public int discriminar()
    {
        if(isContainExactWord(statement,"calcular")) {
            return 0;
        }
        if(isContainExactWord(statement,"resolver")) {
            return 1;
        }
        return -1;
    }
    public String Statement()
    {
        int value=discriminar();
        String principal;
        switch (value) {
            case 0:
                principal = statement.replaceAll("calcular", "");
                break;
            case 1:
                principal = statement.replaceAll("resolver", "");
                break;
            default:
                throw new IllegalStateException("Valor no esperado: " + value);
        }
        return principal;
    }
}
