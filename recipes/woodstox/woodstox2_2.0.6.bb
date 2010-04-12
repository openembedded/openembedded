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

SRC_URI[md5sum] = "3fc8e914d13316aa254b883a99fd2b85"
SRC_URI[sha256sum] = "e7ab2018865334a1b9b04161235192c2fdc7387baa422b576722db2011f75157"
