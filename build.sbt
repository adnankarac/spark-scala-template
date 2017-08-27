/*
 * Copyright 2011-2016 Marconi Lanna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Project metadata
 */

name := "PROJECT"

version := "0.1"

description := "PROJECT DESCRIPTION"

// organization := "org.example"

// organizationName := "Example, Inc."

// organizationHomepage := Some(url("http://example.org"))

// homepage := Some(url("http://project.org"))

startYear := Some(2011)

licenses += "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")
// "GPLv2" -> url("http://www.gnu.org/licenses/gpl-2.0.html")

/*
 * scalac configuration
 */

scalaVersion in ThisBuild := "2.11.8"

scalaSource in Compile := baseDirectory.value / "src"

javaSource in Compile := baseDirectory.value / "src"

scalaSource in Test := baseDirectory.value / "test"

javaSource in Test := baseDirectory.value / "test"

resourceDirectory in Compile := (scalaSource in Compile).value / "resources"

resourceDirectory in Test := (scalaSource in Test).value / "resources"

compileOrder := CompileOrder.JavaThenScala

val commonScalacOptions = Seq(
  "-encoding", "UTF-8" // Specify character encoding used by source files
, "-target:jvm-1.8" // Target platform for object files
, "-Xexperimental" // Enable experimental extensions
, "-Xfuture" // Turn on future language features
, "-Ybackend:GenBCode" // Choice of bytecode emitter
)

val compileScalacOptions = Seq(
  "-deprecation" // Emit warning and location for usages of deprecated APIs
, "-feature" // Emit warning and location for usages of features that should be imported explicitly
, "-g:vars" // Set level of generated debugging info: none, source, line, vars, notailcalls
//"-language:_" // Enable or disable language features (see list below)
, "-optimise" // Generates faster bytecode by applying optimisations to the program
, "-unchecked" // Enable additional warnings where generated code depends on assumptions
//"-Xdev" // Indicates user is a developer - issue warnings about anything which seems amiss
, "-Xfatal-warnings" // Fail the compilation if there are any warnings
, "-Xlint:_" // Enable or disable specific warnings (see list below)
, "-Xstrict-inference" // Don't infer known-unsound types
, "-Yclosure-elim" // Perform closure elimination
, "-Yconst-opt" // Perform optimization with constant values
, "-Ydead-code" // Perform dead code elimination
, "-Yinline" // Perform inlining when possible
, "-Yinline-handlers" // Perform exception handler inlining when possible
, "-Yinline-warnings" // Emit inlining warnings
, "-Yno-adapted-args" // Do not adapt an argument list to match the receiver
//"-Yno-imports" // Compile without importing scala.*, java.lang.*, or Predef
//"-Yno-predef" // Compile without importing Predef
, "-Yopt:_" // Enable optimizations (see list below)
, "-Ywarn-dead-code" // Warn when dead code is identified
, "-Ywarn-numeric-widen" // Warn when numerics are widened
, "-Ywarn-unused" // Warn when local and private vals, vars, defs, and types are unused
, "-Ywarn-unused-import" // Warn when imports are unused
, "-Ywarn-value-discard" // Warn when non-Unit expression results are unused
)

scalacOptions ++= commonScalacOptions ++ compileScalacOptions ++ Seq(
  "-Ywarn-value-discard" // Warn when non-Unit expression results are unused
)

scalacOptions in (Test, compile) := commonScalacOptions ++ compileScalacOptions

scalacOptions in (Compile, console) := commonScalacOptions ++ Seq(
  "-language:_" // Enable or disable language features (see list below)
, "-nowarn" // Generate no warnings
)

scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

