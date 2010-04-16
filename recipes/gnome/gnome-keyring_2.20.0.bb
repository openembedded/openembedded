LICENSE = "GPL"
SECTION = "x11/gnome"

PR = "r3"

inherit autotools gnome pkgconfig

DEPENDS = "gtk+ libgcrypt"

EXTRA_OECONF = "--disable-gtk-doc"

SRC_URI += "file://org.gnome.keyring.service"

do_install_append () {
	install -d ${D}${datadir}/dbus-1/services
	install -m 0644 ${WORKDIR}/org.gnome.keyring.service ${D}${datadir}/dbus-1/services
}

FILES_${PN} += "${datadir}/dbus-1/services"

SRC_URI[archive.md5sum] = "effc946bf3fa05d70b1251801383efd2"
SRC_URI[archive.sha256sum] = "6fadcd85a16672381857de0e1cf2b6fe16ec3393931f92427deb13153eeabe1c"
