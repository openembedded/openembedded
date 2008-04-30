DESCRIPTION = "The Open Device Daemon Prototype in Python"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPLv2"
PV = "0.7.9+svnr${SRCREV}"
PR = "r0"

inherit distutils update-rc.d

INITSCRIPT_NAME = "odeviced"
INITSCRIPT_PARAMS = "defaults 20"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=py-odeviced \
           file://odeviced \
           file://odeviced.conf"
S = "${WORKDIR}/py-odeviced"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/odeviced ${D}${sysconfdir}/init.d/
	install -m 0644 ${WORKDIR}/odeviced.conf ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/dbus-1/system.d/
	mv -f ${D}${datadir}/etc/dbus-1/system.d/odeviced.conf ${D}${sysconfdir}/dbus-1/system.d/
}

RDEPENDS_${PN} += "\
  python-dbus \
  python-pygobject \
  python-pyrtc \
  python-syslog \
"

FILES_${PN} += "${sysconfdir}"
