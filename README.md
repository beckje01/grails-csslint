Grails Csslint
==============

This plugin allows a user to run _grails csslint_ and get the lint output.


Config
---------------------

This plugin accepts the following configs

### Example

```groovy
csslint.warnings = "ids"
csslint.errors = "important,font-sizes"
```

### All Options

<table>
	<tr>
		<td>Option</td><td></td>
	</tr>
	<tr>
		<td>errors</td><td>A List of rules to use as errors.</td>
	</tr>
	<tr>
		<td>warnings</td><td>A list of rules to use as warnings.</td>
	</tr>
	<tr>
		<td>includes</td><td>A list of file selectors to include, ex: <i>web-app/css/**/*.css</i></td>
	</tr>
	<tr>
		<td>outputFile</td><td>File for output</td>
	</tr>
	<tr>
		<td>format</td><td>Format of the output file.</td>
	</tr>
</table>