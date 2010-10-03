DESCRIPTION = "GLib 1.2 is a deprecated libray to \
provide support for old glib 1.2 based applications"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS += "glib-1.2-native"
DEPENDS_virtclass-native = ""
PR = "r5"

LEAD_SONAME = "libglib-1.2.*"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/glib-1.2-${PV}"

EXTRA_OECONF = "--disable-debug"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v1.2/glib-${PV}.tar.gz \
           file://glibconfig-sysdefs.h \
	   file://depcomp \
	   file://glib-reconf-fix;apply=yes \
           file://posix-conf-changes;apply=yes \
           file://glib-config-use-pkg-config;apply=yes \
	   file://gcc-3.4-pretty_function;apply=yes"

S = "${WORKDIR}/glib-${PV}"

inherit autotools pkgconfig binconfig gettext

acpaths = ""
do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glibconfig-sysdefs.h .
	install -m 0644 ${WORKDIR}/depcomp .
	rm -f ltconfig acinclude.m4 libtool ltmain.sh
}

do_install_virtclass-native () {
        oe_libinstall -so libglib ${D}${libdir}
        oe_libinstall -so -C gmodule libgmodule ${D}${libdir}
        oe_libinstall -so -C gthread libgthread ${D}${libdir}
        autotools_do_install
        install -d ${D}${includedir}/glib-1.2
        install -m 0644 glibconfig.h glib.h ${D}${includedir}/glib-1.2/
        install -d ${D}${datadir}/aclocal
        install -m 0644 ${S}/glib.m4 ${D}${datadir}/aclocal/glib-1.2.m4
}

do_install_append () {
	install -d ${D}${includedir}/glib-1.2
	install -m 0644 glibconfig.h glib.h ${D}${includedir}/glib-1.2/
	install -d ${D}${datadir}/aclocal
	install -m 0644 ${S}/glib.m4 ${D}${datadir}/aclocal/glib-1.2.m4
}

FILES_${PN}-dev += "${libdir}/glib/include/glibconfig.h"

SRC_URI[md5sum] = "6fe30dad87c77b91b632def29dd69ef9"
SRC_URI[sha256sum] = "6e1ce7eedae713b11db82f11434d455d8a1379f783a79812cd2e05fc024a8d9f"

BBCLASSEXTEND = "native"

NATIVE_INSTALL_WORKS = "1"
