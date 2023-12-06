package coroutines//package coroutines
//
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.async
//import nl.edsn.service.meteringpoint.meteringpoint.connections.CleanupOldAndInactiveMeteringPointsScheduler
//import nl.edsn.service.meteringpoint.meteringpoint.util.ean
//import org.junit.jupiter.api.AfterEach
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import java.time.LocalDate
//import java.time.LocalDateTime
//import java.time.ZoneOffset
//
//
//internal class CleanupOldAndInactiveMeteringPointsIntegrationTest() : BaseIntegrationTest() {
//    @Autowired
//    lateinit var cleanupOldAndInactiveMeteringPointsScheduler: CleanupOldAndInactiveMeteringPointsScheduler
//
//    @AfterEach
//    fun tearDown() {
//        meteringPointRepository.deleteAll()
//    }
//
//    @Test
//    fun `Cleanup meteringpoints`() {
//        // only remove records when
//        // - retired older than 2 years OR
//        // - endDate older than 2 years
//
//        meteringPointRepository.deleteAll()
//
//        insert { it.ean = ean(1) }
//        insert { it.retired = LocalDateTime.now().minusYears(2).minusDays(1).toInstant(ZoneOffset.UTC) }
//        insert { it.retired = LocalDateTime.now().minusYears(2).plusDays(1).toInstant(ZoneOffset.UTC) }
//        insert { it.endDate = LocalDate.now().minusYears(2).minusDays(1) }
//        insert { it.endDate = LocalDate.now().minusYears(2).plusDays(1) }
//        var inserted = meteringPointRepository.count()
//
//        GlobalScope.async {
//             cleanupOldAndInactiveMeteringPointsScheduler.cleanupConnectionStates()
//            assertEquals(2, inserted - meteringPointRepository.count() )
//
//        }
//        GlobalScope.async {
//            cleanupOldAndInactiveMeteringPointsScheduler.cleanupConnectionStates()
//            assertEquals(2, inserted - meteringPointRepository.count() )
//        }
//        Thread.sleep(1000)
//    }
//
//}
