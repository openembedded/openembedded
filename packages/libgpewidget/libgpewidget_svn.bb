DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "gtk+ cairo libxrender gtk-doc"


LICENSE = "LGPL"
DEFAULT_PREFERENCE = "-1"

S =  "${WORKDIR}/${PN}"
PV = "0.114+svn${SRCDATE}"
PR = "r0"

inherit gpe autotools pkgconfig

SRC_URI = "${GPE_SVN}"

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	autotools_stage_all
}