/*
scalac -language:help

dynamics             Allow direct or indirect subclasses of scala.Dynamic
existentials         Existential types (besides wildcard types) can be written and inferred
experimental.macros  Allow macro definition (besides implementation and application)
higherKinds          Allow higher-kinded types
implicitConversions  Allow definition of implicit functions called views
postfixOps           Allow postfix operator notation, such as `1 to 10 toList'
reflectiveCalls      Allow reflective access to members of structural types

*//*

scalac -Xlint:help

adapted-args               Warn if an argument list is modified to match the receiver
by-name-right-associative  By-name parameter of right associative operator
delayedinit-select         Selecting member of DelayedInit
doc-detached               A Scaladoc comment appears to be detached from its element
inaccessible               Warn about inaccessible types in method signatures
infer-any                  Warn when a type argument is inferred to be `Any`
missing-interpolator       A string literal appears to be missing an interpolator id
nullary-override           Warn when non-nullary `def f()' overrides nullary `def f'
nullary-unit               Warn when nullary methods return Unit
option-implicit            Option.apply used implicit view
package-object-classes     Class or object defined in package object
poly-implicit-overload     Parameterized overloaded implicit methods are not visible as view bounds
private-shadow             A private field (or class parameter) shadows a superclass field
stars-align                Pattern sequence wildcard must align with sequence component
type-parameter-shadow      A local type parameter shadows a type already in scope
unsound-match              Pattern match may not be typesafe

*//*

scalac -Yopt:help

compact-locals      Eliminate empty slots in the sequence of local variables
empty-labels        Eliminate and collapse redundant labels in the bytecode
empty-line-numbers  Eliminate unnecessary line number information
inline-global       Inline methods from any source, including classfiles on the compile classpath
inline-project      Inline only methods defined in the files being compiled
nullness-tracking   Track nullness / non-nullness of local variables and apply optimizations
simplify-jumps      Simplify branching instructions, eliminate unnecessary ones
unreachable-code    Eliminate unreachable code, exception handlers protecting no instructions, debug information of eliminated variables
l:none              Don't enable any optimizations
l:default           Enable default optimizations: unreachable-code
l:method            Enable intra-method optimizations: unreachable-code,simplify-jumps,empty-line-numbers,empty-labels,compact-locals,nullness-tracking
l:project           Enable cross-method optimizations within the current project: l:method,inline-project
l:classpath         Enable cross-method optimizations across the entire classpath: l:project,inline-global
*/

/*
 * Managed dependencies
 */

libraryDependencies ++= Seq(
  "commons-codec"                     % "commons-codec"                    % "1.10"
, "commons-io"                        % "commons-io"                       % "2.5"
, "commons-validator"                 % "commons-validator"                % "1.5.1"
, "joda-time"                         % "joda-time"                        % "2.9.6"
, "mysql"                             % "mysql-connector-java"             % "6.0.5"
, "ch.qos.logback"                    % "logback-classic"                  % "1.1.7"
, "com.github.nscala-time"           %% "nscala-time"                      % "2.14.0"
//"com.github.pathikrit"             %% "better-files"                     % "2.16.0" // No 2.12
, "com.github.t3hnar"                %% "scala-bcrypt"                     % "3.0"
, "com.google.guava"                  % "guava"                            % "20.0"
, "com.ibm.icu"                       % "icu4j"                            % "58.1"
, "com.softwaremill.macwire"         %% "macros"                           % "2.2.5"     % Provided
, "com.softwaremill.macwire"         %% "proxy"                            % "2.2.5"
, "com.softwaremill.macwire"         %% "util"                             % "2.2.5"
, "com.softwaremill.quicklens"       %% "quicklens"                        % "1.4.8"
, "com.typesafe"                      % "config"                           % "1.3.1"
, "com.typesafe.scala-logging"       %% "scala-logging"                    % "3.5.0"
, "com.typesafe.slick"               %% "slick"                            % "3.2.0-M2"
, "com.typesafe.slick"               %% "slick-hikaricp"                   % "3.2.0-M2"
, "com.univocity"                     % "univocity-parsers"                % "2.2.3"
, "de.svenkubiak"                     % "jBCrypt"                          % "0.4.1"
, "org.apache.commons"                % "commons-compress"                 % "1.12"
, "org.apache.commons"                % "commons-csv"                      % "1.4"
, "org.apache.commons"                % "commons-lang3"                    % "3.5"
, "org.apache.commons"                % "commons-math3"                    % "3.6.1"
, "org.apache.httpcomponents"         % "httpclient"                       % "4.5.2"
, "org.joda"                          % "joda-money"                       % "0.12"
, "org.jsoup"                         % "jsoup"                            % "1.10.1"
, "org.postgresql"                    % "postgresql"                       % "9.4.1212"
, "org.quartz-scheduler"              % "quartz"                           % "2.2.3"
, "org.quartz-scheduler"              % "quartz-jobs"                      % "2.2.3"
, "org.scala-lang"                    % "scala-reflect"                    % scalaVersion.value
, "org.scalactic"                    %% "scalactic"                        % "3.0.1"
)

