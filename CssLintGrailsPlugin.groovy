class CssLintGrailsPlugin {
	// the plugin version
	def version = "0.1"
	// the version or versions of Grails the plugin is designed for
	def grailsVersion = "1.3.7 > *"
	// the other plugins this plugin depends on
	def dependsOn = [:]
	// resources that are excluded from plugin packaging
	def pluginExcludes = [
		"grails-app/views/error.gsp"
	]

	def scopes = [excludes: 'war']

	def title = "CssLint for Grails"

	def author = "Jeff Beck"
	def authorEmail = "beckje01@gmail.com"
	def description = '''\
Allows the user to run csslint on their css files.'''


	def documentation = "http://grails.org/plugin/css-lint"

	// Extra (optional) plugin metadata

	def license = "APACHE"

	// Details of company behind the plugin (if there is one)
	//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

	// Any additional developers beyond the author specified above.
	def developers = [[:]]

	// Location of the plugin's issue tracker.
	def issueManagement = [system: "github", url: "https://github.com/beckje01/grails-csslint/issues"]

	// Online location of the plugin's browseable source code.
	def scm = [url: "https://github.com/beckje01/grails-csslint"]

	def doWithWebDescriptor = { xml ->
	}

	def doWithSpring = {
	}

	def doWithDynamicMethods = { ctx ->
	}

	def doWithApplicationContext = { applicationContext ->
	}

	def onChange = { event ->

	}

	def onConfigChange = { event ->

	}

	def onShutdown = { event ->
	}
}
