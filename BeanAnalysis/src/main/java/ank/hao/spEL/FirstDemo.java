package ank.hao.spEL;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

public class FirstDemo {

    public static void main(String[] args) {
        SpelParserConfiguration spelParserConfiguration = new SpelParserConfiguration(SpelCompilerMode.MIXED, FirstDemo.class.getClassLoader());
        ExpressionParser parser = new SpelExpressionParser(spelParserConfiguration);
        Expression exp = parser.parseExpression("'ank.test'.concat(' concat.')");
        System.out.println((String)exp.getValue());
        exp = parser.parseExpression("22+33");
        System.out.println(exp.getValue());

//        EvaluationContext evaluationContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();
//        AA aa = new AA(1, "aa");
//        parser.parseExpression("aa").setValue(evaluationContext, aa, new AA(2, "bb"));
//        System.out.println(aa.toString());

        exp = parser.parseExpression("new ank.hao.spEL.AA(1, 'aa').toString()");
        System.out.println(exp.getValue());
    }
}