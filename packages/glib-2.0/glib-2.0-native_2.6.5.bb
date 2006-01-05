DESCRIPTION = "GLib is a general-purpose utility library, \
which provides many useful data types, macros, \
type conversions, string utilities, file utilities, a main \
loop abstraction, and so on. It works on many \
UNIX-like platforms, Windows, OS/2 and BeOS."
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk-doc-native"
PR = "r2"

EXTRA_OECONF = "--disable-debug"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.6/glib-${PV}.tar.bz2 \
	   file://glib-gettextize-dir.patch;patch=1 \
           file://glibconfig-sysdefs.h"

S = "${WORKDIR}/glib-${PV}"

inherit autotools pkgconfig native gettext

acpaths = ""
do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glibconfig-sysdefs.h .
}

do_stage () {
	autotools_stage_all
	install -m 0755 gobject/glib-mkenums ${STAGING_BINDIR}/
	install -m 0755 gobject/.libs/glib-genmarshal ${STAGING_BINDIR}/
	install -m 0755 glib-gettextize ${STAGING_BINDIR}/
	install -m 0755 ${S}/glibconfig.h ${STAGING_INCDIR}/glib-2.0/glibconfig.h
}

do_install () {
	:
}
