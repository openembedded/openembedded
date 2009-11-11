DESCRIPTION = "Ophonekitd daemon - Vala rewrite"
SECTION = "x11/applications"
DEPENDS = "vala-dbus-binding-tool-native libgee libmodulo dbus-glib libfso-glib libframeworkd-phonegui sqlite3"
PV = "0.0.1+gitr${SRCPV}"
PR = "r1"

inherit pkgconfig autotools autotools_stage vala girepository

SRC_URI = "git://git.shr-project.org/repo/ophonekitd.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

do_install_append() {
        install -d ${D}${sysconfdir}/X11/Xsession.d/
        install -d ${D}${sysconfdir}/dbus-1/system.d/
        install -d ${D}${datadir}/ophonekitd/
        install -d ${D}${localstatedir}/db
        install -m 0755 ${S}/data/80ophonekitd ${D}${sysconfdir}/X11/Xsession.d/
        install -m 0755 ${S}/data/ophonekitd.conf ${D}${sysconfdir}/dbus-1/system.d/
        install -m 0755 ${S}/data/ophonekitd-default.conf ${D}${datadir}/ophonekitd/
        install -m 0755 ${S}/data/phonelog-database.sql ${D}${datadir}/ophonekitd/
}

FILES_${PN} += "${datadir} ${sysconfdir}"
