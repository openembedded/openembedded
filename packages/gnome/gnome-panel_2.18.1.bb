LICENSE = "GPL"
DEPENDS = "libwnck orbit2 gtk+ libgnome libgnomeui gnome-desktop libglade gnome-menus"

PR = "r1"

inherit gnome pkgconfig

do_configure_prepend() {
        sed -i -e s:help:: ${S}/Makefile.am
}


PACKAGES =+ "libpanel-applet"
FILES_libpanel-applet = "${libdir}/libpanel-applet-2.so.*"

FILES_${PN} =+ "${datadir}/gnome* \
                ${datadir}/icons"

do_stage() {
        autotools_stage_all
}
