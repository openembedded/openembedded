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

inherit autotools pkgconfig

EXTRA_OECONF += "--with-no-runtime-deps-check"

do_configure_prepend() {
    sed -i "s/py_prefix=.*$/py_prefix=\"${@"${STAGING_DIR_TARGET}".replace("/","\/")}\/usr\"/" ${S}/acinclude.m4
    sed -i "s/py_exec_prefix=.*$/py_exec_prefix=\"${@"${STAGING_DIR_TARGET}".replace("/","\/")}\/usr\"/" ${S}/acinclude.m4
}

FILES_${PN}-dbg += "${libdir}/python2.6/site-packages/.debug"
FILES_${PN} += "${libdir} ${datadir}"

BLUEZ_LIBS = "-L${libdir} -lbluetooth"
BLUEZ_CFLAGS = "-I${includedir}"
