package daoroot.xml;

import daoroot.DAO;
import daoroot.DAOFactory;
import exceptions.DaoException;
import org.junit.jupiter.api.BeforeEach;
import root.Sede;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.util.Optional;

class XMLSedeDAOTest {

    private DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
    private DAO<Sede> sedeDAO = (XMLSedeDAO) xmlDAOFactory.getSedeDAO();

    private Sede createSede() {
        Sede sede = new Sede(2, "Barcelona", "Calle", "Pujades", 29, "Barcelona", 8905, "España", "", "+34666999888", "barcelona@entreculturas.org", true);
        return sede;
    }

    @Test
    public void XmlGetsCreated() throws DaoException {
        File file = new File("output/sede/sede_1.xml");
        Sede nuevaSede = createSede();
        sedeDAO.crearNuevoArchivo(nuevaSede);
        assertTrue(file.exists());
    }

    /*
    @Test
    public void XmlObtainTest() {
        Sede sede = createSede();
        XMLSedeDAO xmlSedeDao = new XMLSedeDAO();
        Optional<Sede> ret = xmlSedeDao.obtenerDatos("1", Sede.class);
        assertTrue(ret.isPresent());
    }
    */
}