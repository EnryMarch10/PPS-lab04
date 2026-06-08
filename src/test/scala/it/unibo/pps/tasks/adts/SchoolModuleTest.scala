package it.unibo.pps.tasks.adts

import org.junit.Test
import org.junit.Assert.{assertEquals, assertFalse, assertTrue}

import it.unibo.pps.u04.adts.SequenceADT.{cons, nil}
import it.unibo.pps.u04.tasks.adts.Ex2SchoolModule.BasicSchoolModule.*

class SchoolModuleTest:

  @Test def testEmptySchool(): Unit =
    val school = emptySchool
    assertEquals(nil(), school.teachers)
    assertEquals(nil(), school.courses)

  @Test def testSimpleSchool(): Unit =
    val school = emptySchool
      .setTeacherToCourse(teacher("Maria"), course("italian"))
      .setTeacherToCourse(teacher("Maria"), course("italian"))
      .setTeacherToCourse(teacher("Maria"), course("history"))
      .setTeacherToCourse(teacher("Giulio"), course("geography"))
    assertEquals(cons("Giulio", cons("Maria", nil())), school.teachers)
    assertEquals(cons("geography", cons("history", cons("italian", nil()))), school.courses)
    assertEquals(cons("history", cons("italian", nil())), school.coursesOfATeacher(teacher("Maria")))
    assertTrue(school.hasTeacher("Maria"))
    assertTrue(school.hasCourse("italian"))
    assertFalse(school.hasTeacher("Giuseppe"))
    assertFalse(school.hasCourse("mathematics"))
