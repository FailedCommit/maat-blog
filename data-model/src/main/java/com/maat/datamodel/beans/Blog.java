package com.maat.datamodel.beans;

import com.maat.datamodel.beans.enums.Rating;
import org.springframework.data.mongodb.core.mapping.Document;

public class Blog extends Post {
    private Rating rating;
}
