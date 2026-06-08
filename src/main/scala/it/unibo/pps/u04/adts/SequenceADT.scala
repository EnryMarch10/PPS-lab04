package it.unibo.pps.u04.adts

import scala.annotation.tailrec

object SequenceADT:
  // implementation of data structure: fully hidden
  private enum SequenceImpl[E]:
    case Cons(head: E, tail: Sequence[E])
    case Nil()

  import SequenceImpl.*

  // the type Sequence is an opaque alias to SequenceImpl
  opaque type Sequence[A] = SequenceImpl[A]

  // constructors
  def cons[E](head: E, tail: Sequence[E]): Sequence[E] = Cons(head, tail)
  def nil[E](): Sequence[E] = Nil[E]()

  // operation as extension methods
  extension [A](seq: Sequence[A])
    //@tailrec
    def size(): Int = seq match
        case Cons(_, t) => 1 + t.size()
        case _ => 0

    def first(): Option[A] = seq match
      case Cons(h, t) => Some(h)
      case _ => None

    def filter(predicate: A => Boolean): Sequence[A] = seq match
      case Cons(h, t) if predicate(h) => Cons(h, t.filter(predicate))
      case Cons(_, t)                 => t.filter(predicate)
      case Nil()                      => Nil()

    @tailrec
    def has(predicate: A => Boolean): Boolean = seq match
      case Cons(h, t) if predicate(h) => true
      case Cons(_, t) => t.has(predicate)
      case Nil() => false

    def map[B](mapper: A => B): Sequence[B] = seq match
      case Cons(h, t) => Cons(mapper(h), t.map(mapper))
      case Nil()      => Nil()

    @tailrec
    def contains(elem: A): Boolean = seq match
      case Cons(h, t) if h == elem => true
      case Cons(_, t) => t.contains(elem)
      case _ => false

  // operations as standard methods
  def concat[A](seq1: Sequence[A], seq2: Sequence[A]): Sequence[A] = seq1 match
    case Cons(h, t) => Cons(h, concat(t, seq2))
    case Nil()      => seq2

@main def trySequenceADT =
  import SequenceADT.* // note single, import
  val seq = cons(10, cons(20, cons(30, nil())))
  println(concat(seq, seq.map(_ + 1)))
