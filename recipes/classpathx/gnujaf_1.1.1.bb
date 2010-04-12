DESCRIPTION = "Provides a mean to type data and locate components suitable for performing various kinds of action on it."
LICENSE = "GPL + library exception"
AUTHOR = "GNU ClasspathX"

SRC_URI = "\
  http://ftp.gnu.org/gnu/classpathx/activation-${PV}.tar.gz \
  file://datadir_java.patch;patch=1 \
  "

# java-library must be last (it defines do_stage)
inherit autotools java-library

S = "${WORKDIR}/activation-${PV}"

DEPENDS = "fastjar-native"

export JAVAC = "javac"

# Fake javadoc
export JAVADOC = "true"

JARFILENAME = "activation-${PV}.jar"
ALTJARFILENAMES = "activation.jar gnujaf.jar"

do_compile() {
  mkdir -p build

  javac -sourcepath source -d build `find source -name "*.java"`

  fastjar -C build -c -f ${JARFILENAME} .
}

do_install() {
  java_install
}

SRC_URI[md5sum] = "de50d7728e8140eb404f2b4554321f8c"
SRC_URI[sha256sum] = "b1b5ef560d30fcb11fbf537246857d14110ce4eb2b200d4c54690472305d87b7"
