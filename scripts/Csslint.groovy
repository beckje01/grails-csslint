import grails.util.GrailsUtil
import org.codehaus.groovy.grails.plugins.GrailsPluginUtils


includeTargets << grailsScript('_GrailsCompile')

target(csslint: "Run CssLint on the projects CSS files.") {
	depends(compile)
	parseArguments()

	def configClassName = getBindingValueOrDefault('configClassname', 'BuildConfig')
	def config = loadConfig(configClassName)


	def includes = ['web-app/css/**/*.css']
	if (config.includes) {
		if (config.includes instanceof List) {
			includes = config.includes
		}
		else if (config.includes instanceof String) {
			includes = [config.includes]
		}

	}



	def pluginDir = GrailsPluginUtils.pluginInfos.find { it.name == 'css-lint' }.pluginDir



	def cssLint = pluginDir.file.path + File.separator + "lib" + File.separator + "csslint-rhino.js"
	def files = ant.fileset(dir: '.', includes: includes.join(','))

	def warnings = 'box-model,floats'
	def errors = 'ids,important'
	def format = 'lint-xml'

	if (config.warnings instanceof String) {
		warnings = config.warnings
	}

	if (config.errors instanceof String) {
		errors = config.errors
	}

	if(config.format instanceof String) {
		format = config.format
	}

	def output = new File(config.outputFile ?: "target/csslint.xml")

	ant.path(id: "grails.compile.classpath", compileClasspath)
	ant.java(className: 'org.mozilla.javascript.tools.shell.Main', fork: true, classpathref: 'grails.compile.classpath', output: output) {
		arg(line: '-debug')

		arg(path: cssLint)

		files.each { file ->
			arg(path: file)
		}
		arg(line: '--warnings=' + warnings) //What should be warnings
		arg(line: '--errors=' + errors) //What should be errors
		arg(line: '--format=' + format)
	}

}


private getBindingValueOrDefault(String varName, Object defaultValue) {
	def variables = getBinding().getVariables()
	return variables.containsKey(varName) ? getProperty(varName) : defaultValue
}

private ConfigObject loadConfig(String className) {
	def classLoader = Thread.currentThread().contextClassLoader
	classLoader.addURL(new File(classesDirPath).toURL())
	println new File(classesDirPath)

	try {
		def conf = new ConfigSlurper(GrailsUtil.environment).parse(classLoader.loadClass(className))
		return new ConfigSlurper(GrailsUtil.environment).parse(classLoader.loadClass(className)).csslint
	}
	catch (ClassNotFoundException e) {
		return new ConfigObject()
	}
}

setDefaultTarget(csslint)
