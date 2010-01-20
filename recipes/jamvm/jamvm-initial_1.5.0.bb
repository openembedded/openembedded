SUMMARY = "A compact Java Virtual Machine which conforms to the JVM specification version 2."
HOMEPAGE = "http://jamvm.sourceforge.net/"
LICENSE = "GPL"

DEPENDS = "zlib-native classpath-initial jikes-initial libffi-native"

PR = "r1"

PROVIDES = "virtual/java-initial"

S = "${WORKDIR}/jamvm-${PV}"

SRC_URI = "${SOURCEFORGE_MIRROR}/jamvm/jamvm-${PV}.tar.gz \
          file://jamvm_${PV}-initial.patch;patch=1;pnum=1 \
          "

# This uses 32 bit arm, so force the instruction set to arm, not thumb
ARM_INSTRUCTION_SET = "arm"

inherit native autotools

# libdir must be modified so that jamvm-initial and -native
# do not interfere
EXTRA_OECONF = "\
  --with-classpath-install-dir=${prefix} \
  --program-suffix=-initial \
  --libdir=${STAGING_LIBDIR}/jamvm-initial \
  "

# jamvm-initial has to run some binaries which need lots of memory.
CFLAGS += "-DDEFAULT_MAX_HEAP=512*MB"

do_compile() {
  oe_runmake \
    JAVAC=jikes-initial \
    GLIBJ_ZIP=${STAGING_DATADIR_NATIVE}/classpath-initial/glibj.zip
}

do_stage_append() {
  install -d ${STAGING_BINDIR}
  install -m 0755 java-initial ${STAGING_BINDIR}
}
