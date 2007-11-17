DEPENDS = "glib-2.0 gtk-doc-native"
DESCRIPTION = "An accessibility toolkit for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "LGPL"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-glibtest"

CFLAGS_append = " -I${STAGING_INCDIR}/glib-2.0 \
		  -I${STAGING_INCDIR}/glib-2.0/glib \
		  -I${STAGING_INCDIR}/glib-2.0/gobject"
