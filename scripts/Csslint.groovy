includeTargets << grailsScript("_GrailsInit")

target(csslint: "Run CssLint on the projects CSS files.")
{

  parseArguments()


  def options = [:]


  def cssLint = "lib" + File.separator + "csslint-rhino.js"   //TODO test this when plugin is installed.

  def files = ant.fileset(dir: 'web-app/css')  //TODO make configurable

  def output = new File("target/csslint.xml") //TODO make configurable


  ant.path(id: "grails.compile.classpath", compileClasspath)
  ant.java(className: 'org.mozilla.javascript.tools.shell.Main', fork: true, classpathref: 'grails.compile.classpath', output: output) {
    arg(line: '-debug')

    arg(path: cssLint)

    files.each { file ->
      arg(path: file)
    }
    arg(line: '--warnings=box-model,floats') //What should be warnings
    arg(line: '--errors=ids,important')  //What should be errors
    arg(line: '--format=lint-xml') //TODO make format switch for the two versions
  }

}



setDefaultTarget(csslint)
