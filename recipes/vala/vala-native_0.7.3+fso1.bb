require vala.inc
inherit native

VALA_FSO_RELEASE = "0.7.3-fso1"

DEPENDS = "glib-2.0-native"
PV = "0.7.2+${VALA_FSO_RELEASE}"

SRC_URI = "http://www.freesmartphone.org/sources/vala-${VALA_FSO_RELEASE}.tar.gz"
S = "${WORKDIR}/vala-${VALA_FSO_RELEASE}"
