DESCRIPTION = "Header generator for Cacao JVM - Needed for cross-compilation builds"
HOMEPAGE = "http://www.cacaojvm.org/"
LICENSE  = "GPL"

DEPENDS = "libtool-native zlib-native virtual/javac-native classpath-native"

S = "${WORKDIR}/cacao-${PV}"

inherit autotools native

EXTRA_OECONF = " \
  --with-classpath-includedir=${STAGING_INCDIR}/classpath \
  --with-classpath-classes=${STAGING_DATADIR}/classpath/glibj.zip \
  \
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

do_stage() {
	install -m 0755 src/cacaoh/.libs/cacaoh ${STAGING_BINDIR}/cacaoh-${PV}
}
