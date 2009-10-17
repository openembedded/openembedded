DESCRIPTION = "SHR Phone FSO Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib sqlite3"
PV = "0.0.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/phonefsod.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "phonefsod"
INITSCRIPT_PARAMS = "defaults 75"


do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
        install -d ${D}${sysconfdir}/X11/Xsession.d/
        install -d ${D}${sysconfdir}/dbus-1/system.d/
        install -d ${D}${datadir}/phonefsod/
        install -d ${D}${localstatedir}/db
	install -m 0755 ${S}/data/phonefsod.init ${D}${sysconfdir}/init.d/phonefsod
        install -m 0644 ${S}/data/phonefsod.conf ${D}${sysconfdir}/dbus-1/system.d/
	install -m 0644 ${S}/data/etc-phonefsod.conf ${D}${sysconfdir}/phonefsod.conf
        install -m 0644 ${S}/data/80phoneuid ${D}${sysconfdir}/X11/Xsession.d/
}

FILES_${PN} += "${datadir} ${sysconfdir}"

