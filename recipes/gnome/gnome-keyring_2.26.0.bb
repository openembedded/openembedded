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
