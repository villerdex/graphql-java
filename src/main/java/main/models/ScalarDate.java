package main.models;

import graphql.schema.*;
import main.ScalarDateCoercing;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScalarDate extends GraphQLScalarType {

    public ScalarDate(Date date) {
        super("Date", "Desc", new ScalarDateCoercing(date));
    }

    public ScalarDate() {
        super("Date", "Desc", new ScalarDateCoercing());
    }

    public void setDate(Date date) {
        ScalarDateCoercing scalarCoercing = (ScalarDateCoercing) super.getCoercing();

        scalarCoercing.setDate(date);
    }

}
