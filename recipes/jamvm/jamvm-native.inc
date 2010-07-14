require jamvm.inc 

DEPENDS = "zlib-native classpath-native ecj-initial"
RDEPENDS_${PN} = ""

PROVIDES = "virtual/java-native"

RPROVIDES_jamvm = ""

# This uses 32 bit arm, so force the instruction set to arm, not thumb
ARM_INSTRUCTION_SET = "arm"

# Needed for big compilation targets like OpenJDK
CFLAGS += "-DDEFAULT_MAX_HEAP=2048*MB"

EXTRA_OECONF += "--with-program-suffix=-bin"

SRC_URI += "file://java"

inherit native

S = "${WORKDIR}/jamvm-${PV}"

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/java ${D}${bindir}/
}

# Enforce usage of ecj-initial.
export JAVAC="${STAGING_BINDIR_NATIVE}/ecj-initial"

