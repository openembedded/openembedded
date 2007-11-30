LICENSE     = "LiPS"
DESCRIPTION = "LiPS IPC library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ gtk-doc"
PR          = "r2"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

SRC_URI += "file://po.patch;patch=1"

do_stage () {
	autotools_stage_all
}
