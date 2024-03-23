package com.bhavik.demo.util;


import lombok.*;

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

    public static String getJPQLQuery(JpaSearchCriteria ...jpaSearchCriteriaList){
        StringBuilder stringBuilder =  new StringBuilder();

        stringBuilder.append(" WHERE 1=1");

        for(JpaSearchCriteria jpaSearchCriteria : jpaSearchCriteriaList){

            JpaSearchCriteria.DBOperation operator = jpaSearchCriteria.getOperator();
            JpaSearchCriteria.Type type = jpaSearchCriteria.getType();

            switch (type){
                case MANDATORY:
                    stringBuilder.append(" AND ");
                    break;
                case OPTIONAL:
                    stringBuilder.append(" OR ");
                    break;
            }

            switch (operator){
                case EQ:
                    stringBuilder.append("e." + jpaSearchCriteria.getField() + " = " + jpaSearchCriteria.getValue());
                    break;
                case NOT_EQ:
                    stringBuilder.append("e." +jpaSearchCriteria.getField() + " <> " + jpaSearchCriteria.getValue());
                case LIKE:
                    stringBuilder.append("e." +jpaSearchCriteria.getField() + " like '%" + jpaSearchCriteria.getValue() + "%'");
                    break;
                case NOT_LIKE:
                    stringBuilder.append("e."+jpaSearchCriteria.getField() + " not like '%" + jpaSearchCriteria.getValue() + "%'");
                    break;
                case STARTS_WITH:
                    stringBuilder.append("e." + jpaSearchCriteria.getField() + " like '" + jpaSearchCriteria.getValue() + "'%");
                    break;
                case ENDS_WITH:
                    stringBuilder.append("e." + jpaSearchCriteria.getField() + " like '%" + jpaSearchCriteria.getValue() + "'");
                    break;

            }
        }

        return stringBuilder.toString();
    }
}
