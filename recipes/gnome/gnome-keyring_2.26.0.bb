LICENSE = "GPL"
SECTION = "x11/gnome"

inherit autotools gnome pkgconfig

DEPENDS = " libpam gconf gtk+ libtasn1 libtasn1-native libgcrypt"

EXTRA_OECONF = "--disable-gtk-doc"

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

do_stage() {
        autotools_stage_all
}

SRC_URI[archive.md5sum] = "0395fcf79b990465030a2795dcddacb9"
SRC_URI[archive.sha256sum] = "7acda11db2eb07b2f68a1a506203fe95141954acb10c394850418fd04ed80a07"
