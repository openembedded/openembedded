require jamvm.inc 

DEPENDS = "zlib-native classpath-native ecj-initial"
RDEPENDS = ""

PROVIDES = "virtual/java-native"

RPROVIDES_jamvm = ""

# This uses 32 bit arm, so force the instruction set to arm, not thumb
ARM_INSTRUCTION_SET = "arm"

# Needed for big compilation targets like OpenJDK
CFLAGS += "-DDEFAULT_MAX_HEAP=2048*MB"

inherit native

S = "${WORKDIR}/jamvm-${PV}"

do_install_append() {
  ln -sf jamvm ${STAGING_BINDIR}/java
}

# Enforce usage of ecj-initial.
export JAVAC="${STAGING_BINDIR_NATIVE}/ecj-initial"

