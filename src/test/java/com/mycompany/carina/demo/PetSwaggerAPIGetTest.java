package com.mycompany.carina.demo;

	import java.lang.invoke.MethodHandles;
	import java.time.temporal.ChronoUnit;
	import java.util.concurrent.atomic.AtomicInteger;

	import org.skyscreamer.jsonassert.JSONCompareMode;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.testng.annotations.Test;

	import com.zebrunner.carina.core.IAbstractTest;
	import com.mycompany.carina.demo.api.DeleteUserMethod;
	import com.mycompany.carina.demo.api.GetUserMethods;
	import com.mycompany.carina.demo.api.PostUserMethod;
	import com.zebrunner.carina.api.APIMethodPoller;
	import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
	import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
	import com.zebrunner.carina.core.registrar.tag.Priority;
	import com.zebrunner.carina.core.registrar.tag.TestPriority;

public class PetSwaggerAPIGetTest {
	;

	/**
	 * This sample shows how create REST API tests.
	 *
	 * @author qpsdemo
	 */
	public class APISampleTest implements IAbstractTest {

	    private final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	    

	   

	    @Test()
	    @MethodOwner(owner = "qpsdemo")
	    public void testGetUsers() {
	        GetUserMethods getUsersMethods = new GetUserMethods();
	        getUsersMethods.callAPIExpectSuccess();
	        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
	        //getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
	    }

	    @Test()
	    @MethodOwner(owner = "qpsdemo")
	    @TestPriority(Priority.P1)
	    public void testDeleteUsers() {
	        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
	        //deleteUserMethod.setProperties("api/users/user.properties");
	        deleteUserMethod.callAPIExpectSuccess();
	        deleteUserMethod.validateResponse();
	    }

	}

}
