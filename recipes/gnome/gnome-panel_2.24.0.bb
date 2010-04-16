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

SRC_URI[archive.md5sum] = "0d246880611a4c58fe2ff99614b96918"
SRC_URI[archive.sha256sum] = "6d6d0f013594f1d5f685bc9d35ad2c64d7817339a932d8e17eede5b8a3c8196a"
