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

SRC_URI[md5sum] = "64c54d43787339a7cced48390eb3e1d0"
SRC_URI[sha256sum] = "060c15bfba6cfd1171ad81f782789032113e199a5aded8f8e0c1c5bd1385b62c"
