DESCRIPTION = "Header generator for Cacao JVM - Needed for cross-compilation builds"
HOMEPAGE = "http://www.cacaojvm.org/"
LICENSE = "GPL"
DEPENDS = "libtool-native zlib-native virtual/javac-native classpath-native"

INC_PR = "r5"

S = "${WORKDIR}/cacao-${PV}"

inherit autotools native

EXTRA_OECONF = " \
  --with-java-runtime-library-classes=${STAGING_DATADIR}/classpath/glibj.zip \
  --with-jni_md_h=${STAGING_INCDIR}/classpath \
  --with-jni_h=${STAGING_INCDIR}/classpath \
  "

do_compile() {
  # Compile the header generator only (and what is needed for it).
  oe_runmake -C src/toolbox libtoolbox.la
  oe_runmake -C src/vmcore libvmcore.la
  oe_runmake -C src/cacaoh cacaoh
}

do_install() {
  install -d ${D}${bindir}/cacaoh-${PV}
  ${STAGING_BINDIR_NATIVE}/${HOST_SYS}-libtool --mode=install install -m 0755 src/cacaoh/cacaoh ${D}${bindir}/cacaoh-${PV}
}

NATIVE_INSTALL_WORKS = "1"
