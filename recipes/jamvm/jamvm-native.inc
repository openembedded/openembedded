require jamvm.inc 

DEPENDS = "zlib-native classpath-native ecj-initial libffi-native"
RDEPENDS_${PN} = ""

PROVIDES = "virtual/java-native"

# Use libffi instead of handcoded JNI calling code. This code seems to have issues which only randomly
# trigger a segfault.
EXTRA_OECONF += "--enable-ffi"

RPROVIDES_jamvm = ""

# This uses 32 bit arm, so force the instruction set to arm, not thumb
ARM_INSTRUCTION_SET = "arm"

# Needed for big compilation targets like OpenJDK
CFLAGS += "-DDEFAULT_MAX_HEAP=2048*MB"

#SRC_URI += "file://java"

inherit native

S = "${WORKDIR}/jamvm-${PV}"

do_install_append() {
	install -d ${D}${bindir}
	ln -s ${bindir}/jamvm ${D}${bindir}/java
}

# Enforce usage of ecj-initial.
export JAVAC="${STAGING_BINDIR_NATIVE}/ecj-initial"

