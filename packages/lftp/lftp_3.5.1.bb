LICENSE = "GPL"
DESCRIPTION = "lftp is a sophisticated command line based file \
transfer program. Supported protocols include FTP, HTTP, \
and FISH."
HOMEPAGE = "http://lftp.yar.ru"
SECTION = "console/network"
DEPENDS = "readline gnutls"

SRC_URI = "ftp://ftp.wiretapped.net/pub/mirrors/lftp/old/lftp-3.5.1.tar.bz2"

EXTRA_OECONF = "--disable-largefile --disable-rpath --with-included-readline=no"

do_configure_prepend () {
    rm ${S}/m4/iconv.m4
}

inherit autotools gettext
