require pkgconfig.inc

PR = "${INC_PR}.1"

DEPENDS += "glib-2.0"
EXTRA_OECONF = "--with-installed-glib"
