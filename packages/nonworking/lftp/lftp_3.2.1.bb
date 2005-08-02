DESCRIPTION = "lftp is a sophisticated command line based file \
transfer program. Supported protocols include FTP, HTTP, and FISH."
HOMEPAGE = "http://lftp.yar.ru"
SECTION = "console/network"
DEPENDS = "readline"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://ftp.yars.free.net/pub/software/unix/net/ftp/client/lftp/lftp-${PV}.tar.bz2 \
	   file://pty.patch;patch=1"
S = "${WORKDIR}/lftp-${PV}"

EXTRA_OECONF = "--disable-largefile --disable-rpath --with-included-readline=no"

inherit autotools gettext

PARALLEL_MAKE = ""

do_configure() {
	gnu-configize
	oe_runconf
}

