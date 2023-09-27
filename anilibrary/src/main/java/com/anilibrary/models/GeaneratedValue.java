package com.anilibrary.models;

import jakarta.persistence.GenerationType;

public @interface GeaneratedValue {

    GenerationType strategy();

}
