package it.unibo.pps.tasks.typeclasses

import org.junit.Test
import org.junit.Assert.assertEquals

import it.unibo.pps.u03.Sequences.Sequence.{Cons, Nil}
import it.unibo.pps.u04.tasks.typeclasses.Ex4Summables.{sumAll, sumAllInt}

class SummablesTest:
  val si = Cons(10, Cons(20, Cons(30, Nil())))
  val sd = Cons(10.0, Cons(20.0, Cons(30.0, Nil())))
  val ss = Cons("10", Cons("20", Cons("30", Nil())))

  @Test def testSumInt(): Unit =
    assertEquals(60, sumAllInt(si))

  @Test def testSumTypeClassInt(): Unit =
    assertEquals(60, sumAll(si))

  @Test def testSumTypeClassDouble(): Unit =
    assertEquals(60.0, sumAll(sd), 0.05)

  @Test def testSumTypeClassString(): Unit =
    assertEquals("102030", sumAll(ss))
