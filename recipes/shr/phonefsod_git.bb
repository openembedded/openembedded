DESCRIPTION = "SHR Phone FSO Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib libframeworkd-phonegui sqlite3"
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
        install -d ${D}${datadir}/ophonekitd/
        install -d ${D}${localstatedir}/db
	install -m 0755 ${S}/data/ophonekitd.init ${D}${sysconfdir}/init.d/ophonekitd
        install -m 0644 ${S}/data/ophonekitd.conf ${D}${sysconfdir}/dbus-1/system.d/
	install -m 0644 ${S}/data/etc-ophonekitd.conf ${D}${sysconfdir}/ophonekitd.conf
        install -m 0644 ${S}/data/80phoneuid ${D}${sysconfdir}/X11/Xsession.d/
}

FILES_${PN} += "${datadir} ${sysconfdir}"

