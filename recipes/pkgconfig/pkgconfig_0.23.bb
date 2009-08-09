require pkgconfig.inc

PR = "${INC_PR}.3"

DEPENDS += "glib-2.0"
EXTRA_OECONF = "--with-installed-glib"
