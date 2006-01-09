DESCRIPTION = "Plugin system for GPE applications"
AUTHOR = "Luce DeCicco <ldecicco@gmail.com>"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS = "gtk+ libgpewidget"
PV = "0.0+cvs${SRCDATE}"
PR = "r0"

#put examples in a seperate package 
PACKAGES += ${PN}-examples
FILES_${PN}-examples = "${bindir}/* ${libexecdir}/*"
FILES_${PN} = "${libdir}/*.so.*"


SRC_URI =       "${HANDHELDS_CVS};module=gpe/base/${PN}"
S =				"${WORKDIR}/${PN}"

inherit autotools pkgconfig

do_stage() {
autotools_stage_all
}
