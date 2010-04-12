
SRC_URI = "http://www.kaffe.org/ftp/pub/kaffe/v1.1.x-development/kaffe-${PV}.tar.gz"
S = "${WORKDIR}/kaffe-${PV}"

require kaffe.inc

DEPENDS += "glib-2.0 gmp gtk+ pango zlib libxtst kaffeh-native"

EXTRA_OECONF += ""

SRC_URI[md5sum] = "928c578d4808012fe5ba5587071d2aa2"
SRC_URI[sha256sum] = "f4ed45720d76f5182f2dede135c1856ad01bdf9875f54459b6baa1071af67280"
