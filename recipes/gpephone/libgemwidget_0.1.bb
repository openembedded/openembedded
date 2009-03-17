LICENSE     = "LiPS"
DESCRIPTION = "Extended widget library for GPE phone environment."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ libiac libgpephone"
PR          = "r1"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

# This really is not angstrom specific, but gtk 2.10 specific
# for a better solution: "patches accepted"
SRC_URI_append_angstrom = " file://gemfilechooser-NULL-callback.patch;patch=1"

do_stage () {
	autotools_stage_all
}
