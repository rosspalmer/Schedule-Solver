package com.palmer.data.scheduler

import com.google.ortools.Loader
import com.google.ortools.linearsolver.MPConstraint
import com.google.ortools.linearsolver.MPObjective
import com.google.ortools.linearsolver.MPSolver
import com.google.ortools.linearsolver.MPVariable


object SimpleScheduler {

  def determineProductAssignments(problem: Problem): Unit = {

    Loader.loadNativeLibraries()
    val solver = MPSolver.createSolver("GLOP")

    val assignments: Map[String, Map[String, MPVariable]] = problem.lines.map(l =>
      (
        l.id,
        l.rates.map(r =>
          (
            r.product,
            solver.makeNumVar(0.0, problem.getOrderAmount(r.product), s"${l.id}-${r.product}")
          )
        ).toMap
      )).toMap

    val timeConstraints: Map[String, MPConstraint] = problem.lines.map(l => {
      val lineAssignments = assignments(l.id)
      // TODO add minimum run time for individual lines
      val availableLineTime = solver.makeConstraint(0.0, l.totalTime.toDouble)
      l.rates.foreach(r => availableLineTime.setCoefficient(lineAssignments(r.product), 1 / r.rate))
      (l.id, availableLineTime)
    }).toMap

    val minimalTime: MPObjective = solver.objective()
    minimalTime.setMinimization()



  }

}
