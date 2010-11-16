DESCRIPTION = "C++ bindings for the GTK+ toolkit."
HOMEPAGE = "http://www.gtkmm.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "atk glibmm gtk+ cairomm"

inherit gnome autotools pkgconfig flow-lossage

INC_PR = "r2"

LIBV = "2.4.0"

do_install_append () {
        install -d ${D}${includedir}/gtkmm-2.4
        install -m 0644 gdk/gdkmmconfig.h ${D}${includedir}/gtkmm-2.4
        install -m 0644 gtk/gtkmmconfig.h ${D}${includedir}/gtkmm-2.4
}

PACKAGES =+ "${PN}-demo"

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/*/include ${libdir}/*/proc/m4"
FILES_${PN}-demo += "${datadir}/*/demo/"
