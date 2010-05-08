DESCRIPTION = "neon is an HTTP and WebDAV client library, with a C interface."
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "zlib libxml2 expat time gnutls"
PR = "r2"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.webdav.org/${PN}/${P}.tar.gz"

inherit autotools binconfig lib_package pkgconfig

EXTRA_OECONF = "--with-ssl=gnutls --with-libxml2 --with-expat --enable-shared"
EXTRA_AUTORECONF=" -I ${S}/macros "

SRC_URI[md5sum] = "ba1015b59c112d44d7797b62fe7bee51"
SRC_URI[sha256sum] = "849004a9f3cbb79706cd29461142868c25aceb44785eb81c78db0390e1372cb4"
