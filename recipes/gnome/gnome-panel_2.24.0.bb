LICENSE = "GPL"
DEPENDS = "librsvg libgweather startup-notification libwnck orbit2 gtk+ libgnome libgnomeui gnome-desktop libglade gnome-menus orbit2-native"

inherit gnome pkgconfig

SRC_URI += "file://scrollkeeper.patch;patch=1"

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
EXTRA_OECONF = "--disable-scrollkeeper"

do_stage() {
        autotools_stage_all
}
