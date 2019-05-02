package com.pivotenergy.domain.measurable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class MeasurableIdGenerator implements IdentifierGenerator {
    public static final String SEPARATOR = ":";

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        return generateId(object);
    }

    public static String generateId(Object object) throws HibernateException {
        if (object instanceof MeasurementRawReading) {
            MeasurementRawReading o  = (MeasurementRawReading)object;
            LocalDateTime date = LocalDateTime.of(o.getYear(), o.getMonth(), o.getDay(), o.getHour(), o.getMinute());
            return o.getMeasurable().getId() + SEPARATOR + (date.toEpochSecond(ZoneOffset.UTC));
        }
        else if (object instanceof MeasurementHourly) {
            MeasurementHourly o = (MeasurementHourly)object;
            LocalDateTime date   = LocalDateTime.of(o.getYear(), o.getMonth(), o.getDay(), o.getHour(), 0);
            return o.getMeasurable().getId() + SEPARATOR + (date.toEpochSecond(ZoneOffset.UTC));
        }
        else if (object instanceof MeasurementDaily) {
            MeasurementDaily o = (MeasurementDaily)object;
            LocalDateTime date  = LocalDateTime.of(o.getYear(), o.getMonth(), o.getDay(), 0, 0);
            return o.getMeasurable().getId() + SEPARATOR + (date.toEpochSecond(ZoneOffset.UTC));
        }
        else if (object instanceof MeasurementMonthly) {
            MeasurementMonthly o = (MeasurementMonthly)object;
            LocalDateTime date    = LocalDateTime.of(o.getYear(), o.getMonth(), 1, 0, 0);
            return o.getMeasurable().getId() + SEPARATOR + (date.toEpochSecond(ZoneOffset.UTC));
        }
        else if (object instanceof MeasurementYearly) {
            MeasurementYearly o = (MeasurementYearly)object;
            LocalDateTime date   = LocalDateTime.of(o.getYear(), 1, 1, 0, 0);
            return o.getMeasurable().getId() + SEPARATOR + (date.toEpochSecond(ZoneOffset.UTC));
        }
        else {
            return UUID.randomUUID().toString();
        }
    }
}
