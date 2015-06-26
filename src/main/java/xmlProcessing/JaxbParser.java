package xmlProcessing;

import xmlProcessing.ModelXML.Pricelist;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements Parser{

    @Deprecated
    private static File JAXB_EMPLOYERS = new File("d:\\test.xml");

    @Deprecated
    public static void convertProductToXml(Pricelist entity) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance (Pricelist.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(entity, System.out);
            jaxbMarshaller.marshal(entity, JAXB_EMPLOYERS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getObject(File file, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);

        return object;
    }

    @Override
    public void saveObject(File file, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o,file);
    }
}
