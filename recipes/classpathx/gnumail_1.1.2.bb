DESCRIPTION = "GNU's free implementation of the JavaMail API specification"
LICENSE = "GPL + library exception"
AUTHOR = "GNU ClasspathX"

SRC_URI = "\
  http://ftp.gnu.org/gnu/classpathx/mail-${PV}.tar.gz \
  file://datadir_java.patch;patch=1 \
  "

inherit java-library autotools

S = "${WORKDIR}/mail-${PV}"

DEPENDS = "fastjar-native gnujaf inetlib"

export JAVAC = "javac"
export JAVA = "java"

# Fake javadoc
export JAVADOC = "true"

EXTRA_OECONF = "\
  --with-inetlib-jar=${STAGING_DATADIR_JAVA} \
  --with-activation-jar=${STAGING_DATADIR_JAVA} \
  "

do_compile() {
  oe_runmake \
    JARDIR=${datadir_java} \
    gnumail_jar=${JARFILENAME} \
    providers_jar=${P}-providers.jar
}

do_install() {
  java_install
  oe_jarinstall ${P}-providers.jar ${PN}-providers.jar
}

do_stage() {
  java_stage
  oe_jarinstall -s ${P}-providers.jar ${PN}-providers.jar
}
