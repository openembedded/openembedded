DESCRIPTION = "GLib is a general-purpose utility library, \
which provides many useful data types, macros, \
type conversions, string utilities, file utilities, a main \
loop abstraction, and so on. It works on many \
UNIX-like platforms, Windows, OS/2 and BeOS."
LICENSE = "LGPLv2+"
SECTION = "libs"
PRIORITY = "optional"
PR = "r1"
DEPENDS = "glib-2.0-native gtk-doc zlib"
DEPENDS_virtclass-native = "gettext-native gtk-doc-native \
                            pkgconfig-native"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.28/glib-${PV}.tar.bz2;name=archive \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch \
  file://g_once_init_enter.patch \
  file://gatomic-proper-pointer-get-cast.patch \
  file://60_wait-longer-for-threads-to-die.patch \
  file://glib-mkenums-interpreter.patch \
  file://libglib2-fix-compilation-with-no-builtin-atomic.patch \
  file://configure-ipv6.patch \
"

SRC_URI[archive.md5sum] = "51dbe36bc03a29a1f9bf6b74fb4a6926"
SRC_URI[archive.sha256sum] = "0605f538e5c022c237c97a34496979ba71d33c7b10b8d8edb84435498a651fb3"

inherit autotools gettext

S = "${WORKDIR}/glib-${PV}"

EXTRA_OECONF = "--disable-debug "

# Add and entry for your favourite arch if your (g)libc has a sane printf
EXTRA_OECONF_append_glibc_arm = "  --enable-included-printf=no "

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/glibconfig-sysdefs.h .
	sed -i -e "s:TEST_PROGS += gdbus-serialization::g"  ${S}/gio/tests/Makefile.am
}

do_install_append() {
	sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g ${D}${bindir}/glib-mkenums || true
}

EXTRA_OECONF_virtclass-native = ""

do_configure_prepend_virtclass-native() {
    if [ -e ${S}/${TARGET_SYS}-libtool ] ; then
                echo "${TARGET_SYS}-libtool already present"
    else
        cp ${STAGING_BINDIR}/${TARGET_SYS}-libtool ${S}
    fi

}

BBCLASSEXTEND = "native"

PACKAGES =+ "gobject-2.0 gmodule-2.0 gthread-2.0 gio-2.0 glib-2.0-utils "
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
