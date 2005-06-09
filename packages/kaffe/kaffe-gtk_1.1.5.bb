MAINTAINER = "Rene Wagner <rw@handhelds.org>"

SRC_URI = "http://www.kaffe.org/ftp/pub/kaffe/v1.1.x-development/kaffe-${PV}.tar.gz"
S = "${WORKDIR}/kaffe-${PV}"

include kaffe.inc

DEPENDS += "glib-2.0 gmp gtk+ libart-lgpl pango zlib xtst kaffeh-native"

EXTRA_OECONF += ""
