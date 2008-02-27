DESCRIPTION = "C++ bindings for the GTK+ toolkit."
HOMEPAGE = "http://www.gtkmm.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "atk glibmm gtk+ cairomm"

inherit gnome autotools pkgconfig flow-lossage

LIBV = "2.4.0"

do_stage () {
        autotools_stage_all

        install -d ${STAGING_INCDIR}/gtkmm-2.4
        install -m 0644 gdk/gdkmmconfig.h ${STAGING_INCDIR}/gtkmm-2.4
        install -m 0644 gtk/gtkmmconfig.h ${STAGING_INCDIR}/gtkmm-2.4
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/*/include ${libdir}/*/proc/m4"
