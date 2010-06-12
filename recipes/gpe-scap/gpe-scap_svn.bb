DEPENDS = "glib-2.0 gtk+ libgpewidget libglade libsoup"
RREPLACES_${PN} = "gpe-screenshot"
PV = "1.4+svn-${SRCDATE}"
PR = "r2"

inherit autotools 

SRC_URI += "${GPE_EXTRA_SVN}"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
