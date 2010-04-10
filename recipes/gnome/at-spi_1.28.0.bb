DESCRIPTION = "Assistive Technology Service Provider Interface for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "gtk+ atk libbonobo orbit2 orbit2-native"
RDEPENDS_${PN} = "libgail-gnome gtk-module-gail"

PR = "r1"

inherit gnome

do_configure_prepend () {
	sed -i "s|ORBIT_IDL=.*|ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2|" ${S}/configure.in
	sed -i "s|BONOBO_ACTIVATION_IDL_DIR=.*|BONOBO_ACTIVATION_IDL_DIR=${STAGING_DATADIR}/idl/bonobo-activation-2.0|" ${S}/configure.in
	sed -i "s|LIBBONOBO_IDL_DIR=.*|LIBBONOBO_IDL_DIR=${STAGING_DATADIR}/idl//bonobo-2.0|" ${S}/configure.in
}

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



SRC_URI[archive.md5sum] = "06f6da7873dffc8a26b04e304236e222"
SRC_URI[archive.sha256sum] = "ebe22221dc6a9852e6cf6c4d1e8d78bd19d0fda76a8eb8fc46655e9c9b096667"
