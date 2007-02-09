DESCRIPTION = "Plugin system for GPE applications"
AUTHOR = "Luce DeCicco <ldecicco@gmail.com>"
DEPENDS = "gtk+ libgpewidget"
PV = "0.0+svn${SRCDATE}"
PR = "r0"

inherit autotools pkgconfig

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

do_stage() {
      autotools_stage_all
}

#put examples in a seperate package
PACKAGES += "${PN}-examples"

FILES_${PN}-examples = "${bindir}/* ${libexecdir}/*"
FILES_${PN} = "${libdir}/*.so.*"
