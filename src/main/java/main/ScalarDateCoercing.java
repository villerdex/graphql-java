package main;

import graphql.language.StringValue;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import main.models.ScalarDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScalarDateCoercing implements graphql.schema.Coercing {

    private Date date;

    public ScalarDateCoercing(Date date) {
        this.date = date;
    }

    public ScalarDateCoercing() { }

    @Override
    public Object serialize(Object o) throws CoercingSerializeException {
        ScalarDateCoercing c = (ScalarDateCoercing) ((GraphQLScalarType) o).getCoercing();
        return  c.getDate() == null ? "date is null" :  c.getDate().toString();
    }

    @Override
    public Object parseValue(Object o) throws CoercingParseValueException {
        return null;
    }

    @Override
    public Object parseLiteral(Object o) throws CoercingParseLiteralException {
        try {
            Date date1 = new SimpleDateFormat("mm-dd-yyyy").parse(((StringValue) o).getValue());
            return new ScalarDate( date1 );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Xxxx";
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
