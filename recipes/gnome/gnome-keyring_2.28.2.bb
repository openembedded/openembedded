DESCRIPTION = "GNOME security credential management"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = " gtk+-native libpam gconf gtk+ libtasn1 libtasn1-native libgcrypt"

inherit gnome pkgconfig

EXTRA_OECONF = "--disable-gtk-doc --enable-pam --with-pam-dir=${libdir}/security/"

SRC_URI += "file://tasn.m4 file://org.gnome.keyring.service"

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

