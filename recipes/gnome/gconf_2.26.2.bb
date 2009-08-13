DESCRIPTION = "GNOME configuration database system"
SECTION = "x11/gnome"
LICENSE = "LGPL"
DEPENDS = "orbit2 glib-2.0 libxml2 policykit"
ORBIT_IDL_SRC = "${STAGING_BINDIR_NATIVE}/orbit-idl-2"
PR = "r1"

S = "${WORKDIR}/GConf-${PV}"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/GConf/2.26/GConf-${PV}.tar.bz2 \
           file://org.gnome.GConf.service \
           file://org.gnome.GConf.Defaults.service \
          "

EXTRA_OECONF = "--disable-gtk-doc"
HEADERS = "gconf.h gconf-changeset.h gconf-listeners.h gconf-schema.h gconf-value.h gconf-error.h gconf-engine.h gconf-client.h gconf-enum-types.h"

inherit autotools pkgconfig gettext

do_compile() {
	oe_runmake ORBIT_IDL="${ORBIT_IDL_SRC}"
}

do_stage() {
	oe_libinstall -so -C gconf libgconf-2 ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/gconf/2/gconf/
	( cd gconf; for i in ${HEADERS}; do install -m 0644 $i ${STAGING_INCDIR}/gconf/2/gconf/$i; done )
	install -m 0644 gconf-2.m4 ${STAGING_DATADIR}/aclocal/gconf-2.m4
}

do_install() {
	oe_runmake ORBIT_IDL="${ORBIT_IDL_SRC}" DESTDIR="${D}" install

	install -d ${D}/${datadir}/dbus-1/services/
	install -m 0644 ${WORKDIR}/org.gnome.GConf.service		${D}/${datadir}/dbus-1/services/

	install -d ${D}/${datadir}/dbus-1/system-services/
	install -m 0644 ${WORKDIR}/org.gnome.GConf.Defaults.service	${D}/${datadir}/dbus-1/system-services/

	# this directory need to be created to avoid an Error 256 at gdm launch	
	install -d ${D}/${sysconfdir}/gconf/gconf.xml.system
}

FILES_${PN} += "${libdir}/GConf/* \
		${datadir}/dbus-1/services \
		${datadir}/dbus-1/system-services \
               "

FILES_${PN}-dbg += "${libdir}/*/*/.debug"
FILES_${PN}-dev += "${libdir}/GConf/2/*.la ${datadir}/sgml/gconf/gconf-1.0.dtd"

