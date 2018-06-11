import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.List;
import java.util.Properties;

public class MyToStringGenerator extends PluginAdapter {

    private boolean useToStringFromRoot;

    public MyToStringGenerator() {
    }

    public void setProperties(Properties properties) {
        super.setProperties(properties);
        this.useToStringFromRoot = StringUtility.isTrue(properties.getProperty("useToStringFromRoot"));
    }

    public boolean validate(List<String> warnings) {
        return true;
    }

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateToString(introspectedTable, topLevelClass);
        return true;
    }

    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateToString(introspectedTable, topLevelClass);
        return true;
    }

    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateToString(introspectedTable, topLevelClass);
        return true;
    }

    private void generateToString(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.setName("toString");
        if (introspectedTable.isJava5Targeted()) {
            method.addAnnotation("@Override");
        }
        this.context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        method.addBodyLine("return this.getClass().getSimpleName();");
        topLevelClass.addMethod(method);
    }

}
