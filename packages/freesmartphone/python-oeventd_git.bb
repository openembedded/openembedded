DESCRIPTION = "The Open Event Daemon Prototype in Python"
HOMEPAGE = "http://www.freesmartphone.org/mediawiki/index.php/Implementations/OpenEventDaemon"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPLv2"
PV = "0.0.0+gitr${SRCREV}"
PR = "r1"

inherit distutils update-rc.d

INITSCRIPT_NAME = "oeventd"
INITSCRIPT_PARAMS = "defaults 21"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/eventd.git;protocol=git;branch=master \
  file://oeventd \
"
S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/oeventd ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/dbus-1/system.d/
	mv -f ${D}${datadir}/etc/dbus-1/system.d/oeventd.conf ${D}${sysconfdir}/dbus-1/system.d/
}

RDEPENDS_${PN} += "\
  python-dbus \
  python-pygobject \
  python-syslog \
"

FILES_${PN} += "${sysconfdir}"
