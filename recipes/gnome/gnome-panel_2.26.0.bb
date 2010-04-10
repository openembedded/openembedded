LICENSE = "GPL"
DEPENDS = "gconf librsvg libgweather startup-notification libwnck orbit2 gtk+ libbonoboui libglade libgnome libgnomeui gnome-desktop libglade gnome-menus orbit2-native"

inherit gnome pkgconfig

SRC_URI += "file://idl-sysroot.patch;patch=1"

do_configure_prepend() {
        sed -i -e s:help:: ${S}/Makefile.am
}


PACKAGES =+ "libpanel-applet"
FILES_libpanel-applet = "${libdir}/libpanel-applet-2.so.*"

FILES_${PN} =+ "${datadir}/gnome* \
                ${datadir}/icons"

export SYSROOT = "${STAGING_DIR_HOST}"
EXTRA_OEMAKE = "ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2 SYSROOT=${SYSROOT}"
EXTRA_OECONF = "--disable-scrollkeeper \
                --disable-eds \
               "

do_stage() {
        autotools_stage_all
}

SRC_URI[archive.md5sum] = "27965de9b12952b22b7e232af6acb0de"
SRC_URI[archive.sha256sum] = "e8e21b008d4afcebfc3241d0f91dd2dcc0b171b16f5675fc1b7ed699e79b56f3"
