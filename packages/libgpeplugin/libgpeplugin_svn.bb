DESCRIPTION = "Plugin system for GPE applications"
AUTHOR = "Luce DeCicco <ldecicco@gmail.com>"
DEPENDS = "gtk+ libgpewidget"
PV = "0.0+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn/gpe/trunk/base;module=${PN}"

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

do_stage() {
      autotools_stage_all
}

#put examples in a seperate package
PACKAGES += "${PN}-examples"

FILES_${PN}-examples = "${bindir}/* ${libexecdir}/*"
FILES_${PN} = "${libdir}/*.so.*"
