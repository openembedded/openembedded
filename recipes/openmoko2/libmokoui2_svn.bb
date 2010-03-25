SECTION = "openmoko/libs"
DEPENDS = "gtk+ python-pygtk"

SRCREV = "4695"
PV = "0.1.0+svnr${SRCPV}"
PR = "r5"

inherit openmoko2 python-dir

SRC_URI += "\
	file://configure.patch;patch=1 \
	file://makefile.am.patch;patch=1 \
	"
LICENSE = "LGPL"

EXTRA_OECONF += " --enable-python"

do_configure_prepend() {
        touch gtk-doc.make
}

do_stage() {
        autotools_stage_all
}
FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}/mokoui.*"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/.debug/"
FILES_${PN}-dev += "/usr/share/vala/vapi/"
