DESCRIPTION = "GLib is a general-purpose utility library, \
which provides many useful data types, macros, \
type conversions, string utilities, file utilities, a main \
loop abstraction, and so on. It works on many \
UNIX-like platforms, Windows, OS/2 and BeOS."
LICENSE = "LGPLv2"
SECTION = "libs"
PRIORITY = "optional"
PACKAGES =+ "gobject-2.0 gmodule-2.0 gthread-2.0 gio-2.0 glib-2.0-utils "

LEAD_SONAME = "libglib-2.0.*"
FILES_glib-2.0-utils = "${bindir}/*"
FILES_${PN} = "${libdir}/lib*so.* ${libdir}/gio/modules/*.so"
FILES_${PN}-dev += "${libdir}/glib-2.0 ${datadir}/glib-2.0 ${libdir}/gio/modules/*.la ${libdir}/gdbus-codegen/*.py"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug"
FILES_gmodule-2.0 = "${libdir}/libgmodule-2.0.so.*"
FILES_gobject-2.0 = "${libdir}/libgobject-2.0.so.*"
FILES_gio-2.0 = "${libdir}/libgio-2.0.so.*"
FILES_gthread-2.0 = "${libdir}/libgthread-2.0.so.*"

EXTRA_OECONF = "--disable-debug "

# Add and entry for your favourite arch if your (g)libc has a sane printf
EXTRA_OECONF_append_glibc_arm = "  --enable-included-printf=no "

inherit autotools pkgconfig gettext

require glib-2.0.inc

acpaths = ""

do_install_append() {
        sed -i -e s:${STAGING_BINDIR_NATIVE}:${bindir}:g ${D}${bindir}/glib-mkenums || true
}

PE = "1"
PR = "r1"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"

DEPENDS = "glib-2.0-native gtk-doc zlib libffi"
# needed for gdbus-codegen
RDEPENDS_${PN} = "python-argparse"
RREPLACES_${PN} = "gdbus-binding-tool"
RCONFLICTS_${PN} = "gdbus-binding-tool"
DEPENDS_virtclass-native = "gettext-native gtk-doc-native \
                            pkgconfig-native python-argparse-native libffi-native"

SRC_URI = "git://git.gnome.org/glib;protocol=git;branch=master \
           file://configure-libtool.patch \
           file://60_wait-longer-for-threads-to-die.patch \
           file://g_once_init_enter.patch \
           file://remove.test.for.qsort_r.patch \
          "
SRCREV = "d97cbc6731deab137770bc0fe9c69b06f689f5b4"
PV = "2.29.3"
PR_append = "+gitr${SRCPV}"
S = "${WORKDIR}/git"

# Only apply this patch for target recipe on uclibc
SRC_URI_append_libc-uclibc = " ${@['', 'file://no-iconv.patch']['${PN}' == '${BPN}']}"

SRC_URI_append_virtclass-native = " file://glib-gettextize-dir.patch"
BBCLASSEXTEND = "native"

do_configure_prepend() {
  # missing ${topdir}/gtk-doc.make and --disable-gtk-doc* is not enough, because it calls gtkdocize (not provided by gtk-doc-native)
  sed -i '/^docs/d' ${S}/configure.ac
  sed -i 's/SUBDIRS = . m4macros glib gmodule gthread gobject gio tests po docs/SUBDIRS = . m4macros glib gmodule gthread gobject gio tests po/g' ${S}/Makefile.am
  sed -i -e "s:TEST_PROGS += gdbus-serialization::g"  ${S}/gio/tests/Makefile.am
}
