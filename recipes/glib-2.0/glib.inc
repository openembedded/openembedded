DESCRIPTION = "GLib is a general-purpose utility library, \
which provides many useful data types, macros, \
type conversions, string utilities, file utilities, a main \
loop abstraction, and so on. It works on many \
UNIX-like platforms, Windows, OS/2 and BeOS."
LICENSE = "LGPL"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS += "glib-2.0-native gtk-doc"
DEPENDS += "virtual/libiconv virtual/libintl"
PACKAGES =+ "gobject-2.0 gmodule-2.0 gthread-2.0 gio-2.0 glib-2.0-utils "

INC_PR = "r6"

LEAD_SONAME = "libglib-2.0.*"
FILES_glib-2.0-utils = "${bindir}/*"
FILES_${PN} = "${libdir}/lib*so.* ${libdir}/gio/modules/*.so"
FILES_${PN}-dev += "${libdir}/glib-2.0 ${datadir}/glib-2.0 ${libdir}/gio/modules/*.la"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug"
FILES_gmodule-2.0 = "${libdir}/libgmodule-2.0.so.*"
FILES_gobject-2.0 = "${libdir}/libgobject-2.0.so.*"
FILES_gio-2.0 = "${libdir}/libgio-2.0.so.*"
FILES_gthread-2.0 = "${libdir}/libgthread-2.0.so.*"

# Let various glib components end up in glib package
# for compatibility (with binary packages from Maemo).
FILES_gthread-2.0_chinook-compat = ""
FILES_gmodule-2.0_chinook-compat = ""
FILES_gobject-2.0_chinook-compat = ""
FILES_gio-2.0_chinook-compat = ""
FILES_gthread-2.0_maemo5-compat = ""
FILES_gmodule-2.0_maemo5-compat = ""
FILES_gobject-2.0_maemo5-compat = ""
FILES_gio-2.0_maemo5-compat = ""

EXTRA_OECONF = "--disable-debug "

# Add and entry for your favourite arch if your (g)libc has a sane printf
EXTRA_OECONF_append_glibc_arm = "  --enable-included-printf=no "

S = "${WORKDIR}/glib-${PV}"

inherit autotools pkgconfig gettext

require glib-2.0.inc

acpaths = ""
do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glibconfig-sysdefs.h .
}

do_install_append() {
	sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g ${D}${bindir}/glib-mkenums || true
}

do_stage () {
	autotools_stage_all
	install -d ${STAGING_INCDIR}/glib-2.0/glib
	install -m 0755 ${S}/glibconfig.h ${STAGING_INCDIR}/glib-2.0/glibconfig.h
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 ${S}/m4macros/glib-2.0.m4 ${STAGING_DATADIR}/aclocal/glib-2.0.m4
	install -m 0644 ${S}/m4macros/glib-gettext.m4 ${STAGING_DATADIR}/aclocal/glib-gettext.m4
}
