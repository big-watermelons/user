package com.softusing.hejunjie.form;

public interface FormConvert<S, T> {
    T convert(S s);
}
