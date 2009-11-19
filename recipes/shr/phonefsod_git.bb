DESCRIPTION = "SHR Phone FSO Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib sqlite3 shr-specs"
PV = "0.0.0+gitr${SRCREV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/phonefsod.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "phonefsod"
INITSCRIPT_PARAMS = "defaults 75"

EXTRA_OECONF = "\
	SPECS_PATH=${STAGING_DATADIR}/shr-specs \
"


do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
        install -d ${D}${sysconfdir}/dbus-1/system.d/
	install -m 0755 ${S}/data/phonefsod.init ${D}${sysconfdir}/init.d/phonefsod
        install -m 0644 ${S}/data/phonefsod.conf ${D}${sysconfdir}/dbus-1/system.d/
	install -m 0644 ${S}/data/etc-phonefsod.conf ${D}${sysconfdir}/phonefsod.conf
}

FILES_${PN} += "${datadir} ${sysconfdir}"

