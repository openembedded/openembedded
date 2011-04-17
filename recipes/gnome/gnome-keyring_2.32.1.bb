DESCRIPTION = "GNOME security credential management"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "libgnome-keyring gtk+-native libpam gconf gtk+ libtasn1 libtasn1-native libgcrypt"
RDEPENDS = "libgnome-keyring"
PR = "r1"

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

FILES_${PN} += "${datadir}/dbus-1/services ${datadir}/gcr ${datadir}/GConf/gsettings ${datadir}/glib-2.0/schemas"
FILES_${PN}-dbg += "${libdir}/gnome-keyring/*/.debug ${libdir}/security/.debug"

PACKAGES =+ "gnome-keyring-pam-plugin"
FILES_gnome-keyring-pam-plugin = "${libdir}/security/*.so"

SRC_URI[archive.md5sum] = "9a8aa74e03361676f29d6e73155786fc"
SRC_URI[archive.sha256sum] = "31fecec1430a97f59a6159a5a2ea8d6a1b44287f1e9e595b3594df46bf7f18f9"

