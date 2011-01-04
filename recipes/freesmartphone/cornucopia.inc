DESCRIPTION = "The freesmartphone.org API reference implementation (FSO 2.0)"
AUTHOR = "Team FSO"
HOMEPAGE = "http://www.freesmartphone.org"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "vala-native glib-2.0 libfso-glib libgee"
DEPENDS += "${@['libfsoframework', ''][(bb.data.getVar('PN', d, 1) in 'libfsoframework libfsobasics'.split())]}"
PV = "invalid, please override"

FSO_CORNUCOPIA_SRCREV ?= "8a91d752e28974dbfe922fe5a4dbb64f871008b2"
INC_PR = "r4"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia;protocol=git;branch=master"
S = "${WORKDIR}/git/${PN}"

inherit autotools pkgconfig vala

FILES_${PN} += "\
  ${sysconfdir} \
  ${datadir}\${PN} \
  ${datadir}/dbus-1 \
  ${libdir}/cornucopia/modules/*/lib*.so \
"
FILES_${PN}-dev += "\
  ${libdir}/cornucopia/modules/*/lib*.la \
"
FILES_${PN}-dbg += "\
  ${libdir}/cornucopia/modules/*/.debug \
"
