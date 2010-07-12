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
