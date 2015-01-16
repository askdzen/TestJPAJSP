package com.epam.ad.testJPA.util;

import javax.inject.Named;
import java.util.List;
import com.epam.ad.testJPA.crud.JPAService;
import com.epam.ad.testJPA.entity.UserEntity;





    public class Runner {
//        JPAService service = new JPAService();
//
//        public void testSaveRecord() throws Exception {
//            UserEntity user = new UserEntity();
//            user.setUsername("TestUser");
//            user.setPassword("TestPass");
//            service.add(user);
//            System.out.println(user);
//        }
//
//        public void updateRecord() {
//
//        }
//
//        public List<UserEntity> getAllTest() {
//            return service.getAll();
//
//
//        }
//
//
//        public static void main(String[] args) throws Exception {
//            Runner runner = new Runner();
//            runner.testSaveRecord();
//            List<UserEntity> userEntities = runner.getAllTest();
//
//
//            for (UserEntity u : userEntities) {
//                System.out.println(u);
//            }
//            System.out.println();
//        }

public Class<UserEntity> getTestClass(){
    Class<UserEntity> testClass1 = UserEntity.class;
    return testClass1;
}
        public static void main(String[] args) {
//            System.out.println("Hello");
           Runner runner=new Runner();
            System.out.println(runner.getTestClass().getName());
            System.out.println(runner.getTestClass().getCanonicalName());
            System.out.println(runner.getTestClass().getSimpleName());
            System.out.println(runner.getTestClass().getTypeName());
        }
    }

