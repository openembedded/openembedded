DESCRIPTION = "Extended widget library for GPE phone environment."
LICENSE     = "LiPS"
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libiac libgpephone gnome-vfs libxdamage libxcomposite libgpewidget"
PV = "1.0+svnr-${SRCREV}"
PR          = "r0"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_SVN}"

S = ${WORKDIR}/${PN}

FILES_${PN} += "${datadir}/gem"

