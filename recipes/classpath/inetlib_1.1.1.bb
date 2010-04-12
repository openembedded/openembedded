DESCRIPTION = "A Java library of clients for common internet protocols"
LICENSE = "GPL + library exception"
AUTHOR = "GNU Classpath"
HOMEPAGE = "http://gnu.org/software/classpath/inetlib.html"

SRC_URI = "\
  http://ftp.gnu.org/gnu/classpath/${BP}.tar.gz \
  file://datadir_java.patch;patch=1 \
  "

inherit java-library autotools

DEPENDS = "fastjar-native"

JPN = "libgnuinet-java"

export JAVAC = "javac"

export JAVA = "java"

# We fake this, it is not neccessary anyway.
export JAVADOC = "true"

do_compile() {
  oe_runmake JARDIR=${datadir_java} inetlib_jar=${JARFILENAME}
}

do_install_append() {
  java_install
}

SRC_URI[md5sum] = "aaa24be4bc8d172ac675be8bdfa636ee"
SRC_URI[sha256sum] = "1b078a39e022f86e4e2c8189b4d2789a5da414e8f1cb285587b7800b950a44de"
