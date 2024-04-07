package fileTemplates.internal;#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
/**
@Classname ${NAME}
@Describe  ${describe}
@Author    Chenchunlong
@Version   1.0.0
@Time      ${YEAR}-${MONTH}-${DAY} ${HOUR}:${MINUTE}
*/

public class ${NAME} {
}