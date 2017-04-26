package cn.edu.cuit.liyun.laboratory.utils;

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVRelation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.entity.UserInfo;

/**
 * Created by jianglei on 2017/4/25.
 */

public class LeanEngine {
    private static final String TAG = "LeanEngine";

    public static <T> AVObject toAVObject(T t) {
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        AVObject avObject = new AVObject(clazz.getSimpleName());
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object fieldObject = field.get(t);
                if (fieldObject instanceof Collection) {
                    AVRelation relation = avObject.getRelation(field.getName());
                    for (Object o : ((Collection) fieldObject)) {
                        relation.add(toAVObject(o));
                    }
                } else if (putAsBuiltIn(field, t, avObject)) {
                    continue;
                } else if (field.getType().isEnum()) {
                    putEnum(field, t, avObject);
                } else {
                    avObject.put(field.getName(), fieldObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avObject;
    }

    private static <T> boolean putAsBuiltIn(Field field, T t, AVObject avObject) {
        try {
            if (field.getName().equals("obejctId")) {
                avObject.setObjectId((String) field.get(t));
                return true;
            }
            if (field.getName().equals("createdAt")) {
                return true;
            }
            if (field.getName().equals("updatedAt")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static <T> T toObject(AVObject avObject, Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            handleBuildInField(clazz, t, avObject);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (List.class.isAssignableFrom(field.getType())) {
                        Log.d(TAG, "toObject: " + field.getName());
                        Type genericType = field.getGenericType();
                        List<AVObject> results = avObject.getRelation(field.getName()).getQuery().find();
                        List list = new ArrayList();
                        if (genericType instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType) genericType;
                            Class genericClass = (Class) parameterizedType.getActualTypeArguments()[0];
                            for (AVObject result : results) {
                                list.add(toObject(result, genericClass));
                            }
                        }
                        field.set(t, list);
                    } else if (field.getType().isEnum()) {
                        handleEnum(field, t, avObject);
                    } else if (!handleAsPrimiteType(field, t, avObject)) {
                        AVObject fieldAVObject = avObject.getAVObject(field.getName());
                        fieldAVObject.fetchIfNeeded();
                        field.set(t, toObject(fieldAVObject, field.getType()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class Query<T> {
        private AVQuery<AVObject> avQuery;
        private Class<T> clazz;

        public static <T> Query<T> get(Class<T> clazz) {
            Query<T> query = new Query<>();
            query.avQuery = AVQuery.getQuery(clazz.getSimpleName());
            query.clazz = clazz;
            return query;
        }

        public Query<T> whereEqualTo(String key, Object value) {
            avQuery.whereEqualTo(key, value);
            return this;
        }

        public static <T> Query<T> and(Query<T>... querys) {
            Query<T> query = new Query<>();
            List<AVQuery<AVObject>> avQueries = new ArrayList<>(querys.length);
            for (Query<T> childQuery : querys) {
                avQueries.add(childQuery.avQuery);
            }
            query.avQuery = AVQuery.and(avQueries);
            return query;
        }

        public List<T> find() {
            try {
                List<AVObject> objects = avQuery.find();
                if (objects != null) {
                    List<T> results = new ArrayList<>();
                    for (AVObject avObject : objects) {
                        results.add(toObject(avObject, clazz));
                    }
                    return results;
                }
            } catch (AVException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    }

    public static UserInfo getUserInfo(User user) {
        try {
            AVObject object = user.getInfo();
            object.fetchIfNeeded();
            return toObject(object, UserInfo.class);
        } catch (AVException e) {
            e.printStackTrace();
        }
        return new UserInfo();
    }

    public static <T> void save(T t) {
        try {
            toAVObject(t).save();
        } catch (AVException e) {
            e.printStackTrace();
        }
    }

    private static void putEnum(Field field, Object object, AVObject avObject) {
        try {
            avObject.put(field.getName(), ((Enum) field.get(object)).ordinal());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleEnum(Field field, Object object, AVObject avObject) {
        try {
            Method method = Enum.class.getDeclaredMethod("getSharedConstants", Class.class);
            method.setAccessible(true);
            Object[] objects = (Object[]) method.invoke(null, field.getType());
            field.set(object, objects[avObject.getInt(field.getName())]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> boolean delete(T t) {
        try {
            toAVObject(t).delete();
            return true;
        } catch (AVException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static <T> boolean remove(List<T> list, T t) {
        for (T t1 : list) {
            if (t1.equals(t)){
                list.remove(t1);
                return true;
            }
            try {
                Method method=t.getClass().getMethod("getObjectId");
                if (method!=null){
                    String objectId= (String) method.invoke(t);
                    String objectId1= (String) method.invoke(t1);
                    if (objectId.equals(objectId1)){
                        list.remove(t1);
                        return true;
                    }else {
                        return false;
                    }
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    private static void handleBuildInField(Class clazz, Object object, AVObject avObject) {
        try {
            Field idField = clazz.getDeclaredField("objectId");
            if (idField != null) {
                idField.setAccessible(true);
                idField.set(object, avObject.getObjectId());
            }
            Field createAtField = clazz.getDeclaredField("createdAt");
            if (createAtField != null) {
                createAtField.setAccessible(true);
                createAtField.set(object, avObject.getCreatedAt());
            }
            Field updatedAtField = clazz.getDeclaredField("updatedAt");
            if (updatedAtField != null) {
                updatedAtField.setAccessible(true);
                updatedAtField.set(object, avObject.getUpdatedAt());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean handleAsPrimiteType(Field field, Object object, AVObject avObject) {
        String type = field.getType().getName();
        try {
            if (type.equals(String.class.getName())) {
                field.set(object, avObject.getString(field.getName()));
                return true;
            }
            if (type.equals("int") || type.equals(Integer.class.getName())) {
                field.set(object, avObject.getInt(field.getName()));
                return true;
            }
            if (type.equals("float") || type.equals(Float.class.getName())) {
                field.set(object, avObject.getDouble(field.getName()));
                return true;
            }
            if (type.equals("double") || type.equals(Double.class.getName())) {
                field.set(object, avObject.getDouble(field.getName()));
                return true;
            }
            if (type.equals("long") || type.equals(Long.class.getName())) {
                field.set(object, avObject.getLong(field.getName()));
                return true;
            }
            if (type.equals("boolean") || type.equals(Boolean.class.getName())) {
                field.set(object, avObject.getBoolean(field.getName()));
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
