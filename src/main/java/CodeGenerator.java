import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName CodeGenerator
 * @Description: mybatis-plus代码生成器
 * @Author chenGJ
 * @Date 2019/12/3 12:42
 * @Version V1.0
**/
public class CodeGenerator {

    private static String databaseName = "tb";//数据库名字
    private static String parentPackageName = "com.chen";//父包名
    private static String authorName = "chenGJ";//作者名字
    private static String databaseUsername = "root";//数据库用户名
    private static String databasePassword = "123456";//数据库密码
    private static AutoGenerator mpg = new AutoGenerator();//代码生成器类
    private static PackageConfig pc = new PackageConfig();//包配置类
    public static String projectPath;//项目路径
    private static String templatePath;//freemarker mapper.xml

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 数据源配置
     */
    public static void setDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/"+databaseName+"?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(databaseUsername);
        dsc.setPassword(databasePassword);
        mpg.setDataSource(dsc);
    }

    /**
     * 全局配置
     */
    public static void setGlobalConfig(){
        GlobalConfig gc = new GlobalConfig();
        projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(authorName);
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);
    }

    /**
     * 包配置
     * @param moduleName
     */
    public static void setPackageConfig(String moduleName){
        pc.setModuleName(moduleName);
        pc.setParent(parentPackageName);
        mpg.setPackageInfo(pc);
    }

    /**
     * 自定义配置
     */
    public static void setCustomConfig(){
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }

    /**
     * 配置模板
     */
    public static void setTemplateConfig(){
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
    }

    /**
     * 策略配置
     */
    public static void setStrategyConfig(){
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityTableFieldAnnotationEnable(true);
        //strategy.setSuperEntityClass("com.chen.mybatisplus.common.BaseEntity");
        //strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("com.chen.mybatisplus.common.BaseController");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        //strategy.setInclude(scanner("表名").split(","));
        strategy.setInclude(scanner("表名，多个表以英文逗号分隔").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
    }

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {

        //设置freemarker模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        //设置数据源
        CodeGenerator.setDataSourceConfig();

        //设置全局配置
        CodeGenerator.setGlobalConfig();

        //包配置
        CodeGenerator.setPackageConfig(scanner("模块名"));

        //自定义配置
        CodeGenerator.setCustomConfig();

        //配置模板
        CodeGenerator.setTemplateConfig();

        //策略配置
        CodeGenerator.setStrategyConfig();
        mpg.execute();
    }

}
