package br.com.cursojava.projetofinal.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class CargoTest {

    @Test
    public void testCargoFindAll() {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("projeto-final");
            em = emf.createEntityManager();

            String sql = "SELECT c FROM Cargo c";

            Query query = em.createQuery(sql);
            List<Cargo> cargoList = query.getResultList();

            for (Cargo cargo : cargoList) {
                System.out.print(cargo.getId());
                System.out.print(" - ");
                System.out.println(cargo.getNome());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
    }

    @Test
    public void testCargoFindByPK() {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            emf = Persistence.createEntityManagerFactory("projeto-final");
            em = emf.createEntityManager();

//            String sql = "SELECT c FROM Cargo c";

//            Query query = em.createQuery(sql);
//            List<Cargo> cargoList = query.getResultList();

//            for (Cargo cargo : cargoList) {
//                System.out.print(cargo.getId());
//                System.out.print(" - ");
//                System.out.println(cargo.getNome());
//            }

            Cargo cargo = em.find(Cargo.class, 3);
            System.out.println(cargo.getNome());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
    }
}
