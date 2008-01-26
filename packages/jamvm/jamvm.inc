DESCRIPTION = "A compact Java Virtual Machine which conforms to the JVM specification version 2."
HOMEPAGE = "http://jamvm.sourceforge.net/"
LICENSE = "GPL"

DEPENDS = "zlib classpath virtual/javac-native"
RDEPENDS = "classpath"

SRC_URI = "${SOURCEFORGE_MIRROR}/jamvm/jamvm-${PV}.tar.gz"

RPROVIDES_jamvm = "java2-runtime"

# This uses 32 bit arm, so force the instruction set to arm, not thumb
ARM_INSTRUCTION_SET = "arm"

inherit autotools update-alternatives

EXTRA_OECONF = "--with-classpath-install-dir=${prefix}"
CFLAGS += "-DDEFAULT_MAX_HEAP=16*MB"

ALTERNATIVE_NAME = "java"
ALTERNATIVE_PATH = "${bindir}/jamvm"
ALTERNATIVE_PRIORITY = "10"
