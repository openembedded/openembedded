require pkgconfig.inc

PR = "${INC_PR}.3"

DEPENDS += "glib-2.0"
EXTRA_OECONF = "--with-installed-glib"

SRC_URI[md5sum] = "d922a88782b64441d06547632fd85744"
SRC_URI[sha256sum] = "08a0e072d6a05419a58124db864f0685e6ac96e71b2875bf15ac12714e983b53"
