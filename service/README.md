SPRING FRAMEWORK REFERENCE

LOGGING (pag 12):
	- SLF4J is a cleaner dependency and more efficient at runtime than commons-logging because it uses compile-time bindings instead of runtime discovery of the other logging frameworks it integrates
	- To use SLF4J with Spring you need to replace the commons-logging dependency with the SLF4J-JCL bridge. Once you have done that then logging calls from within Spring will be translated into logging calls to the SLF4J API.
	- A common choice might be to bridge Spring to SLF4J, and then provide explicit binding from SLF4J to Log4J. You need to supply 4 dependencies (and exclude the existing commons-logging): the bridge, the SLF4J API, the binding to Log4J, and the Log4J implementation itself.
	- Another choice with fewer steps and fewer dependencies is to bind directly to Logback. This removes the extra binding step because Logback implements SLF4J directly, so you only need to depend on two libraries not four ( jcl-over-slf4j and logback). If you do that you might also need to exclude the slf4j-api dependency from other external dependencies (not Spring), because you only want one version of that API on the classpath.
