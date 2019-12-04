package com.moebius.operadores;
import  java.util.regex.Pattern;
import java.util.regex.Matcher;
public class AnalizerString {
    private String statement;
    private String PrintFormat="--------\n";
    private String BasicExpresion="x";
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
                principal=principal.replaceAll("\\s","");
                PrintFormat ="Aqui hay algodon";
                break;
            case 1:
                principal = statement.replaceAll("resolver", "");
                principal=principal.replaceAll("\\s","");
                int firstIdx=principal.indexOf('[');
                String expresion;
                String interval;
                String itr1,itr2;
                expresion=principal.substring(0,firstIdx);
                BasicExpresion=expresion;
                interval=principal.substring(firstIdx+1,principal.length()-1);
                itr1=interval.substring(0,interval.indexOf('-'));
                itr2=interval.substring(interval.indexOf('-')+1,interval.length());
                //principal=principal.substring(firstIdx,-1);
                PrintFormat +="f(x)="+expresion+":      ";
                PrintFormat+="Intervalo de :"+"  "+itr1+" a "+itr2;
                //PrintFormat+="\n------------";
                principal="solve( "+expresion+", x, "+itr1+", "+itr2+" )";
                break;
            default:
                throw new IllegalStateException("Valor no esperado: " + value);
        }
        return principal;
    }
    public String showInTextView()
    {
        return PrintFormat;
    }
    public String getBasicExpresion()
    {
        return this.BasicExpresion;
    }
    public  String alternative(){
        String principal;
        principal = statement.replaceAll("calcular", "");
        principal=principal.replaceAll("\\s","");
        return principal;
    }
}
