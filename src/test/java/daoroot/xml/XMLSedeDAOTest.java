package daoroot.xml;

import daoroot.DAO;
import daoroot.DAOFactory;
import exceptions.DaoException;
import org.junit.jupiter.api.*;
import root.Sede;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.util.Optional;

class XMLSedeDAOTest {


    private DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
    private DAO<Sede> sedeDAO = (XMLSedeDAO) xmlDAOFactory.getSedeDAO();

    private static Sede sede;

    @BeforeAll
    public static void nuevaSede(){
        sede = new Sede(1, "Barcelona", "Calle", "Pujades", 29, "Barcelona", 8905, "España", "", "+34666999888", "barcelona@entreculturas.org", true);
    }

    @BeforeEach
    public void crearArchivo() throws DaoException {
        sedeDAO.crearNuevoArchivo(sede);
    }

    @AfterEach
    public void deleteXML() throws DaoException {
        sedeDAO.borrarArchivo("1");
    }

    @Test
    public void XmlGetsCreated() throws DaoException {
        File file = new File("output/sede/sede_1.xml");
        assertTrue(file.exists());
    }

    @Test
    public void XmlObtainTest() throws DaoException {
        sedeDAO.crearNuevoArchivo(sede);
        Optional<Sede> ret = sedeDAO.obtenerDatos("1", Sede.class);
        assertTrue(ret.isPresent());
    }

    @Test
    public void XMLGetsDeleted() throws DaoException {
        sedeDAO.borrarArchivo("1");
        assertFalse(sedeDAO.obtenerDatos("1", Sede.class).isPresent());
    }

}