DESCRIPTION = "Design quality metrics generator for each Java"

# see http://www.clarkware.com/software/license.txt
LICENSE = "BSD"

HOMEPAGE = "http://clarkware.com/software/JDepend.html"

SRC_URI = "http://www.clarkware.com/software/jdepend-${PV}.zip"

inherit java-library

DEPENDS = "fastjar-native"

do_compile() {
  mkdir -p build

  javac -sourcepath src -d build `find src -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}
