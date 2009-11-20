DESCRIPTION = "SHR Phone UI Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib libphone-ui sqlite3 shr-specs"
PV = "0.0.0+gitr${SRCREV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/phoneuid.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = "\
       SPECS_PATH=${STAGING_DATADIR}/shr-specs \
"


do_install_append() {
        install -d ${D}${sysconfdir}/dbus-1/system.d/
	install -d ${D}${datadir}/dbus-1/system-services/
	install -d ${D}${sysconfdir}/X11/Xsession.d/
        install -m 0644 ${S}/data/phoneuid.conf ${D}${sysconfdir}/dbus-1/system.d/
	install -m 0644 ${S}/data/phoneuid-*.service ${D}${datadir}/dbus-1/system-services/
	install -m 0755 ${S}/data/80phoneuid ${D}${sysconfdir}/X11/Xsession.d/
	install -m 0755 ${S}/data/phoneui-wrapper.sh ${D}${bindir}/phoneui-wrapper.sh
}

FILES_${PN} += "${datadir} ${sysconfdir}"

