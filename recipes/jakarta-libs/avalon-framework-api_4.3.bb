DESCRIPTION = "Common way for components to be created, initialized, configured, started. (API-only)"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "\
	http://www.apache.org/dist/excalibur/avalon-framework/source/${BP}-src.tar.gz \
	http://www.apache.org/dist/avalon/logkit/source/logkit-1.2.2-src.tar.gz \
	"

inherit java-library

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

	#	Allow reaching method definitions from logkit (stupid cyclic dependency).
	srcpath=src/java:${WORKDIR}/logkit-1.2.2-dev/src/java

  javac -sourcepath $srcpath -d build `find src/java -name "*.java"`

	# Remove classes that belong to logkit ...
	rm -rf ${S}/build/org/apache/log

  fastjar -C build -c -f ${JARFILENAME} .
}


