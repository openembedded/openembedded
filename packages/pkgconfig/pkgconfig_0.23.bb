require pkgconfig.inc

DEFAULT_PREFERENCE = "-1"

DEPENDS += "glib-2.0"
EXTRA_OECONF = "--with-installed-glib"
