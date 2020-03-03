/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.activage.leeds.producer.model.ngsi.common.Attribute;
import eu.activage.leeds.producer.model.ngsi.common.Timestamp;
import eu.activage.leeds.producer.model.ngsi.entity.HomeMonitoringActivity;
import eu.activage.leeds.producer.model.ngsi.message.BatchUpdateOperation;
import eu.activage.leeds.producer.model.ngsi.metadata.ActivityMetadata;
import eu.activage.leeds.producer.model.ngsi.metadata.activity.Field;
import eu.activage.leeds.producer.model.ngsi.metadata.activity.Threshold;
import eu.activage.leeds.producer.model.proxy.ActivityData;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te0003
 */
class ADLNgsiFormatter extends NgsiFormatter{

//    public String getActivityNgsiFormat(List<ActivityData> adList) {
//        
//        List<HomeMonitoringActivity> hmaList = new ArrayList<>();
//
//        for (ActivityData ad : adList) {
//
//            ActivityMetadata metadata = new ActivityMetadata();            
//            metadata.setUserid(new Field("String", ad.getUserId()));
//            metadata.setTimestamp(new Timestamp("UnixTimeStamp", ad.getTimestamp()));
//            metadata.setMeasurementUnit(new Field("String", "Hours"));
//            metadata.setGreenLower(new Threshold("Real", ad.getGreenLower()));
//            metadata.setGreenUpper(new Threshold("Real", ad.getGreenUpper()));
//            metadata.setYellowLower(new Threshold("Real", ad.getYellowLower()));
//            metadata.setYellowUpper(new Threshold("Real", ad.getYellowUpper()));
//            metadata.setRedLower(new Threshold("Real", ad.getRedLower()));
//            metadata.setRedUpper(new Threshold("Real", ad.getRedUpper()));
//            Attribute attr = new Attribute();
//            attr.setMetadata(metadata);
//
//            HomeMonitoringActivity hma = new HomeMonitoringActivity();
//            hma.setId("service:lee:ld:"+ad.getUserId()); // format needs to be agreed
//            hma.setType(ad.getType());
//            hma.setDailyResult(attr);
//            
//            hmaList.add(hma);
//
//        }
//        
//        BatchUpdateOperation buo = new BatchUpdateOperation();
//
//        for (HomeMonitoringActivity hma : hmaList) {
//            buo.getEntities().add(hma);
//        }        
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        String result = "";
//        try {
//            result = mapper.writeValueAsString(buo);
////            System.out.println(result);
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(ADLNgsiFormatter.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return result;
//        
//        
//
//    }

   

}
