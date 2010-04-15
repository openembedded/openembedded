DESCRIPTION = "Assistive Technology Service Provider Interface for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "gtk+ atk libbonobo orbit2 orbit2-native"
RDEPENDS_${PN} = "libgail-gnome gtk-module-gail"

inherit gnome
SRC_URI[archive.md5sum] = "64c64cc00356bffe4e93382622402c1b"
SRC_URI[archive.sha256sum] = "b3119a6ffcdc8aa18244e964bb4acdf23c13e1815153dc85c69ba0567b68bddb"

do_configure_prepend () {
	sed -i "s|ORBIT_IDL=.*|ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2|" ${S}/configure.in
	sed -i "s|BONOBO_ACTIVATION_IDL_DIR=.*|BONOBO_ACTIVATION_IDL_DIR=${STAGING_DATADIR}/idl/bonobo-activation-2.0|" ${S}/configure.in
	sed -i "s|LIBBONOBO_IDL_DIR=.*|LIBBONOBO_IDL_DIR=${STAGING_DATADIR}/idl//bonobo-2.0|" ${S}/configure.in
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
