DESCRIPTION = "mkcons program needed for javasqlite build"
HOMEPAGE = "http://www.ch-werner.de/javasqlite"
LICENSE  = "BSD"

DEPENDS = "sqlite-native sqlite3-native"

SRC_URI = "\
  http://www.ch-werner.de/javasqlite/javasqlite-${PV}.tar.gz \
  file://build-fix.patch;patch=1"

S = "${WORKDIR}/javasqlite-${PV}"

inherit autotools native

# Program names are there to fool configure checks
# because we actually do not need these.
EXTRA_OECONF = " \
  --with-sqlite-incdir=${STAGING_INCDIR} \
  --with-sqlite-libdir=${STAGING_LIBDIR} \
  --with-sqlite3-incdir=${STAGING_INCDIR} \
  --with-sqlite3-libdir=${STAGING_LIBDIR} \
  --with-jardir=${datadir_java} \
  --with-native-libdir=${libdir_jni} \
	--with-java='echo version 1.5' \
	--with-javac=true \
	--with-jar=true \
	--with-javah=true \
	--with-javadoc=true \
	"

do_configurepre() {
  sed -i -e "s|wrong-libtool|${BUILD_SYS}-libtool|" Makefile.in
}

addtask configurepre after do_patch before do_configure


do_compile() {
	oe_runmake native/mkconst
}

do_install() {
	:
}

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 0755 native/.libs/mkconst ${STAGING_BINDIR}/javasqlite-mkconst-${PV}
}

PACKAGES = ""

