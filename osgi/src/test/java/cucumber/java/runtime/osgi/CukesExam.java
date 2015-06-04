package cucumber.java.runtime.osgi;

import static org.ops4j.pax.exam.CoreOptions.*;

import java.io.File;

import javax.inject.Inject;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.*;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.MavenUrlReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PaxExam.class)
public class CukesExam {

    private static Logger log = LoggerFactory.getLogger(CukesExam.class);
    
    @Configuration
    public Option[] config() {

	return new Option[] {
	    mavenBundle()
	        .groupId("info.cukes")
	        .artifactId("cucumber-jvm")
	        .version("1.2.3-SNAPSHOT").start(),
	    mavenBundle()
	        .groupId("info.cukes")
	        .artifactId("cucumber-osgi")
	        .version("1.2.3-SNAPSHOT").start()
	};
    }

    @Test
    public void testStuff() throws Exception {
	System.err.println("Running test?");
	assertEquals(5, "five");
    }

}
