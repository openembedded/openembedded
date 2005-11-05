LICENSE = "GPL"
DESCRIPTION = "gdb - GNU debugger"
SECTION = "devel"
PRIORITY = "optional"
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
                --with-curses --with-readline --disable-sim \
                --program-prefix=''"

do_configure () {
# override this function to avoid the autoconf/automake/aclocal/autoheader
# calls for now
	gnu-configize
	oe_runconf
}

do_install () {
	make -C bfd/doc chew LDFLAGS= CFLAGS=-O2
	oe_runmake install \
	    'prefix=${D}${prefix}' 'exec_prefix=${D}${prefix}' 'bindir=${D}${bindir}' \
	    'sbindir=${D}${sbindir}' 'infodir=${D}${infodir}' 'libdir=${D}${libdir}' \
	    'mandir=${D}${mandir}' 'includedir=${D}${includedir}'
	install -d ${D}${bindir}
	install -m 0755 gdb/gdbserver/gdbserver ${D}${bindir}
}

#
# patch description
#
# readline.patch:
#   gdb 5.3 provides its own readline source which tends to conflict with
#   readline package. we override readline included from gdb source
#   with packaged readline and fix up extern tilde_expand in gdb/defs.h
#
