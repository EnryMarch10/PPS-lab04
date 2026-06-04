package it.unibo.pps.u04.tasks.adts

import scala.annotation.tailrec

/*  Exercise 1:
 *  Complete the implementation of ComplexADT trait below, so that it passes
 *  the test in ComplexTest.
 */
object Ex1ComplexNumbers:

  trait ComplexADT:
    type Complex
    def complex(re: Double, im: Double): Complex
    extension (complex: Complex)
      def re(): Double
      def im(): Double
      def sum(other: Complex): Complex
      def subtract(other: Complex): Complex
      def asString(): String

  object BasicComplexADT extends ComplexADT:
    private case class ComplexImpl(re: Double, im: Double)
    // Change assignment below: should probably define a case class and use it?
    opaque type Complex = ComplexImpl // TIPO // (Double, Double) // TUPLA // Nothing

    def complex(re: Double, im: Double): Complex = ComplexImpl(re, im)

    extension (complex: Complex)
      def re(): Double = complex.re
      def im(): Double = complex.im
      def sum(other: Complex): Complex = ComplexImpl(complex.re + other.re, complex.im + other.im)
      def subtract(other: Complex): Complex = ComplexImpl(complex.re - other.re, complex.im - other.im)
      def asString(): String =
        if complex.im == 0
          then s"${complex.re}"
        else if complex.re == 0
          then s"${complex.im}i"
        else if complex.im > 0
          then s"${complex.re} + ${complex.im}i"
        else s"${complex.re} - ${-complex.im}i"
