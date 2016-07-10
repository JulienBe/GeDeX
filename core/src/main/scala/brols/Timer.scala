package brols

/**
  * Created by julein on 10/07/16.
  */
class Timer(val limit: Float) {
  var time = 0f

  def step(delta: Float) = {
    time += delta
    time > limit
  }
}
