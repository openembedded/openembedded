DESCRIPTION = "freesmartphone.org support library"
LICENSE = "GPL"
SECTION = "devel"
DEPENDS = "vala-native glib-2.0 dbus dbus-glib"
PV = "0.0.0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/cornucopia;protocol=git;branch=master \
"
S = "${WORKDIR}/git/libfsoframework"

inherit autotools_stage pkgconfig

FILES_${PN} += "${sysconfdir} ${datadir}"
# ship vapi files
FILES_${PN}-dev += "${datadir}/vala"
