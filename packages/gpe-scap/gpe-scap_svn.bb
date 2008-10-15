DEPENDS = "glib-2.0 gtk+ libgpewidget libglade libsoup"
RREPLACES = "gpe-screenshot"
PV = "1.2+svn-${SRCDATE}"
PR = "r1"

inherit autotools 

SRC_URI += "${GPE_EXTRA_SVN}"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
