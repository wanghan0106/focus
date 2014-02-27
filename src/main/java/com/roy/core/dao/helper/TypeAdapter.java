package com.roy.core.dao.helper;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.roy.core.dao.cond.Cond;
import com.roy.core.dao.cond.logic.LogicCond;
import com.roy.core.dao.cond.logic.NotCond;
import com.roy.core.dao.cond.property.PropertyCond;

public class TypeAdapter {
	private static final Logger log = LoggerFactory.getLogger(TypeAdapter.class);
	private TypeAdapter() {}
	
	/**
	 * @function 对于参数值类型为String的查询条件，需要将参数值转换为对应属性的类型
	 * @param
	 *
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@SuppressWarnings("rawtypes")
	public final static void adapt(final Class entityClass,Cond cond) {
		if(cond instanceof NotCond) {
			NotCond cnd = (NotCond) cond;
			if(cnd.getCond()!=null) {
				adapt(entityClass,cnd.getCond());
			}
		} else if(cond instanceof PropertyCond) {
			PropertyCond cnd = (PropertyCond) cond;
			if(cnd.getValue()!=null && cnd.getValue() instanceof String) {
				Class fieldClass = getFieldClass(entityClass,cnd.getProperty());
				if(fieldClass!=null) {
					if(!fieldClass.equals(String.class) && "".equals((String) cnd.getValue())){
						cnd.setValue(null);
					}
					if(cnd.getValue()!=null) {
						if(fieldClass.equals(Long.class) || fieldClass.equals(long.class)) {
                            try {
							    cnd.setValue(Long.parseLong((String) cnd.getValue()));
                            } catch(Exception e) {
                            	log.error(e.getMessage());
                                cnd.setValue(null);
                            }
						}
						else if(fieldClass.equals(Integer.class) || fieldClass.equals(int.class)) {
                            try {
							    cnd.setValue(Integer.parseInt((String) cnd.getValue()));
                            } catch(Exception e) {
                            	log.error(e.getMessage());
                                cnd.setValue(null);
                            }
						}
						else if(fieldClass.equals(Double.class) || fieldClass.equals(double.class)) {
                            try {
                                cnd.setValue(Double.parseDouble((String) cnd.getValue()));
                            } catch(Exception e) {
                            	log.error(e.getMessage());
                                cnd.setValue(null);
                            }
						}
                        else if(fieldClass.equals(BigDecimal.class) || fieldClass.equals(BigDecimal.class)) {
                            try {
                                cnd.setValue(new BigDecimal(Double.parseDouble((String) cnd.getValue())));
                            } catch(Exception e) {
                            	log.error(e.getMessage());
                                cnd.setValue(null);
                            }
                        }
					}
				}
				// other types etc.
			}
			else if(cnd.getValue()!=null && cnd.getValue() instanceof Integer) {
				Class fieldClass = getFieldClass(entityClass, cnd.getProperty());
				if(fieldClass!=null) {
					if(fieldClass.equals(Long.class) || fieldClass.equals(long.class)) {
						cnd.setValue(Long.parseLong(Integer.toString((Integer) cnd.getValue())));
					}
					if(fieldClass.equals(Double.class) || fieldClass.equals(double.class)) {
						cnd.setValue(Double.parseDouble(Integer.toString((Integer) cnd.getValue())));
					}
				}
			}
		} else if(cond instanceof LogicCond) {
			LogicCond cnd = (LogicCond) cond;
			if(cnd.getLeft()!=null) {
				adapt(entityClass,cnd.getLeft());
			}
			if(cnd.getRight()!=null) {
				adapt(entityClass,cnd.getRight());
			}
		}
	}

    /**
     * @function 获取字段的class类型
     *
     * @param fieldName
     * @param entityClass
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    @SuppressWarnings("rawtypes")
	public static Class getFieldClass(final Class entityClass, final String fieldName) {
		if(entityClass==null || fieldName==null) {
			return null;
		}
		int index = fieldName.indexOf(".");
		if(index == -1) {
			try {
				Field field = entityClass.getDeclaredField(fieldName);
				return field.getType();
			} catch (NoSuchFieldException e) {
				if(entityClass.equals(Object.class)) {
					log.error(e.getMessage());
					return null;
				}
				else {
					return getFieldClass(entityClass.getSuperclass(), fieldName);
				}
			}
			
		}
		else {
			String firstFieldName = fieldName.substring(0,index);
			Field firstField = null;
			try {
				firstField = entityClass.getDeclaredField(firstFieldName);
			} catch (NoSuchFieldException e) {
				if(entityClass.equals(Object.class)) {
					log.error(e.getMessage());
					return null;
				}
				else {
					return getFieldClass(entityClass.getSuperclass(), fieldName);
				}
			}
			String subFieldName = fieldName.substring(index+1);
			return getFieldClass(firstField.getType(), subFieldName);
		}
	}
}
