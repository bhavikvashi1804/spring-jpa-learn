package com.bhavik.demo.util;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
public class JpaSearchCriteria<T> {

    private String field;
    private DBOperation operator =  DBOperation.LIKE;
    private Type type = Type.MANDATORY;
    T value;

    public JpaSearchCriteria(String field, T value){
        this.field = field;
        this.value = value;
    }

    public enum Type{
        MANDATORY,
        OPTIONAL;
    }


    public enum DBOperation {
        EQ,
        NOT_EQ,
        LIKE,
        NOT_LIKE,
        IN,
        NOT_IN,
        STARTS_WITH,
        ENDS_WITH
    }

    public static Query getJPQLQuery(EntityManager entityManager, String entity, JpaSearchCriteria ...jpaSearchCriteriaList){

        StringBuilder stringBuilder =  new StringBuilder();
        stringBuilder.append("select e from  ").append(entity).append(" e ");
        stringBuilder.append(" WHERE 1=1");

        for(JpaSearchCriteria jpaSearchCriteria : jpaSearchCriteriaList){

            JpaSearchCriteria.DBOperation cOperator = jpaSearchCriteria.getOperator();
            JpaSearchCriteria.Type type = jpaSearchCriteria.getType();
            String currentField = jpaSearchCriteria.getField();;
            Object currentValue =  jpaSearchCriteria.getValue();

            switch (type){
                case MANDATORY:
                    stringBuilder.append(" AND ");
                    break;
                case OPTIONAL:
                    stringBuilder.append(" OR ");
                    break;
            }

            switch (cOperator){
                case EQ:
                    stringBuilder.append(" e." + currentField + " = :" + currentField);
                    break;
                case NOT_EQ:
                    stringBuilder.append(" e." +currentField+ " <> :" + currentField);
                    break;
                case NOT_LIKE:
                    stringBuilder.append(" e."+currentField + " not like :" + currentField );
                    break;
                case LIKE, STARTS_WITH, ENDS_WITH:
                    stringBuilder.append(" e." +currentField + " like :" + currentField);
                    break;
                case IN:
                    if(currentValue instanceof Collection){
                        stringBuilder.append(" e." + currentField + " in :" + currentField);
                    }
                    break;
                case NOT_IN:
                    if(currentValue instanceof Collection){
                        stringBuilder.append(" e." + currentField + " not in :" + currentField);
                    }
                    break;
            }
        }

        Query query = entityManager.createQuery(stringBuilder.toString());
        for(JpaSearchCriteria jpaSearchCriteria : jpaSearchCriteriaList){
            JpaSearchCriteria.DBOperation operator = jpaSearchCriteria.getOperator();
            String currentField = jpaSearchCriteria.getField();
            switch (operator){
                case LIKE, NOT_LIKE:
                    query.setParameter(currentField, "%" + jpaSearchCriteria.getValue() + "%" );
                    break;
                case STARTS_WITH:
                    query.setParameter(currentField,  jpaSearchCriteria.getValue() + "%");
                    break;
                case ENDS_WITH:
                    query.setParameter(currentField, "%" + jpaSearchCriteria.getValue() );
                    break;
                default:
                    query.setParameter(currentField,  jpaSearchCriteria.getValue());

            }
        }

        return  query;
    }
}
