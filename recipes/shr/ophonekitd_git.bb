DESCRIPTION = "Ophonekitd daemon"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib libframeworkd-phonegui sqlite3"
PV = "0.0.2+gitr${SRCPV}"
PR = "r16"

inherit shr autotools

do_install_append() {
        install -d ${D}${sysconfdir}/X11/Xsession.d/
        install -d ${D}${sysconfdir}/dbus-1/system.d/
        install -d ${D}${datadir}/ophonekitd/
        install -d ${D}${localstatedir}/db
        install -m 0755 ${S}/data/80ophonekitd ${D}${sysconfdir}/X11/Xsession.d/
        install -m 0755 ${S}/data/ophonekitd.conf ${D}${sysconfdir}/dbus-1/system.d/
        install -m 0755 ${S}/data/phonelog-database.sql ${D}${datadir}/ophonekitd/
}

FILES_${PN} += "${datadir} ${sysconfdir}"

