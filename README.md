Toy Robot
=========

Toy Robot is a minimalistic toy robot scala implementation conforming to the specifications from the [problem description](PROBLEM.md).

Testing
-------

No tests as of yet.

Building
--------

The easiest way is to use sbt. This produces a fat jar with scala dependencies all wrapped up inside.

```
sbt assembly
```

Running
-------

To run the toy robot against an input file:

```
./run.sh examples/example1.txt
```
