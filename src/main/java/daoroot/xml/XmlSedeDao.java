package daoroot.xml;

import daoroot.XmlDaoFactory;
import root.Proyecto;
import root.Sede;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

public class XmlSedeDao extends XmlDaoFactory<Sede> {

    @Override
    public void crearNuevo(Sede sede) {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Proyecto.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerObj.marshal(sede, new FileOutputStream("output/sede.xml"));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Sede> obtener(String id) {
        return Optional.empty();
    }

    @Override
    public void actualizar(Sede sede, String[] params) {

    }

    @Override
    public void borrar(Sede sede) {

    }

    @Override
    public List<Sede> obtenerDatos() {
        return null;
    }
}