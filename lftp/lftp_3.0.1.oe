LICENSE = GPL
DESCRIPTION = "lftp is a sophisticated command line based file \
transfer program. Supported protocols include FTP, HTTP, \
and FISH."
HOMEPAGE = "http://lftp.yar.ru"
SECTION = "console/network"
DEPENDS = "readline"
PR = "r1"

SRC_URI = "http://ftp.yars.free.net/pub/software/unix/net/ftp/client/lftp/old/lftp-${PV}.tar.bz2 \
	   file://pty.patch;patch=1"

EXTRA_OECONF = "--disable-largefile --disable-rpath --with-included-readline=no"

inherit autotools gettext
