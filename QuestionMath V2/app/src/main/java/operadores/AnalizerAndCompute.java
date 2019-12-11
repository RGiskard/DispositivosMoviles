package operadores;

import org.apache.commons.math3.util.*;
import org.mariuszgromada.math.mxparser.*;

public class AnalizerAndCompute {
    private Expression e;

    public  AnalizerAndCompute(String problem)
    {
        e = new Expression(problem);
    }
    public String Statement()
    {
        return  e.getExpressionString();
    }
    public  String Solution()
    {
        return "="+e.calculate();
    }
}
