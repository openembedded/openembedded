DESCRIPTION = "g-inspector is a GObject/Glib/GTK+ inspection utility"
HOMEPAGE = "http://sf.net/project/g-inspector"
SECTION = "x11/devel"
LICENSE = "BSD"
DEPENDS = "glib-2.0 gtk+ glrr glrr-widgets"

SRC_URI = "${SOURCEFORGE_MIRROR}/g-inspector/ginspector-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/*/*/ginspector/*.so"
