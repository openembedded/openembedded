LICENSE = "LGPL"
DEPENDS = "libgnome"

inherit gnome

do_configure_prepend() {
        sed -i -e s:help:: ${S}/Makefile.am
}


PACKAGES =+ "libpanel-applet"
FILES_libpanel-applet = "${libdir}/libpanel-applet-2.so.*"

FILES_${PN} =+ "${datadir}/gnome* \
                ${datadir}/icons"

EXTRA_OEMAKE = "ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2"

do_stage() {
        autotools_stage_all
}

SRC_URI[archive.md5sum] = "151e03d925579241decc92afa4d07182"
SRC_URI[archive.sha256sum] = "d5a799e1d11cd91865cb716a11de970de97d7ef679684db0a893fc6a65a9acd0"
