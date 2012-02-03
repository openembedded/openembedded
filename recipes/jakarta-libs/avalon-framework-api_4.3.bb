DESCRIPTION = "Common way for components to be created, initialized, configured, started. (API-only)"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "\
	http://archive.apache.org/dist/excalibur/framework/source/${BP}-src.tar.gz;name=archive \
	http://www.apache.org/dist/avalon/logkit/source/logkit-1.2.2-src.tar.gz;name=logkit \
	"

inherit java-library

DEPENDS = "fastjar-native"

PR = "r1"

do_compile() {
  mkdir -p build

	#	Allow reaching method definitions from logkit (stupid cyclic dependency).
	srcpath=src/java:${WORKDIR}/logkit-1.2.2-dev/src/java

  javac -sourcepath $srcpath -d build `find src/java -name "*.java"`

	# Remove classes that belong to logkit ...
	rm -rf ${S}/build/org/apache/log

  fastjar -C build -c -f ${JARFILENAME} .
}



SRC_URI[archive.md5sum] = "d4cffb4ba1d07bdc517ac6e322636495"
SRC_URI[archive.sha256sum] = "a4d56a053609ddfc77f6a42c3f15a11708d5e0eb29ffc60a40b87e4cc7331d47"
SRC_URI[logkit.md5sum] = "996ee20d6b5785ab71f4692f64d10f9c"
SRC_URI[logkit.sha256sum] = "2c81edc87571fbd05797da7f65515e089c62cbb735bdbd10f93e29bd3aa3ddb8"

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
