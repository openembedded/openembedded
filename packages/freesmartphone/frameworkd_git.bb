DESCRIPTION = "The freesmartphone.org Framework Daemon"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de> et. al."
SECTION = "console/network"
DEPENDS = "python-cython-native python-pyrex-native"
LICENSE = "GPL"
PV = "0.8.1+gitr${SRCREV}"
PR = "r10"

inherit distutils update-rc.d

INITSCRIPT_NAME = "frameworkd"
INITSCRIPT_PARAMS = "defaults 29"

SRC_URI = "${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
           file://frameworkd \
           file://frameworkd.conf"
S = "${WORKDIR}/git"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/frameworkd ${D}${sysconfdir}/init.d/
	install -m 0644 ${WORKDIR}/frameworkd.conf ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/dbus-1/system.d/
	mv -f ${D}${datadir}/etc/dbus-1/system.d/frameworkd.conf ${D}${sysconfdir}/dbus-1/system.d/
}

RDEPENDS_${PN} += "\
  python-dbus \
  python-datetime \
  python-pygobject \
  python-pyrtc \
  python-pyserial \
  python-pyyaml \
  python-shell \
  python-syslog \
  \
  ${PN}-config \
"


PACKAGES =+ "${PN}-config"

PACKAGE_ARCH_${PN}-config = "${MACHINE_ARCH}"
FILES_${PN}-config = "${sysconfdir}"

PACKAGE_ARCH_${PN} = "${BASE_PACKAGE_ARCH}"
FILES_${PN} += "${datadir}"
FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/framework/subsystems/*/.debug"
