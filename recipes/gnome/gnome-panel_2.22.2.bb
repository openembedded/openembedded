LICENSE = "GPL"
DEPENDS = "librsvg libgweather startup-notification libwnck orbit2 gtk+ libgnome libgnomeui gnome-desktop libglade gnome-menus orbit2-native"

inherit gnome pkgconfig

do_configure_prepend() {
        sed -i -e s:help:: ${S}/Makefile.am
}


PACKAGES =+ "libpanel-applet"
FILES_libpanel-applet = "${libdir}/libpanel-applet-2.so.*"

FILES_${PN} =+ "${datadir}/gnome* \
                ${datadir}/icons"

EXTRA_OEMAKE = "ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2"

SRC_URI[archive.md5sum] = "3d8aab9d476a593e731afcd60272454a"
SRC_URI[archive.sha256sum] = "e1ecc0ddc5a09481deb2daa1f30fa14472bfed541db46bb4f49f3d0d728b0a45"