libraryDependencies ++= Seq(
  "org.mockito"                       % "mockito-core"                     % "2.2.29"
, "org.scalatest"                    %% "scalatest"                        % "3.0.1"
, "org.seleniumhq.selenium"           % "selenium-java"                    % "3.0.1"
) map (_ % Test)

/*
 * sbt options
 */

// Statements executed when starting the Scala REPL (sbt's `console` task)

initialCommands := """
import
  scala.annotation.{switch, tailrec},
  scala.beans.{BeanProperty, BooleanBeanProperty},
  scala.collection.JavaConverters._,
  scala.collection.{breakOut, mutable},
  scala.concurrent.{Await, ExecutionContext, Future},
  scala.concurrent.ExecutionContext.Implicits.global,
  scala.concurrent.duration._,
  scala.language.experimental.macros,
  scala.math._,
  scala.reflect.macros.blackbox,
  scala.util.{Failure, Random, Success, Try},
  scala.util.control.NonFatal,
  java.io._,
  java.net._,
  java.nio.file._,
  java.time.{Duration => jDuration, _},
  System.{currentTimeMillis => now},
  System.nanoTime

def desugarImpl[T](c: blackbox.Context)(expr: c.Expr[T]): c.Expr[Unit] = {
  import c.universe._, scala.io.AnsiColor.{BOLD, GREEN, RESET}

  val exp = show(expr.tree)
  val typ = expr.actualType.toString takeWhile '('.!=

  println(s"$exp: $BOLD$GREEN$typ$RESET")
  reify { (): Unit }
}

def desugar[T](expr: T): Unit = macro desugarImpl[T]
"""

// Do not exit sbt when Ctrl-C is used to stop a running app
cancelable in Global := true

// Improved incremental compilation
incOptions := incOptions.value.withNameHashing(true)

// Improved dependency management
updateOptions := updateOptions.value.withCachedResolution(true)

showSuccess := true

showTiming := true

// Uncomment to enable offline mode
// offline := true

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true

// Enable colors in Scala console (2.11.4+)
initialize ~= { _ =>
  val ansi = System.getProperty("sbt.log.noformat", "false") != "true"
  if (ansi) System.setProperty("scala.color", "true")
}

// Draw a separator between triggered runs (e.g, ~test)
triggeredMessage := { ws =>
  if (ws.count > 1) {
    val ls = System.lineSeparator * 2
    ls + "#" * 100 + ls
  } else ""
}

shellPrompt := { state =>
  import scala.Console.{BLUE, BOLD, RESET}
  s"$BLUE$BOLD${name.value}$RESET $BOLD\u25b6$RESET "
}

/*
 * Database migration
 */

import com.typesafe.config.ConfigFactory

val conf = ConfigFactory.parseFile(new File("src/resources/application.conf")).resolve

flywayUrl := conf.getString("db.url")

flywayLocations := Seq("classpath:db/migration")

flywaySqlMigrationPrefix := ""

/*
 * Scalastyle: http://www.scalastyle.org/
 */

scalastyleConfig := baseDirectory.value / "project" / "scalastyle-config.xml"

scalastyleFailOnError := true

// Create a default Scalastyle task to run with tests
lazy val mainScalastyle = taskKey[Unit]("mainScalastyle")
lazy val testScalastyle = taskKey[Unit]("testScalastyle")

mainScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("").value
testScalastyle := org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Test).toTask("").value

(test in Test) := ((test in Test) dependsOn testScalastyle).value
(test in Test) := ((test in Test) dependsOn mainScalastyle).value

/*
 * sbt-assembly https://github.com/sbt/sbt-assembly
 */
test in assembly := {}

/*
 * WartRemover: http://github.com/puffnfresh/wartremover
 */

