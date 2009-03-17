DESCRIPTION = "IPTState is a top-like interface to your netfilter connection-tracking table."
HOMEPAGE = "http://www.phildev.net/iptstate/"
SECTION = "console/network"
LICENSE = "zlib"
DEPENDS = "ncurses"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/iptstate/iptstate-${PV}.tar.bz2"

#
# Make it use it's old style proc interface - these should be removed
# once libnetfilter_conntrack and libnfnetlink are added to OE.
#
CPPFLAGS += " -DIPTSTATE_USE_PROC -L${STAGING_LIBDIR}"
export LIBS = "-lncurses"

do_install () {
	oe_runmake install SBIN=${D}/${sbindir} MAN=${D}/${mandir}
}
