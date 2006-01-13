DESCRIPTION = "libgpewidget contains a collection of widgets and other common code shared by many GPE applications."
SECTION = "gpe/libs"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ cairo libxrender gtk-doc intltool-native"


LICENSE = "LGPL"
DEFAULT_PREFERENCE = "-1"

S =  "${WORKDIR}/${PN}"
PV = "0.107+cvs${SRCDATE}"
PR = "r0"

inherit autotools pkgconfig

SRC_URI =   "${HANDHELDS_CVS};module=gpe/base/${PN}"

EXTRA_OECONF = "--enable-cairo"

do_stage () {
	autotools_stage_all
}
