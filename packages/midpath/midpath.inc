DESCRIPTION = "MIDPath is a Java library which provides a MIDP2 implementation"
HOMEPAGE = "http://midpath.thenesis.org/"
LICENSE  = "GPL"
PRIORITY = "optional"
SECTION  = "interpreters"
PR = "r1"

SRC_URI = "http://downloads.sourceforge.net/midpath/midpath-${PV}.tar.gz"

S = "${WORKDIR}/midpath-${PV}"

DEPENDS = "ecj-native fastjar-native classpath-minimal"

JAVAC_CMD = "${STAGING_BINDIR_NATIVE}/ecj"

FASTJAR_CMD = "${STAGING_BINDIR_NATIVE}/fastjar"

JAVA_PATH = "${STAGING_DATADIR}/java"

GNU_CLASSPATH_PATH = "${JAVA_PATH}/classpath-minimal/glibj.zip"

CLDC_PATH = ${JAVA_PATH}/cldc1.1.jar
