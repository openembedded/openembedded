DESCRIPTION = "SHR Phone UI Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib libphone-ui sqlite3"
PV = "0.0.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/phoneuid.git;protocol=http;branch=master"
S = "${WORKDIR}/${PN}"

inherit autotools


do_install_append() {
        install -d ${D}${sysconfdir}/dbus-1/session.d/
	install -d ${D}${datadir}/dbus-1/services/
        install -m 0644 ${S}/data/phoneuid.conf ${D}${sysconfdir}/dbus-1/session.d/
	install -m 0644 ${S}/data/phoneuid-*.service ${D}${datadir}/dbus-1/services/
}

FILES_${PN} += "${datadir} ${sysconfdir}"