wartremoverErrors ++= Seq(
  Wart.Any
, Wart.AsInstanceOf
//Wart.DefaultArguments
, Wart.EitherProjectionPartial
//Wart.Enumeration
//Wart.Equals
, Wart.ExplicitImplicitTypes
, Wart.FinalCaseClass
//Wart.FinalVal
//Wart.ImplicitConversion
, Wart.IsInstanceOf
, Wart.JavaConversions
, Wart.LeakingSealed
//Wart.MutableDataStructures
//Wart.NonUnitStatements
, Wart.Nothing
, Wart.Null
, Wart.Option2Iterable
, Wart.OptionPartial
//Wart.Overloading
, Wart.Product
, Wart.Return
, Wart.Serializable
, Wart.StringPlusAny
, Wart.Throw
//Wart.ToString
, Wart.TraversableOps
, Wart.TryPartial
, Wart.Var
//Wart.While
)

/*
 * Scapegoat: http://github.com/sksamuel/scapegoat
 */

scapegoatVersion := "1.3.0"

scapegoatDisabledInspections := Seq.empty

scapegoatIgnoredFiles := Seq.empty

// Create a default Scapegoat task to run with tests
lazy val mainScapegoat = taskKey[Unit]("mainScapegoat")
lazy val testScapegoat = taskKey[Unit]("testScapegoat")

mainScapegoat := scapegoat.in(Compile).value
testScapegoat := scapegoat.in(Test).value

(test in Test) := ((test in Test) dependsOn testScapegoat).value
(test in Test) := ((test in Test) dependsOn mainScapegoat).value

/*
 * Linter: http://github.com/HairyFotr/linter
 */

addCompilerPlugin("org.psywerx.hairyfotr" %% "linter" % "0.1.17")

scalacOptions += "-P:linter:enable-only:" +
  "AssigningOptionToNull+" +
  "AvoidOptionCollectionSize+" +
  "AvoidOptionMethod+" +
  "AvoidOptionStringSize+" +
  "BigDecimalNumberFormat+" +
  "BigDecimalPrecisionLoss+" +
  "CloseSourceFile+" +
  "ContainsTypeMismatch+" +
  "DecomposingEmptyCollection+" +
  "DivideByOne+" +
  "DivideByZero+" +
  "DuplicateIfBranches+" +
  "DuplicateKeyInMap+" +
  "EmptyStringInterpolator+" +
  "FilterFirstThenSort+" +
  "FloatingPointNumericRange+" +
  "FuncFirstThenMap+" +
  "IdenticalCaseBodies+" +
  "IdenticalCaseConditions+" +
  "IdenticalIfCondition+" +
  "IdenticalIfElseCondition+" +
  "IdenticalStatements+" +
  "IfDoWhile+" +
  "IndexingWithNegativeNumber+" +
  "InefficientUseOfListSize+" +
  "IntDivisionAssignedToFloat+" +
  "InvalidParamToRandomNextInt+" +
  "InvalidStringConversion+" +
  "InvalidStringFormat+" +
  "InvariantCondition+" +
  "InvariantExtrema+" +
  "InvariantReturn+" +
  "JavaConverters+" +
  "LikelyIndexOutOfBounds+" +
  "MalformedSwap+" +
  "MergeMaps+" +
  "MergeNestedIfs+" +
  "ModuloByOne+" +
  "NumberInstanceOf+" +
  "OnceEvaluatedStatementsInBlockReturningFunction+" +
  "OperationAlwaysProducesZero+" +
  "OptionOfOption+" +
  "PassPartialFunctionDirectly+" +
  "PatternMatchConstant+" +
  "PossibleLossOfPrecision+" +
  "PreferIfToBooleanMatch+" +
  "ProducesEmptyCollection+" +
  "ReflexiveAssignment+" +
  "ReflexiveComparison+" +
  "RegexWarning+" +
  "StringMultiplicationByNonPositive+" +
  "SuspiciousMatches+" +
  "SuspiciousPow+" +
  "TransformNotMap+" +
  "TypeToType+" +
  "UndesirableTypeInference+" +
  "UnextendedSealedTrait+" +
  "UnitImplicitOrdering+" +
  "UnlikelyEquality+" +
  "UnlikelyToString+" +
  "UnnecessaryMethodCall+" +
  "UnnecessaryReturn+" +
  "UnnecessaryStringIsEmpty+" +
  "UnnecessaryStringNonEmpty+" +
  "UnsafeAbs+" +
  "UnthrownException+" +
  "UnusedForLoopIteratorValue+" +
  "UnusedParameter+" +
  "UseAbsNotSqrtSquare+" +
  "UseCbrt+" +
  "UseConditionDirectly+" +
  "UseContainsNotExistsEquals+" +
  "UseCountNotFilterLength+" +
  "UseExistsNotCountCompare+" +
  "UseExistsNotFilterIsEmpty+" +
  "UseExistsNotFindIsDefined+" +
  "UseExp+" +
  "UseExpm1+" +
  "UseFilterNotFlatMap+" +
  "UseFindNotFilterHead+" +
  "UseFlattenNotFilterOption+" +
  "UseFuncNotFold+" +
  "UseFuncNotReduce+" +
  "UseFuncNotReverse+" +
  "UseGetOrElseNotPatMatch+" +
  "UseGetOrElseOnOption+" +
  "UseHeadNotApply+" +
  "UseHeadOptionNotIf+" +
  "UseHypot+" +
  "UseIfExpression+" +
  "UseInitNotReverseTailReverse+" +
  "UseIsNanNotNanComparison+" +
  "UseIsNanNotSelfComparison+" +
  "UseLastNotApply+" +
  "UseLastNotReverseHead+" +
  "UseLastOptionNotIf+" +
  "UseLog10+" +
  "UseLog1p+" +
  "UseMapNotFlatMap+" +
  "UseMinOrMaxNotSort+" +
  "UseOptionExistsNotPatMatch+" +
  "UseOptionFlatMapNotPatMatch+" +
  "UseOptionFlattenNotPatMatch+" +
  "UseOptionForallNotPatMatch+" +
  "UseOptionForeachNotPatMatch+" +
  "UseOptionGetOrElse+" +
  "UseOptionIsDefinedNotPatMatch+" +
  "UseOptionIsEmptyNotPatMatch+" +
  "UseOptionMapNotPatMatch+" +
  "UseOptionOrNull+" +
  "UseOrElseNotPatMatch+" +
  "UseQuantifierFuncNotFold+" +
  "UseSignum+" +
  "UseSqrt+" +
  "UseTakeRightNotReverseTakeReverse+" +
  "UseUntilNotToMinusOne+" +
  "UseZipWithIndexNotZipIndices+" +
  "VariableAssignedUnusedValue+" +
  "WrapNullWithOption+" +
  "YodaConditions+" +
  "ZeroDivideBy"

