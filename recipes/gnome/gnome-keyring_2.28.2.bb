DESCRIPTION = "GNOME security credential management"
LICENSE = "GPLv2+ LGPLv2+ LGPLv2.1+"
SECTION = "x11/gnome"
DEPENDS = " gtk+-native libpam gconf gtk+ libtasn1 libtasn1-native libgcrypt"
PR = "r2"

inherit gnome pkgconfig

EXTRA_OECONF = "--disable-gtk-doc --enable-pam --with-pam-dir=${libdir}/security"

SRC_URI += "file://tasn.m4 file://org.gnome.keyring.service file://libtool.workarround.patch"

do_configure_prepend() {
	cp ${WORKDIR}/tasn.m4 acinclude.m4
}

do_install_append () {
	install -d ${D}${datadir}/dbus-1/services
	install -m 0644 ${WORKDIR}/org.gnome.keyring.service ${D}${datadir}/dbus-1/services
}

FILES_${PN} += "${datadir}/dbus-1/services ${datadir}/gcr"
PACKAGES =+ "gnome-keyring-pam-plugin"
FILES_gnome-keyring-pam-plugin = "${libdir}/security/*.so"
FILES_${PN}-dbg += "${libdir}/gnome-keyring/*/.debug ${libdir}/security/.debug"


SRC_URI[archive.md5sum] = "97ea6823e88b39284187764c1ca95a59"
SRC_URI[archive.sha256sum] = "d2d686fb2528ee045bbcd9f18d0d452e0eb88c2265a1947f639152b61a5987f6"
