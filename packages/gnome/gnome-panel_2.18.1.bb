LICENSE = "GPL"
DEPENDS = "startup-notification libwnck orbit2 gtk+ libgnome libgnomeui gnome-desktop libglade gnome-menus orbit2-native"

PR = "r1"

inherit gnome pkgconfig

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
