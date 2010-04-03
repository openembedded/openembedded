DESCRIPTION = "GNOME panel"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gconf librsvg libgweather startup-notification libwnck orbit2 gtk+ libbonoboui libglade libgnome libgnomeui gnome-desktop libglade gnome-menus orbit2-native"

inherit gnome pkgconfig

SRC_URI += "file://idl-sysroot.patch;patch=1"

SRC_URI[archive.md5sum] = "e17f25417b2c9011ed1c3ebd75706de6"
SRC_URI[archive.sha256sum] = "7e8f99d3105bc0dda038b5859ab56d0a9740e244d7853786f1deb2df0a692220"

CPPFLAGS += " -I${STAGING_INCDIR}/gnome-desktop-2.0" 
export SYSROOT = "${STAGING_DIR_HOST}"

EXTRA_OEMAKE = "ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2 SYSROOT=${SYSROOT}"
EXTRA_OECONF = "--disable-scrollkeeper --disable-eds"

do_configure_prepend() {
        sed -i -e s:help:: ${S}/Makefile.am
}

pkg_postinst_append () {
	gconftool-2 --config-source=xml:readwrite:/etc/gconf/gconf.xml.defaults \
		--direct --load /etc/gconf/schemas/panel-default-setup.entries
}

PACKAGES =+ "libpanel-applet"
FILES_libpanel-applet = "${libdir}/libpanel-applet-2.so.*"

FILES_${PN} =+ "${datadir}/gnome* \
                ${datadir}/dbus-1 \
                ${datadir}/icons \
                ${datadir}/PolicyKit \
                ${libdir}/bonobo \
               "


