DESCRIPTION = "Streaming pull XML parser for Java (3rd edition)"
LICENSE = "BSD-like"

HOMEPAGE = "http://www.extreme.indiana.edu/xgws/xsoap/xpp/mxp1"

SRC_URI = "http://www.extreme.indiana.edu/dist/java-repository/xpp3/distributions/${P}_src.tgz"

inherit java-library

DEPENDS = "fastjar-native virtual/javac-native"

PACKAGES = "libxpp3-xpath-java ${JPN}"

do_compile() {
	if [ -d build-oe ]; then
		rm -rf build-oe
	fi
  mkdir -p build-oe

	sourcepath="src/java/api:src/java/builder:src/java/dom2_builder:src/java/mxp1_min:src/java/mxp1_standard:src/java/parser_pool:src/java/sax2_driver:src/java/serializer_impl:src/java/util:src/java/wrapper"
	findpath="${sourcepath//:/ }"

  javac -sourcepath $sourcepath -d build-oe `find $findpath -name "*.java"`

	mkdir -p build-oe/META-INF/services
	cp src/java/mxp1_standard/META-INF/services/org.xml* build-oe/META-INF/services
  fastjar -C build-oe -c -f ${JARFILENAME} .

	if [ -d build-xpath ]; then
		rm -rf build-xpath
	fi
  mkdir -p build-xpath

	sourcepath="src/java/xpath"
	findpath="${sourcepath//:/ }"
  javac -sourcepath $sourcepath -cp build-oe -d build-xpath `find $findpath -name "*.java"`

  fastjar -C build-xpath -c -f xpp3-xpath-${PV}.jar .
}

do_install_append() {
	oe_jarinstall xpp3-xpath-${PV}.jar xpp3-xpath.jar
}

FILES_libxpp3-xpath-java = "${datadir}/java/xpp3-xpath*"


SRC_URI[md5sum] = "e1b6aeaad1cd06e64568aae1a507d5c6"
SRC_URI[sha256sum] = "404c0cd332f54ecf9807dc86d365c17dcffab669994c9dcbbad31fbc4b59f811"
