DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ cairo libxrender gtk-doc"


LICENSE = "LGPL"
DEFAULT_PREFERENCE = "-1"

S =  "${WORKDIR}/${PN}"
PV = "0.109+cvs${SRCDATE}"
PR = "r0"

inherit gpe autotools pkgconfig

SRC_URI = "${HANDHELDS_CVS};module=gpe/base/${PN}"

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	autotools_stage_all
}
