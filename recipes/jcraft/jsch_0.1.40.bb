DESCRIPTION = "SSH implementation in Java"
LICENSES = "BSD"

HOMEPAGE = "http://www.jcraft.com/jsch"

SRC_URI = "${SOURCEFORGE_MIRROR}/jsch/jsch-${PV}.zip"

inherit java-library

DEPENDS = "fastjar-native jzlib"
RDEPENDS = "libjzlib-java"

do_compile() {
  mkdir -p build

	oe_makeclasspath cp -s jzlib

  javac -sourcepath src -cp $cp -d build `find src -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}
