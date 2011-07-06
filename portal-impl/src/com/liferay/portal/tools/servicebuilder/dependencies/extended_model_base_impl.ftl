package ${packagePath}.model.impl;

import ${packagePath}.model.${entity.name};

<#if entity.hasLocalService() && entity.hasColumns()>
	import ${packagePath}.service.${entity.name}LocalServiceUtil;
</#if>

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the ${entity.name} service. Represents a row in the &quot;${entity.table}&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ${entity.name}Impl}.
 * </p>
 *
 * @author ${author}
 * @see ${entity.name}Impl
 * @see ${packagePath}.model.${entity.name}
 * @generated
 */
public abstract class ${entity.name}BaseImpl extends ${entity.name}ModelImpl implements ${entity.name} {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ${entity.humanName} model instance should use the {@link ${entity.name}} interface instead.
	 */

	<#if entity.hasLocalService() && entity.hasColumns()>
		public void save() throws SystemException {
			${entity.name}LocalServiceUtil.update${entity.name}(this);
		}
	</#if>

}