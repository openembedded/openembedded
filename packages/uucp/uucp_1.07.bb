DESCRIPTION = "UUCP is used to transfer mail, news and random files between systems which are not connected by more modern networks. The communication can be made via modems, direct (hard-wired) serial connections or via an IP connection."
HOMEPAGE = "http://www.airs.com/ian/uucp.html"
SECTION = "console/utils"
LICENSE = "GPLv2"
PR = "r2"

inherit autotools

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/uucp/uucp-${PV}.tar.gz \
           file://policy.patch;patch=1"

do_configure() {
	libtoolize --force
	oe_runconf
}

do_install_append() {
    fakeroot install -d -g uucp -o uucp ${D}/var/spool/uucp
}

PACKAGES =+ "cu"
FILES_cu = "${bindir}/cu /var/spool"
