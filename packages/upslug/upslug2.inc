# This package builds the 'upslug2' binary upload/flash tool
# for the NSLU2.  It is not useful for anything else.
PR = "r0"
DESCRIPTION = "NSLU2 binary upload tool (version 2)"
HOMEPAGE = "http://www.nslu2-linux.org/wiki/Main/UpSlug2"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "MIT"

# On Linux libpcap does not work.  Using libpcap is sub-optimal - it
# is intended for packet capture not management of a new protocol
# stream - so you may want to try the linux options on other operating
# systems.
LIBPCAP_OECONF = "--with-libpcap"
LIBPCAP_OECONF_linux = ""
LIBPCAP_OECONF_linux-uclibc = ""
LIBPCAP_RDEPENDS = "libpcap"
LIBPCAP_RDEPENDS_linux = ""
LIBPCAP_RDEPENDS_linux-uclibc = ""

RDEPENDS += "${LIBPCAP_RDEPENDS}"

SRC_URI = "${SOURCEFORGE_MIRROR}/nslu/upslug2-${PV}.tar.gz"

inherit autotools

S = "${WORKDIR}/upslug2-${PV}"

PACKAGES = "${PN}"
EXTRA_OECONF += "${LIBPCAP_OECONF}"

python () {
	# Don't build upslug2 unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("upslug2 only builds for the Linksys NSLU2")
}
