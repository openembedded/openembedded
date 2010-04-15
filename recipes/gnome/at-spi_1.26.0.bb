DESCRIPTION = "Assistive Technology Service Provider Interface for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "gtk+ atk libbonobo orbit2"
RDEPENDS_${PN} = "libgail-gnome gtk-module-gail"

inherit gnome

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



SRC_URI[archive.md5sum] = "3f2f7d29b45eff08adf56af0d31d3984"
SRC_URI[archive.sha256sum] = "bb8c9473a277fa75f172fa16fb6ada85f4a919219818fd9c792f1a137bb2644d"
