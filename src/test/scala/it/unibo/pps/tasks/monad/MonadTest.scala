package it.unibo.pps.tasks.monad

import org.junit.Test
import org.junit.Assert.assertEquals

import it.unibo.pps.u04.tasks.monads.Ex6TryMonad.{exec, failure, success}

class MonadTest:

  @Test def testSuccess(): Unit =
    val result = for
      a <- success(10)
      b <- success(30)
    yield a + b
    assertEquals(40, result.getOrElse(-1))

  @Test def testFailure(): Unit =
    val result = for
      a <- success(10)
      b <- failure(new RuntimeException("error"))
      c <- success(30)
    yield a + c
    assertEquals(30, success(20).map(_ + 10).getOrElse(-1))
    assertEquals(-1, result.getOrElse(-1))

  @Test def testExec(): Unit =
    val result1 = for
      a <- success(10)
      b <- success(30)
      c <- exec(new Throwable()) // Exception is returned not throw!
    yield a + b
    assertEquals(40, result1.getOrElse(-1))
    val result2 = for
      a <- exec(10)
      b <- exec(throw new RuntimeException("error"))
      c <- exec(30)
    yield a + c
    assertEquals(-1, result2.getOrElse(-1))
