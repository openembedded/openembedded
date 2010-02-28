DESCRIPTION = "GNOME configuration database system"
SECTION = "x11/gnome"
LICENSE = "LGPL"
DEPENDS = "gtk+ orbit2 glib-2.0 libxml2 policykit"
ORBIT_IDL_SRC = "${STAGING_BINDIR_NATIVE}/orbit-idl-2"
PR = "r3"

S = "${WORKDIR}/GConf-${PV}"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/GConf/2.26/GConf-${PV}.tar.bz2"

EXTRA_OECONF = "--disable-gtk-doc --enable-gtk POLKIT_POLICY_FILE_VALIDATE=true"

inherit autotools gettext

EXTRA_OEMAKE = 'ORBIT_IDL="${ORBIT_IDL_SRC}"'

do_install_append() {
	# this directory need to be created to avoid an Error 256 at gdm launch
	install -d ${D}${sysconfdir}/gconf/gconf.xml.system

	# this stuff is unusable
	rm ${D}${libdir}/GConf/*/*.*a
}

FILES_${PN} += "${libdir}/GConf/* \
		${datadir}/PolicyKit/policy/*.policy \
		${datadir}/dbus-1/services/*.service \
		${datadir}/dbus-1/system-services/*.service \
"

FILES_${PN}-dbg += "${libdir}/*/*/.debug"
FILES_${PN}-dev += "${datadir}/sgml/gconf/gconf-1.0.dtd"
