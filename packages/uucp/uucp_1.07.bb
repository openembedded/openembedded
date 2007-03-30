DESCRIPTION = "UUCP is used to transfer mail, news and random files between systems which are not connected by more modern networks. The communication can be made via modems, direct (hard-wired) serial connections or via an IP connection."
LICENSE = "GPLv2"
SECTION = "console"
PR = "r1"

inherit autotools

SRC_URI = "http://ftp.debian.org/debian/pool/main/u/uucp/uucp_1.07.orig.tar.gz"

do_configure() {
	libtoolize --force
	oe_runconf
}

do_install_append() {
    fakeroot install -d -g uucp -o uucp ${D}/usr/spool/uucp
}

PACKAGES =+ "cu"
FILES_cu = "${bindir}/cu /usr/spool"
