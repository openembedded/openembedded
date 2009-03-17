DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "gtk+ cairo libxrender gtk-doc"
PV = "0.114+svn${SRCDATE}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

inherit gpe autotools pkgconfig

SRC_URI = "${GPE_SVN}"
S = "${WORKDIR}/${PN}"

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	autotools_stage_all
}

RRECOMMENDS_${PN} = "gpe-icons"
