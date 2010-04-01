DESCRIPTION = "GLib 1.2 is a deprecated libray to \
provide support for old glib 1.2 based applications"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "glib-1.2-native"
PR = "r4"

LEAD_SONAME = "libglib-1.2.*"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/glib-1.2-${PV}"

EXTRA_OECONF = "--disable-debug"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v1.2/glib-${PV}.tar.gz \
           file://glibconfig-sysdefs.h \
	   file://depcomp \
	   file://glib-reconf-fix;patch=1 \
           file://posix-conf-changes;patch=1 \
           file://glib-config-use-pkg-config;patch=1 \
	   file://gcc-3.4-pretty_function;patch=1"

S = "${WORKDIR}/glib-${PV}"

inherit autotools pkgconfig binconfig

acpaths = ""
do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glibconfig-sysdefs.h .
	install -m 0644 ${WORKDIR}/depcomp .
	rm -f ltconfig acinclude.m4 libtool ltmain.sh
}

do_install_append () {
	install -d ${D}${includedir}/glib-1.2
	install -m 0644 glibconfig.h glib.h ${D}${includedir}/glib-1.2/
	install -d ${D}${datadir}/aclocal
	install -m 0644 ${S}/glib.m4 ${D}${datadir}/aclocal/glib-1.2.m4
}

FILES_${PN}-dev += "${libdir}/glib/include/glibconfig.h"
