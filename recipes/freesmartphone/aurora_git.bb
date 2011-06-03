DESCRIPTION = "Aurora is the new phone UI for the FreeSmartphone framework. It is \
clean and simple and is build on top of the powerful Declarative component of the Qt framework."
AUTHOR = "Simon Busch <morphis@gravedo.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "fso"
LICENSE = "GPLv2"
SRCREV = "1043282ce2c9e7c8378c3ab6477e146cfe507577"
PV = "0.1.0+gitr${SRCPV}"
PR = "r6"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/aurora.git;protocol=git;branch=master \
  file://aurora-daemon \
"
S = "${WORKDIR}/git/aurora"

DEPENDS = "shiboken-native libshiboken python"

RDEPENDS_${PN} = "\
  python-logging \
  python-textutils \
  python-dbus \
  python-pyside-embedded \
  python-pygobject \
  python-phoneutils \
"

inherit autotools python-dir update-rc.d

QT_DIR_NAME = "qtopia"
EXTRA_OECONF_append = "--enable-qws-support --with-qt-basedir=${QT_DIR_NAME}"

INITSCRIPT_NAME = "aurora-daemon"
INITSCRIPT_PARAMS = "defaults 90"

do_install_append() {
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
}

PACKAGES = "${PN}-dbg ${PN}"
FILES_${PN}-dbg += "${libdir}/${QT_DIR_NAME}/imports/Aurora/*/.debug"
FILES_${PN} += " \
  ${PYTHON_SITEPACKAGES_DIR}/aurora \
  ${libdir}/${QT_DIR_NAME}/imports/Aurora \
"
