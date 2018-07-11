package sample;

import com.coveros.selenified.DriverSetup;
import com.coveros.selenified.Selenified;
import com.coveros.selenified.services.Call;
import com.coveros.selenified.services.Request;
import com.google.gson.JsonObject;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SampleServicesPost extends Selenified {

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext test) {
        // set the base URL for the tests here
        setTestSite(this, test, "http://maps.googleapis.com/maps/api/geocode/json");
        // set the author of the tests here
        setAuthor(this, test, "Hammid Funsho\n<br/>hammid.funsho@coveros.com");
        // set the version of the tests or of the software, possibly with a
        // dynamic check
        setVersion(this, test, "0.0.1");
    }

    @BeforeMethod(alwaysRun = true)
    protected void startTest(Object[] dataProvider, Method method, ITestContext test, ITestResult result) {
        super.startTest(dataProvider, method, test, result, DriverSetup.FALSE);
    }

    @Test(groups = { "services" }, description = "A test to verify the response code ")
    public void sampleResponseCodePostsTest() {
        Map<String, String> params = new HashMap<>();
        params.put("address", "123mainstreet");
        // use this object to verify the app looks as expected
        Call call = this.calls.get();
        // perform some actions
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("long_name", "94105");
        jsonObject.addProperty("short_name", "94105");

        call.get("", new Request(params)).assertContains(jsonObject);
        // verify one issue
        finish(0);
    }
}
