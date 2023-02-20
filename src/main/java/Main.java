import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> courseCriteriaQuery = builder.createQuery(Course.class);
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);
        CriteriaQuery<Student> studentCriteriaQuery = builder.createQuery(Student.class);
        Root<Student> studentRoot = studentCriteriaQuery.from(Student.class);


        Transaction transaction = session.beginTransaction();

        List<PurchaseList> keys = session.createQuery("from PurchaseList", PurchaseList.class).getResultList();
        for(PurchaseList key : keys){
            courseCriteriaQuery.select(courseRoot).where(builder.like(courseRoot.get("name"), key.getKey().getCourseName()));
            Course course = session.createQuery(courseCriteriaQuery).getSingleResult();
            studentCriteriaQuery.select(studentRoot).where(builder.like(studentRoot.get("name"), key.getKey().getStudentName()));
            Student student = session.createQuery(studentCriteriaQuery).getSingleResult();
            IdKey key1 = new IdKey();
            key1.setCourseID(course.getId());
            key1.setStudentId(student.getId());
            LinkedPurchaseList purchaseList = new LinkedPurchaseList();
            purchaseList.setKey(key1);
            session.save(purchaseList);
        }

        transaction.commit();
        sessionFactory.close();
    }
}
