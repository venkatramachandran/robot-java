# Robot
This is a Java based solution for the [Robot challenge](https://github.com/ioof-holdings/recruitment/wiki/Robot-Challenge). The solution has 2 commits, with the first commit having he solution to the root of the challenge and the 2nd commit having the solution for the extension.

## Singleton or not
While building the command pattern, there was a chance to build `RobotManager` as a singleton instead of passing around a reference to commands as a dependency. It was chosen to pass around a reference as it was not possible to wire in its dependencies in a simpler way.

