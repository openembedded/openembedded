DESCRIPTION = "Assistive Technology Service Provider Interface for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "gtk+ atk libbonobo orbit2"
RDEPENDS_${PN} = "libgail-gnome gtk-module-gail"

inherit gnome

do_stage () {
	autotools_stage_all
}

FILES_${PN} += " \
                ${libdir}/bonobo \
                ${libdir}/gtk-2.0 \
                ${libdir}/orbit-2.0 \
                ${datadir}/idl \
               "

FILES_${PN}-dbg += " \
                ${libdir}/gtk-2.0/modules/.debug \
                ${libdir}/orbit-2.0/.debug \
               "


