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
