# Lab 04 -  Functional Programming Advanced

Fifth laboratory of [Programming and Development Paradigms - a.y. 2025-2026](https://www.unibo.it/en/teaching/course-unit-catalogue/course-unit/2025/526526) ([Computer Science and Engineering](https://corsi.unibo.it/2cycle/ComputerScienceEngineering)).

## Author

[@EnryMarch10](https://github.com/EnryMarch10)

## Details

Third laboratory about functional programming using **Scala**.

### Exercises

#### Part 1 - ADTs

- Look at the package `tasks.adts` in the `u04` package.
- **Task 1**: complete the `Ex1ComplexNumbers` module so that it passes the tests (`ComplexNumbersTest`).
  - Thinking at the ADT, what is the best way to represent a complex number?
- **Task 2**: implement the `Ex2SchoolModel` module along with the `SchoolModelTest` test.
  - Follow the suggestions in the comments of the `Ex2SchoolModel` module.
- **Task 3**: implement the `Ex3Stacks` along with the `StacksTest` test.
  - Follow the suggestions in the comments of the `Ex3Stacks` module.

#### Part 2 - Type classes

- Look at the package `tasks.typeclasses` in the `u04` package.
- **Task 4**: follow the instructions in the comments of the `Ex4Summables` module:
  - this is a one-kinded type class, composed of the methods zero and sum.
- **Task 5**: follow the instructions in the comments of the `Ex5Traversable` module:
  - this is a higher-kinded type class, so it takes a type constructor as a parameter.

#### Part 3 - Streams

- Look at the package `tasks.monads` in the `u04` package.
- **Task 6**: implement the `Try` monad as described in the comments of the `Ex6TryMonad` module:
  - `Try` is similar to the `Optional` monad, but it can carry an exception.
  - Understand the implementation of the `Try` monad.
  - Complete the tasks and verify that the main works.

## License

[MIT](https://choosealicense.com/licenses/mit/)
