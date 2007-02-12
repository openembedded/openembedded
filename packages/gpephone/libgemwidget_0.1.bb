LICENSE     = "LiPS"
DESCRIPTION = "Extended widget library for GPE phone environment."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libiac"
PR          = "r1"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

do_stage () {
	autotools_stage_all
}
