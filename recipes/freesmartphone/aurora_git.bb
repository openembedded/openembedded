DESCRIPTION = "Aurora is the new phone UI for the FreeSmartphone framework. It is \
clean and simple and is build on top of the powerful Declarative component of the Qt framework."
AUTHOR = "Simon Busch <morphis@gravedo.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "fso"
LICENSE = "GPLv2"
SRCREV = "6db9e04728bd0434e6b79939ee18be43017afeef"
PV = "0.1.0+gitr${SRCPV}"
PR = "r1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/aurora.git;protocol=git;branch=master \
  file://aurora-daemon \
"
S = "${WORKDIR}/git/aurora"

RDEPENDS_${PN} = "\
  python-logging \
  python-textutils \
  python-dbus \
  python-pyside-embedded \
  python-pygobject \
  python-phoneutils \
"

inherit autotools python-dir update-rc.d

INITSCRIPT_NAME = "aurora-daemon"
INITSCRIPT_PARAMS = "defaults 90"

do_install_append() {
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
}

PACKAGES = "${PN}"
FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}/aurora"
