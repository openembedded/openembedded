DESCRIPTION = "gdb - GNU debugger"
LICENSE="GPL"
SECTION = "devel"
PRIORITY = "optional"
PR = "r1"
MAINTAINER = "Pawel Osiczko <p.osiczko@tetrapyloctomy.org>"
DEPENDS = "ncurses readline"

PACKAGES =+ 'gdbserver '
FILES_gdbserver = '${bindir}/gdbserver'

inherit autotools gettext

SRC_URI = "${GNU_MIRROR}/gdb/gdb-${PV}.tar.gz \
	   file://uclibc.patch;patch=1"

LDFLAGS_append = " -s"
export CC_FOR_BUILD = "${BUILD_CC}"
export CXX_FOR_BUILD = "${BUILD_CXX}"
export CPP_FOR_BUILD = "${BUILD_CPP}"
export CFLAGS_FOR_BUILD = "${BUILD_CFLAGS}"
export CXXFLAGS_FOR_BUILD = "${BUILD_CXXFLAGS}"
export CPPFLAGS_FOR_BUILD = "${BUILD_CPPFLAGS}"
export CFLAGS_append=" -L${STAGING_LIBDIR}"
EXTRA_OEMAKE = "'SUBDIRS=intl mmalloc libiberty opcodes bfd sim gdb etc utils'"

EXTRA_OECONF = "--disable-gdbtk --disable-tui --disable-x \
                --with-curses --disable-multilib --with-readline --disable-sim \
                --program-prefix=''"

S = "${WORKDIR}/gdb-${PV}"
B = "${WORKDIR}/build-${TARGET_SYS}"

do_configure () {
# override this function to avoid the autoconf/automake/aclocal/autoheader
# calls for now
	(cd ${S} && gnu-configize) || die "failure in running gnu-configize"
        CPPFLAGS="" oe_runconf
}

do_install () {
	make -C bfd/doc chew LDFLAGS= CFLAGS=-O2
	oe_runmake install \
	    'prefix=${D}' 'exec_prefix=${D}' 'bindir=${D}${base_bindir}' \
	    'sbindir=${D}${base_sbindir}' 'infodir=${D}/share/info' 'libdir=${D}${base_libdir}' \
	    'mandir=${D}/share/man' 'includedir=${D}/include'
	install -d ${D}${bindir}
	install -m 0755 gdb/gdbserver/gdbserver ${D}${bindir}
}
