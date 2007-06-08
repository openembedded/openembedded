DESCRIPTION = "Sync daemon for GPE and OpenSync"
LICENSE = "GPL"
DEPENDS = "gtk+ glib-2.0 libgpewidget"

DEFAULT_PREFERENCE = "-1"

PV = "0.2+svn${SRCDATE}"
PR = "r0"

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

inherit autotools

