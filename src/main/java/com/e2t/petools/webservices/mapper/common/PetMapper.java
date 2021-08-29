package com.e2t.petools.webservices.mapper.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class PetMapper {

    private PetMapper() {
    }

    /**
     * Convert an object to the indicated Type. Only attributes with the same "Name" & "Type" will be mapped
     *
     * @param inputObject the object that will be converted
     * @param outputType  the type object will be converted on
     * @return outputType = (outputType)inputObject
     */
    public static Object parseObjectToType(Object inputObject, Class outputType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Object result = outputType.getConstructor().newInstance();

        Field[] inputAttributeList = inputObject.getClass().getDeclaredFields();
        Field[] outputAttributeList = outputType.getDeclaredFields();

        for (Field inputField : inputAttributeList) {
            for (Field outputField : outputAttributeList) {
                if (inputField.getName().equals(outputField.getName()) && inputField.getType() == outputField.getType()) {

                    String getMethodName;
                    String setMethodName;

                    if (inputField.getType() == Boolean.class || inputField.getType() == boolean.class){
                        getMethodName = inputField.getName();
                        setMethodName = "set" + outputField.getName().substring(2);
                    } else {
                        getMethodName = "get" + inputField.getName().substring(0, 1).toUpperCase() + inputField.getName().substring(1);
                        setMethodName = "set" + outputField.getName().substring(0, 1).toUpperCase() + outputField.getName().substring(1);
                    }
                    Method getMethod = inputObject.getClass().getMethod(getMethodName, null);
                    Method setMethod = outputType.getMethod(setMethodName, inputField.getType());
                    setMethod.invoke(result, getMethod.invoke(inputObject, null));
                }
            }
        }
        return result;
    }
}
