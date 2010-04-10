DESCRIPTION = "GTK+ Bluetooth Manager, designed for common bluetooth tasks."
HOMEPAGE = "http://blueman-project.org/"
SECTION = "optional"

DEPENDS = "gtk+ glib-2.0 bluez4 intltool python \
           python-native python-pyrex \
           startup-notification \
"

RDEPENDS = "python-dbus python-pygobject python \
            dbus bluez4 python-pygtk obex-data-server \
"

PR = "r1"

SRC_URI = "http://download.tuxfamily.org/blueman/blueman-${PV}.tar.gz"

inherit autotools pkgconfig python-dir

EXTRA_OECONF += "--with-no-runtime-deps-check"

do_configure_prepend() {
    sed -i "s/py_prefix=.*$/py_prefix=\"${@"${STAGING_DIR_TARGET}".replace("/","\/")}\/usr\"/" ${S}/acinclude.m4
    sed -i "s/py_exec_prefix=.*$/py_exec_prefix=\"${@"${STAGING_DIR_TARGET}".replace("/","\/")}\/usr\"/" ${S}/acinclude.m4
}

FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/.debug"
FILES_${PN} += "${libdir} ${datadir}"

BLUEZ_LIBS = "-L${libdir} -lbluetooth"
BLUEZ_CFLAGS = "-I${includedir}"

SRC_URI[md5sum] = "26b70341b3d3da28da62c917c8b20377"
SRC_URI[sha256sum] = "86200dab50b1595c9a9537586c07de90ccfa084b954bb74f3e8732cc000fe3af"
