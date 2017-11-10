package com.ibracero.postapp.domain.model.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<T1, T2> {

    public T2 map(T1 model)
    {
        if(model==null)
            return null;
        else
            return transform(model);
    }



    public List<T2> map(List<T1> modelList)
    {
        if(modelList==null)
            return null;
        else
        {
            List<T2> t2List=new ArrayList<>();
            for (T1 t1 : modelList) {
                t2List.add(map(t1));

            }

            return t2List;
        }
    }

    public T1 unmap(T2 model)
    {
        if(model==null)
            return null;
        else
            return untransform(model);
    }



    public List<T1> unmap(List<T2> modelList)
    {
        if(modelList==null)
            return null;
        else
        {
            List<T1> t1List =new ArrayList<>();
            for (T2 t2 : modelList) {
                t1List.add(unmap(t2));

            }

            return t1List;
        }
    }

    protected abstract T2 transform(T1 model);
    protected abstract T1 untransform(T2 model);


}