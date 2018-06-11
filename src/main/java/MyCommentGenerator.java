import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Properties;

public class MyCommentGenerator implements CommentGenerator{
    public void addConfigurationProperties(Properties properties) {

    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            field.addJavaDocLine(" */");
        }
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {

    }

    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }

    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks()!= null && !introspectedColumn.getRemarks().equals("")){
            method.addJavaDocLine("/**");
            method.addJavaDocLine("*@return "+introspectedColumn.getRemarks());
            method.addJavaDocLine("*/");
        }
    }

    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks()!= null && !introspectedColumn.getRemarks().equals("")){
            method.addJavaDocLine("/**");
            method.addJavaDocLine("*@param "+method.getParameters().get(0).getName()+" "+introspectedColumn.getRemarks());
            method.addJavaDocLine("*/");
        }
    }

    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    public void addJavaFileComment(CompilationUnit compilationUnit) {

    }

    public void addComment(XmlElement xmlElement) {

    }

    public void addRootComment(XmlElement xmlElement) {

    }
}
