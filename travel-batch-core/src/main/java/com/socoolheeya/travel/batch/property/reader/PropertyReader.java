//package com.socoolheeya.travel.batch.property.reader;
//
//import com.socoolheeya.travel.domain.rds.main.property.entity.PropertyEntity;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.NonTransientResourceException;
//import org.springframework.batch.item.ParseException;
//import org.springframework.batch.item.UnexpectedInputException;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class PropertyReader implements ItemReader<PropertyEntity> {
//
//    private List<PropertyEntity> propertyEntities;
//
//
//    @Override
//    public PropertyEntity read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        return null;
//    }
//
//    private boolean propertyDataIsNotInitialized() {
//        return this.propertyEntities == null;
//    }
//
////    private List<PropertyEntity> fetchPropertyData() {
////        jakarta.persistence.TypedQuery<PropertyEntity> query = em.createQuery("SELECT p FROM PropertyEntity p", PropertyEntity.class);
////        return propertyQueryService.searchPropertiesByIsEnabled(true);
////    }
//}
