DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "gtk+ cairo libxrender gtk-doc"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/${PN}"
PV = "0.114+svn${SRCDATE}"

inherit gpe autotools pkgconfig

SRC_URI = "${GPE_SVN}"

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	autotools_stage_all
}
