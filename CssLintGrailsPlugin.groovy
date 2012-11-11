class CssLintGrailsPlugin {
	def version = "0.1"
	def grailsVersion = "1.3.7 > *"
	def scopes = [excludes: 'war']
	def title = "CssLint for Grails"
	def author = "Jeff Beck"
	def authorEmail = "beckje01@gmail.com"
	def description = 'Allows the user to run csslint on their css files.'
	def documentation = "https://github.com/beckje01/grails-csslint"

	def license = "APACHE"
	def issueManagement = [system: "github", url: "https://github.com/beckje01/grails-csslint/issues"]
	def scm = [url: "https://github.com/beckje01/grails-csslint"]
}
