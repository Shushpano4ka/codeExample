package com.vadymusyk.code_example.converter.measurements;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

/**
 * Created by vadymusyk on 16.08.17.
 */
public class LocationConverter {

    public static Point toPoint(double lat, double lng) {
        return new GeometryFactory().createPoint(new Coordinate(lat, lng));
    }
}
