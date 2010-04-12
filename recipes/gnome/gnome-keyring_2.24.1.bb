LICENSE = "GPL"
SECTION = "x11/gnome"

inherit autotools gnome pkgconfig

PR = "r1"

DEPENDS = "gtk+ libtasn1 libgcrypt gconf"

EXTRA_OECONF = "--disable-gtk-doc"

SRC_URI += "file://tasn.m4 file://org.gnome.keyring.service"

do_configure_prepend() {
	cp ${WORKDIR}/tasn.m4 acinclude.m4
}

do_install_append () {
	install -d ${D}${datadir}/dbus-1/services
	install -m 0644 ${WORKDIR}/org.gnome.keyring.service ${D}${datadir}/dbus-1/services
}

FILES_${PN} += "${datadir}/dbus-1/services"

do_stage() {
        autotools_stage_all
}

SRC_URI[archive.md5sum] = "aa5552dc129f3509ee39145b7f0bf977"
SRC_URI[archive.sha256sum] = "3c9eb7f45dd0026340635b9e1ee18c36a47541610aa5a7ef604ca645aa4763f9"
