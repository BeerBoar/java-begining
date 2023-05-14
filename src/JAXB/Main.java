package JAXB;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PACKAGE = DataObject.class.getPackage().getName();
    public static void main(String[] args) {
        //создание тестового объекта
        List<IndexObj> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new IndexObj(i));
        }
        DataObject dataObj = new DataObject(0, "first", list);

        try {
            JAXBContext context = JAXBContext.newInstance(PACKAGE);
            Marshaller m = context.createMarshaller();
            Unmarshaller um = context.createUnmarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); //форматированный вывод XML в док
            m.marshal(dataObj, new File("C:\\Users\\Veniol\\Desktop\\JAXB_TEST.xml"));
            DataObject testObj = (DataObject) um.unmarshal(new File("C:\\Users\\Veniol\\Desktop\\JAXB_TEST.xml"));
            System.out.println("JAXB:" + dataObj.equals(testObj));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("C:\\Users\\Veniol\\Desktop\\JACKSON_TEST.json"),dataObj);
            DataObject test = mapper.readValue(new File("C:\\Users\\Veniol\\Desktop\\JACKSON_TEST.json"), DataObject.class);
            System.out.println("Jackson:" + dataObj.equals(test));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
