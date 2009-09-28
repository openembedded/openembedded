DESCRIPTION = "Ophonekitd daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib libframeworkd-phonegui sqlite3"
PV = "0.0.2+gitr${SRCREV}"
PR = "r18"

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

inherit autotools

do_install_append() {
        install -d ${D}${sysconfdir}/X11/Xsession.d/
        install -d ${D}${sysconfdir}/dbus-1/system.d/
        install -d ${D}${datadir}/ophonekitd/
        install -d ${D}${localstatedir}/db
        install -m 0755 ${S}/data/80ophonekitd ${D}${sysconfdir}/X11/Xsession.d/
        install -m 0755 ${S}/data/ophonekitd.conf ${D}${sysconfdir}/dbus-1/system.d/
}

FILES_${PN} += "${datadir} ${sysconfdir}"

