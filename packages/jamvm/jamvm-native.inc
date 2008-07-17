require jamvm.inc 

DEPENDS = "zlib-native classpath-native virtual/javac-native"

PROVIDES_jamvm = "virtual/java-native"

RPROVIDES_jamvm = ""

# This uses 32 bit arm, so force the instruction set to arm, not thumb
ARM_INSTRUCTION_SET = "arm"

inherit native

S = "${WORKDIR}/jamvm-${PV}"

do_install_append() {
  ln -sf jamvm ${STAGING_BINDIR}/java
}
