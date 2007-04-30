SECTION = "x11/utils"
DEPENDS = "gtk+ glib-2.0 dbus dbus-glib libxml2 popt intltool-native"
DESCRIPTION = "Settings daemon using DBUS for communication."
LICENSE = "GPL"
PROVIDES = "gconf"
RPROVIDES_${PN} = "gconf"
RPROVIDES_${PN}-dev = "gconf-dev"

PV = "2.16.0+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://developer.imendio.com/svn/gconf-dbus;module=trunk;proto=http \
	   file://69gconfd-dbus"

inherit pkgconfig autotools
S = "${WORKDIR}/trunk"

PARALLEL_MAKE = ""

FILES_${PN} += " ${libdir}/gconf-dbus/2/*.so \
                 ${libdir}/GConf-dbus/2/*.so \
                 ${libdir}/dbus-1.0 \
		 ${sysconfdir} \
		 ${datadir}/dbus*"
FILES_${PN}-dbg += "${libdir}/gconf-dbus/2/.debug \
                    ${libdir}/GConf-dbus/2/.debug ""

EXTRA_OECONF = " --with-ipc=dbus --disable-gtk-doc --enable-gtk --host=${HOST_SYS} --enable-shared --disable-static"

do_configure_prepend() {
	touch ${S}/gtk-doc.make
}

do_stage() {
	autotools_stage_all
}

do_install_append () {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/69gconfd-dbus ${D}/${sysconfdir}/X11/Xsession.d/
	install -d ${D}/${datadir}/dbus-1.0/services/
	install -m 644  gconf/gconf.service ${D}${datadir}/dbus-1.0/services/
}

