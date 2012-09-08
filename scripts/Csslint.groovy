includeTargets << grailsScript("_GrailsInit")

target(csslint: "Run CssLint on the projects CSS files.")
{
  // TODO: Implement script here

  parseArguments()


  def options = [:]
/*

<target name="csslint">
    <apply executable="java" failonerror="true" parallel="true">
        <fileset dir="${src.dir}" includes="** /*.css" />
        <arg line="-jar"/>
        <arg path="${lib.dir}/js.jar"/>
        <arg path="${lib.dir}/csslint-rhino.js" />

        <!-- your customized arguments go here -->
        <arg line="${cssfiles.clean} --warnings=box-model,floats --errors=ids,important"/>

        <srcfile/>
    </apply>
</target>

 */

//  ant.exec(executable: 'java', failOnError: true){
//    arg(line: '-jar')
//    arg(path: "js.jar")
//    arg(path: 'csslint-rhino.js')
//  }

  def cssLint = "lib"+File.separator+"csslint-rhino.js"

  def files = ant.fileset(dir: 'web-app/css')



  files.each{ file ->
    println "Checking: "+file
    ant.path(id: "grails.compile.classpath", compileClasspath)
    ant.java(className:'org.mozilla.javascript.tools.shell.Main',fork:true,classpathref: 'grails.compile.classpath'){
//      permissions{
//        grant(class:'java.util.PropertyPermission', name:'read' )
//      }
//      permissions()
//          {    //This will work but stop after processing one file no need to fork
//            grant(class:'java.security.AllPermission' )
//            grant(class:'java.lang.RuntimePermission', name:'exitVM')
//
//          }
      arg(line: '-debug')
      arg(path: cssLint)

      arg(path: file)

      arg(line: '--warnings=box-model,floats')
      arg(line: '--errors=ids,important')
      arg(line:  '--format=lint-xml')
    }
    println "finished"
  }

}

setDefaultTarget(csslint)
