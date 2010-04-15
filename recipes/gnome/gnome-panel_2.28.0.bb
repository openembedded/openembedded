DESCRIPTION = "GNOME panel"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "gconf librsvg libgweather startup-notification libwnck orbit2 gtk+ libbonoboui libglade libgnome libgnomeui gnome-desktop libglade gnome-menus orbit2-native"

PR = "r2"

inherit gnome pkgconfig

SRC_URI += "file://idl-sysroot.patch;patch=1"

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



SRC_URI[archive.md5sum] = "9f0ea283d44bbcce67dc2e8a02fe9fad"
SRC_URI[archive.sha256sum] = "c1168c0c8f84692002557d60870c782f4831635080d2c52cd2a3665fb7718465"
