MAINTAINER = "Rene Wagner <rw@handhelds.org>"

PV = "1.1.4+cvs${CVSDATE}"
SRC_URI = "cvs://readonly:readonly@cvs.kaffe.org/cvs/kaffe;module=kaffe"
S = "${WORKDIR}/kaffe"

include kaffe.inc

DEPENDS += "glib-2.0 gmp gtk+ libart-lgpl pango zlib kaffeh-native"

EXTRA_OECONF += ""
