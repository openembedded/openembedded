SUMMARY = "A compact Java Virtual Machine which conforms to the JVM specification version 2."
HOMEPAGE = "http://jamvm.sourceforge.net/"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

DEPENDS = "zlib-native classpath-initial jikes-initial libffi-native"

PROVIDES = "virtual/java-initial"

PR = "r4"

S = "${WORKDIR}/jamvm-${PV}"

SRC_URI = "${SOURCEFORGE_MIRROR}/jamvm/jamvm-${PV}.tar.gz \
           file://libffi.patch \
           file://jamvm-initial.patch \
           file://java-initial \
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
  --enable-ffi \
  "

# jamvm-initial has to run some binaries which need lots of memory.
CFLAGS += "-DDEFAULT_MAX_HEAP=512*MB"

# Enforce usage of jikes-initial.
EXTRA_OEMAKE = "JAVAC=${STAGING_BINDIR_NATIVE}/jikes-initial \
                GLIBJ_ZIP=${STAGING_DATADIR_NATIVE}/classpath-inital/glibj.zip \
               "
do_install_append() {
  install -d ${D}${bindir}/
  install -m 0755 ${WORKDIR}/java-initial ${D}${bindir}/
}

SRC_URI[md5sum] = "3f538bab6e1c77aed331e5e71f754f5b"
SRC_URI[sha256sum] = "f329d1c8f42c06b53a3e82763d33900b100b8e9acd7afe02f7583c51253fd6e5"
