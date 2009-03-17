DESCRIPTION = "The C/Vala implementation of the freesmartphone.org framework APIs"
HOMEPAGE = "http://www.freesmartphone.org/"
AUTHOR = "Sudharshan S"
SECTION = "console/network"
DEPENDS = "dbus dbus-glib libnl vala-native"
# for pygobject-codegen
DEPENDS += "python-pygtk"
LICENSE = "LGPL"
PV = "0.1+gitr${SRCREV}"
PR = "r1"

inherit autotools pkgconfig update-rc.d distutils-base

EXTRA_OECONF = "--enable-python --with-python-includes=${STAGING_INCDIR}/.."

INITSCRIPT_NAME = "fsod"
INITSCRIPT_PARAMS = "defaults 21"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/openmoko-gsoc2008.git;protocol=git;branch=master \
  file://autofoo.patch;patch=1 \
#  file://fsod \
"
S = "${WORKDIR}/git/fsod"

do_install_append() {
#        install -d ${D}${sysconfdir}/init.d
#        install -m 0755 ${WORKDIR}/fsod ${D}${sysconfdir}/init.d/
}

RCONFLICTS_${PN} = "frameworkd"
RREPLACES_${PN} = "frameworkd"

FILES_${PN} += "${sysconfdir} ${datadir}"
FILES_${PN}-dbg += "\
  ${bindir}/.debug \
  ${libdir}/fsod/subsystems/.debug \
  ${libdir}/fsod/subsystems/*/.debug \
"
