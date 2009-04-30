DESCRIPTION = "The GNOME Settings daemon using DBUS for communication."
DEPENDS = "intltool-native virtual/libintl glib-2.0 dbus dbus-glib libxml2 popt gtk-doc-native"
LICENSE = "GPL"
SECTION = "x11/utils"
PROVIDES = "gconf"
RPROVIDES_${PN} = "gconf"
RPROVIDES_${PN}-dev = "gconf-dev"
PV = "2.16.0+svnr${SRCPV}"
PR = "r0"

inherit autotools pkgconfig

SRC_URI = "svn://developer.imendio.com/svn/gconf-dbus;module=trunk;proto=http \
	file://69gconfd-dbus"
S = "${WORKDIR}/trunk"

PARALLEL_MAKE = ""

EXTRA_OECONF = "--with-ipc=dbus --disable-gtk-doc --disable-gtk --enable-shared --disable-static"

do_configure_prepend() {
	touch gtk-doc.make
}

do_stage() {
	autotools_stage_all
	install -m 0644 gconf-2.m4 ${STAGING_DATADIR}/aclocal/gconf-2.m4
}

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/69gconfd-dbus ${D}/${sysconfdir}/X11/Xsession.d/
}

FILES_${PN} = "${libdir}/GConf-dbus/2/*.so ${libdir}/dbus-1.0 ${sysconfdir} ${datadir}/dbus* ${libdir}/*.so.* ${bindir}/* ${libexecdir}/*"
FILES_${PN}-dbg += " ${libdir}/GConf-dbus/2/.debug"
FILES_${PN}-dev += "${libdir}/GConf-dbus/2/*.la ${datadir}/sgml/gconf/gconf-1.0.dtd"

