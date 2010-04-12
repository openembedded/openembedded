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

SRC_URI[md5sum] = "0a8474e0d90b139b1baa70b097a4fd51"
SRC_URI[sha256sum] = "7f55ec02b5ab9e86c64f5718be64854fd9c64899908e580e1a9759421ac3b436"
