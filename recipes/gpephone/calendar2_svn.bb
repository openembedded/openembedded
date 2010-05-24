DESCRIPTION = "Calendar application for GPE Phone Edition"
LICENSE     = "LiPS"
SECTION = "gpe"
PRIORITY    = "optional"
PV = "0.0+svnr-${SRCREV}"
PR          = "r1"

DEPENDS = "gtk+ libgpewidget libgpephone libgemwidget dbus-glib libcalenabler2 libiac"

inherit gpephone autotools

SRC_URI = "${GPEPHONE_SVN} \
           file://disable-broken-tests.patch"

S = ${WORKDIR}/${PN}

FILES_${PN} += "${datadir}/database ${datadir}/res"
