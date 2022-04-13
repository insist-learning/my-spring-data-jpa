package com.example.myspringdatajpa.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.util.Streamable;

import java.util.Iterator;

@Data
@JsonIgnoreProperties("empty")
public class R<T> implements Streamable<T> {
    private Integer code;
    private String msg;
    private Object data;



    @JsonIgnore
    private final Streamable<T> streamable;

    public R(Streamable<T> streamable) {
        this.streamable = streamable;
        this.data = streamable.toList();
    }


    @Override
    public Iterator<T> iterator() {
        return streamable.iterator();
    }
}
