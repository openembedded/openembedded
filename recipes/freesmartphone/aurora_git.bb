DESCRIPTION = "Aurora is the new phone UI for the FreeSmartphone framework. It is \
clean and simple and is build on top of the powerful Declarative component of the Qt framework."
AUTHOR = "Simon Busch <morphis@gravedo.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "fso"
LICENSE = "GPLv2"
SRCREV = "a659aabe331ec2cf94753da9789b7a5b933bcafa"
PV = "0.1.0+gitr${SRCPV}"
PR = "r7"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/aurora.git;protocol=git;branch=master \
  file://aurora-daemon \
  file://aurora-systemmanager \
"
S = "${WORKDIR}/git/aurora"

DEPENDS = " \
  python \
  libfsobasics \
  libfso-glib \
"

RDEPENDS_${PN} = "\
  python-logging \
  python-textutils \
  python-dbus \
  python-pyside-embedded \
  python-pygobject \
  python-phoneutils \
"

inherit autotools python-dir update-rc.d vala

QT_DIR_NAME = "qtopia"
EXTRA_OECONF_append = "--enable-qws-support --with-qt-basedir=${QT_DIR_NAME}"

INITSCRIPT_PACKAGES = "${PN} ${PN}-systemmanager"

INITSCRIPT_NAME_${PN} = "aurora-daemon"
INITSCRIPT_PARAMS_${PN} = "defaults 90"

INITSCRIPT_NAME_${PN}-systemmanager = "aurora-systemmanager"
INITSCRIPT_PARAMS_${PN}-systemmanager = "defaults 85"

do_install_append() {
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME_${PN}} ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME_${PN}-systemmanager} ${D}${sysconfdir}/init.d/
}

PACKAGES = "${PN}-dbg ${PN}"

FILES_${PN}-dbg += "${libdir}/${QT_DIR_NAME}/imports/Aurora/*/.debug"

FILES_${PN} += " \
  ${PYTHON_SITEPACKAGES_DIR}/aurora \
  ${libdir}/${QT_DIR_NAME}/imports/Aurora \
"
