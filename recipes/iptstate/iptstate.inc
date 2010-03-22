DESCRIPTION = "IPTState is a top-like interface to your netfilter connection-tracking table."
HOMEPAGE = "http://www.phildev.net/iptstate/"
SECTION = "console/network"
LICENSE = "zlib"
DEPENDS = "ncurses libnetfilter-conntrack"
INC_PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/iptstate/iptstate-${PV}.tar.bz2;name=iptstate-${PV}"

do_install () {
	oe_runmake install SBIN=${D}/${sbindir} MAN=${D}/${mandir}
}
