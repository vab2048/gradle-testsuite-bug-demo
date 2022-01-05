# gradle-testsuite-bug-demo
Demo of an issue with running tests using the gradle testsuite config.

## Background

This project declares an integrationTest suite: 

```groovy
testing {
    suites {
        integrationTest(JvmTestSuite) {
            dependencies {
                implementation project
            }
        }
    }
}
```

There is a controller:

```java
@RestController
public class HelloController {

    @GetMapping("/")
    String hello() {
        return "hello";
    }
}
```

And two identical test classes:
- `src/test/java/com/example/demo/HelloControllerTest.java`
  - The test here pass
- `src/integrationTest/java/com/example/demo/HelloControllerIntegrationTest.java`
  - The test here FAILS to compile
  - It fails with `class file for org.springframework.http.MediaType not found`.

I would expect the test in the integration test suite to pass as well.

What is going wrong here?