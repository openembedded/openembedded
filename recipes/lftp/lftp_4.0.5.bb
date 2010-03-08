LICENSE = "GPL"
DESCRIPTION = "lftp is a sophisticated command line based file \
transfer program. Supported protocols include FTP, HTTP, \
and FISH."
HOMEPAGE = "http://lftp.yar.ru"
SECTION = "console/network"
DEPENDS = "readline gnutls"

SRC_URI = "http://ftp.yars.free.net/pub/source/lftp/lftp-${PV}.tar.bz2;name=u1"

EXTRA_OECONF = "--disable-largefile --disable-rpath --with-included-readline=no"

do_configure_prepend () {
    rm ${S}/m4/iconv.m4
}

inherit autotools gettext

SRC_URI[u1.md5sum] = "5400cad5f91e131ac2ded7c24aea594c"
SRC_URI[u1.sha256sum] = "5c1f94f5780ed3cb51fe00439fbfa4e8b4bd28564c3248cb21f6ee9fd794c473"
