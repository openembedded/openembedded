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

SRC_URI[md5sum] = "b59cec19a487e95aed68378976b4b566"
SRC_URI[sha256sum] = "ca9d2ae08fd7a8983fb00d04f0f0c216a985218a5eb364ff9bee73870f28e097"
