package com.hrtm.springboot.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

public class CommonUtils {
	
	/**
	 * Method to get names of all fields having null value for given object.
	 * @param source
	 *        Object to inspect for null value.
	 * @return {@link String[]}
	 *        List of all field names having null value for given object.
	 */
	public static String[] getNullPropertyNames (Object source) {
//		LOGGER.info("getNullPropertyNames() invoked to get null field names for "+source);
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	        
	        if ((srcValue instanceof Collection) && ((Collection<?>) srcValue).isEmpty()) {
	        	emptyNames.add(pd.getName());
		    }
	    }
	    
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}
}
