package com.naveen.crud.testing


import com.naveen.crud.testing.service.TestableService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
//https://www.baeldung.com/kotlin/mockk
class InjectTestService {
    lateinit var service1: TestableService
    lateinit var service2: TestableService

    fun invokeService1(): String {
        return service1.getDataFromDb("Test Param")
    }

    fun invokeService2() : String {
        return service2.doSomethingElse("hi")
    }
}

class AnnotationMockKUnitTest {

    @MockK
    lateinit var service1: TestableService

    @MockK
    lateinit var service2: TestableService

    @InjectMockKs
    var objectUnderTest = InjectTestService()

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun givenServiceMock_whenCallingMockedMethod_thenCorrectlyVerified() {
        // given
        every { service1.getDataFromDb("Test Param") } returns "No"
        // when
        val result = objectUnderTest.invokeService1()
        // then
        assertEquals("No", result)
    }

    @Test
    fun testingdoSomethingElseService() {
        every { service2.doSomethingElse("hi") } returns "bye"
        val result = objectUnderTest.invokeService2();
        assertEquals("bye", result, "to test something else")
    }

    @Test
    fun testWithMockkWithTestableServiceGetDataFromDB() {
        every { service2.getDataFromDb("Naveen") } returns "HelloNaveen"
        val dataFromDb = service2.getDataFromDb("Naveen") //   service1.getDataFromDb("Naveen")
        assertEquals("HelloNaveen", dataFromDb)

    }
}