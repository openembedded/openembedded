DESCRIPTION = "Python Programming Language"
HOMEPAGE = "http://www.python.org"
LICENSE = "PSF"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "python-native zlib gdbm"
PR = "ml4"

SRC_URI = "ftp://www.python.org/pub/python/${PV}/Python-${PV}.tar.bz2 \
	   file://bindir-libdir.patch;patch=1 \
	   file://crosscompile.patch;patch=1"
S = "${WORKDIR}/Python-${PV}"

inherit autotools

EXTRA_OECONF = "--with-threads --with-pymalloc --with-cyclic-gc --without-cxx --with-signal-module --with-wctype-functions"

#
# copy config.h and an appropriate Makefile for distutils.sysconfig
# which laters uses the information out of these to compile extensions
#
do_compile_prepend() {
	install -d ${STAGING_INCDIR}/python2.3/
	install -d ${STAGING_LIBDIR}/python2.3/config/
	install -m 0644 pyconfig.h ${STAGING_INCDIR}/python2.3/
	install -m 0644 Makefile Makefile.orig
	install -m 0644 Makefile Makefile.backup
	sed -e 's,${includedir},${STAGING_INCDIR},' < Makefile.backup > Makefile
	install -m 0644 Makefile Makefile.backup
	sed -e 's,${libdir},${STAGING_LIBDIR},' < Makefile.backup > Makefile
	install -m 0644 Makefile ${STAGING_LIBDIR}/python2.3/config/
}

do_compile() {
	oe_runmake HOSTPGEN=${STAGING_BINDIR}/pgen \
		   HOSTPYTHON=${STAGING_BINDIR}/python \
		   STAGING_LIBDIR=${STAGING_LIBDIR} \
		   STAGING_INCDIR=${STAGING_INCDIR} \
		   BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS}
}

do_stage() {
	install -m 0644 Include/*.h ${STAGING_INCDIR}/python2.3/
}

do_install() {
	install -m 0644 Makefile.orig Makefile
        oe_runmake HOSTPGEN=${STAGING_BINDIR}/pgen \
                   HOSTPYTHON=${STAGING_BINDIR}/python \
                   STAGING_LIBDIR=${STAGING_LIBDIR} \
                   STAGING_INCDIR=${STAGING_INCDIR} \
		   BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
		   DESTDIR=${D} install
}

include python-${PV}-manifest.inc
