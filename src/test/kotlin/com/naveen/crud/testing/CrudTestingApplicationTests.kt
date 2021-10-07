package com.naveen.crud.testing

import com.naveen.crud.testing.entity.Message
import com.naveen.crud.testing.service.TestableService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class CrudTestingApplicationTests {
	@Test
	fun givenServiceMock_whenCallingMockedMethod_thenCorrectlyVerified() {
		// given
		val service = mockk<TestableService>()



		every { service.getDataFromDb("Expected Param") } returns "Expected Output"

		// when
		val result = service.getDataFromDb("Expected Param")

		// then
		verify { service.getDataFromDb("Expected Param") }
		assertEquals("Expected Output", result)
	}

	@Test
	fun givenServiceMock_whenCallingMockedMethod_thenCorrectlyVerified1() {

		val service = mockk<TestableService>()
 		every { service.getDataFromDb("hi") } returns "bye"
		val result = service.getDataFromDb("hi")
		assertEquals("bye", result)
	}



}
