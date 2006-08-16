LICENSE = "GPL"
DESCRIPTION = "lftp is a sophisticated command line based file \
transfer program. Supported protocols include FTP, HTTP, \
and FISH."
HOMEPAGE = "http://lftp.yar.ru"
SECTION = "console/network"
DEPENDS = "readline gnutls"

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/network/file-transfer/lftp-3.5.1.tar.gz"

EXTRA_OECONF = "--disable-largefile --disable-rpath --with-included-readline=no"

inherit autotools gettext
