SECTION = "openmoko/libs"
DEPENDS = "gtk+ python-pygtk"

PV = "0.1.0+svnr${SRCPV}"
PR = "r5"

inherit openmoko2

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
FILES_${PN} += "${libdir}/python2.6/site-packages/mokoui.*"
FILES_${PN}-dbg += "${libdir}/python2.6/site-packages/.debug/"
FILES_${PN}-dev += "/usr/share/vala/vapi/"
