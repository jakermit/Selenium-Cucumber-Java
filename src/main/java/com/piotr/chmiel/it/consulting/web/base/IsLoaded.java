package com.piotr.chmiel.it.consulting.web.base;

public interface IsLoaded<T> {

    T waitUntilIsLoaded();
}