/*
 * scoverage: http://github.com/scoverage/sbt-scoverage
 */

coverageMinimum := 90

coverageFailOnMinimum := true

coverageOutputCobertura := false

coverageOutputHTML := true

coverageOutputXML := false

/*
 * Scalariform: http://github.com/daniel-trinh/scalariform
 */

//import com.typesafe.sbt.SbtScalariform
//import scalariform.formatter.preferences._
//
//SbtScalariform.defaultScalariformSettings
//
//scalariformPreferences := scalariformPreferences.value
//  .setPreference(AlignArguments, false)
//  .setPreference(AlignParameters, false)
//  .setPreference(AlignSingleLineCaseStatements, false)
//  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 12)
//  .setPreference(CompactControlReadability, false)
//  .setPreference(CompactStringConcatenation, false)
//  .setPreference(DoubleIndentClassDeclaration, true)
//  .setPreference(FormatXml, false)
//  .setPreference(IndentLocalDefs, false)
//  .setPreference(IndentPackageBlocks, true)
//  .setPreference(IndentSpaces, 2)
//  .setPreference(IndentWithTabs, false)
//  .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)
//  .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, false)
//  .setPreference(PreserveDanglingCloseParenthesis, true)
//  .setPreference(PreserveSpaceBeforeArguments, false)
//  .setPreference(RewriteArrowSymbols, false)
//  .setPreference(SpaceBeforeColon, false)
//  .setPreference(SpaceInsideBrackets, false)
//  .setPreference(SpaceInsideParentheses, false)
//  .setPreference(SpacesAroundMultiImports, false)
//  .setPreference(SpacesWithinPatternBinders, true)
