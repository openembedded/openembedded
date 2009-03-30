DESCRIPTION = "High-performance XML processor."
LICENSE = "AL2.0 LGPL2.1"

AUTHOR = "Codehaus"
HOMEPAGE = "http://woodstox.codehaus.org"

SRC_URI = "http://woodstox.codehaus.org/2.0.6/wstx-src.tar.gz"

S = "${WORKDIR}"

inherit java-library

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build/META-INF/services

  javac -nowarn -sourcepath src/java -d build \
		`find src/java/org -name "*.java"` \
		`find src/java/com -name "*.java"`

  cp -r src/resources/* build/META-INF/services

  fastjar -C build -c -f ${JARFILENAME} .
}
