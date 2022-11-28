package com.palmer.data.scheduler

import com.google.ortools.Loader
import com.google.ortools.linearsolver.MPConstraint
import com.google.ortools.linearsolver.MPObjective
import com.google.ortools.linearsolver.MPSolver
import com.google.ortools.linearsolver.MPVariable

object BasicExampleApp extends App {

  Loader.loadNativeLibraries()

  val solver = MPSolver.createSolver("GLOP")

  val infinity = java.lang.Double.POSITIVE_INFINITY
  // x and y are continuous non-negative variables.
  val x = solver.makeNumVar(0.0, infinity, "x")
  val y = solver.makeNumVar(0.0, infinity, "y")
  println("Number of variables = " + solver.numVariables)

  import com.google.ortools.linearsolver.MPConstraint
  // x + 2*y <= 14.// x + 2*y <= 14.

  val c0 = solver.makeConstraint(-infinity, 14.0, "c0")
  c0.setCoefficient(x, 1)
  c0.setCoefficient(y, 2)

  // 3*x - y >= 0.
  val c1 = solver.makeConstraint(0.0, infinity, "c1")
  c1.setCoefficient(x, 3)
  c1.setCoefficient(y, -1)

  // x - y <= 2.
  val c2 = solver.makeConstraint(-infinity, 2.0, "c2")
  c2.setCoefficient(x, 1)
  c2.setCoefficient(y, -1)
  println("Number of constraints = " + solver.numConstraints)

  // Maximize 3 * x + 4 * y.// Maximize 3 * x + 4 * y.

  val objective = solver.objective
  objective.setCoefficient(x, 3)
  objective.setCoefficient(y, 4)
  objective.setMaximization()

  val resultStatus = solver.solve

  if (resultStatus eq MPSolver.ResultStatus.OPTIMAL) {
    System.out.println("Solution:")
    System.out.println("Objective value = " + objective.value)
    System.out.println("x = " + x.solutionValue)
    System.out.println("y = " + y.solutionValue)
  }
  else System.err.println("The problem does not have an optimal solution!")


}
