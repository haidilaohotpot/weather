package cn.edu.mju.city.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * xml构建工具类
 * @author cheng
 * @version 1.0
 * @since 1.0
 */
public class XmlBuilder {

    /**
     * 将xml转换为对象
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr)throws Exception{

        Object xmlObject =  null;

        Reader reader = null;

        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);

        xmlObject = unmarshaller.unmarshal(reader);
        if (null != reader) {

            reader.close();

        }

        return xmlObject;
    }


}
