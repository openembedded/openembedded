DESCRIPTION = "G(PE)^2 address book v2"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+ libgpephone dbus-glib libabenabler2 librecord2 libgemwidget"
PV = "0.0+svnr-${SRCREV}"
PR = "r0"
SRCREV = "1410"

inherit gpephone autotools

SRC_URI = ${GPEPHONE_SVN}

S = "${WORKDIR}/contact/trunk"


FILES_${PN} += "${datadir}"

DEFAULT_PREFERENCE = "-1"
