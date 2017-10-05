[![Build Status](https://travis-ci.org/Raffaello/PI-akka-example.svg?branch=master)](https://travis-ci.org/Raffaello/PI-akka-example)

# PI-Akka example

It is an example how to use Akka to compute PI using a summation.

It is an upgrade/enanchement of the original tutorial reported
[here](https://doc.akka.io/docs/akka/2.0/intro/getting-started-first-scala.html).

## Formula

We are using the [Leibniz](https://en.wikipedia.org/wiki/Leibniz_formula_for_%CF%80) formula:

![formula](http://latex.codecogs.com/gif.latex?%5Csum_%7Bn%3D0%7D%5E%7Bn%20%5Cto%20%5Cinfty%7D%5Cfrac%7B%28-1%29%5En%7D%7B2n%2B1%7D%20%3D%20%5Cfrac%7B%5Cpi%7D%7B4%7D%5CRightarrow%204%2A%5Csum_%7Bn%3D0%7D%5E%7Bn%20%5Cto%20%5Cinfty%7D%5Cfrac%7B%28-1%29%5En%7D%7B2n%2B1%7D%20%3D%20%5Cpi)

### Improvements

- Calculating PI/4 and at the end it will be computed times 4
- Added Worker Akka-Unit testing
- using `application.conf` for the parameters instead of hard-coding them