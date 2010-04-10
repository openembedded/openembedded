LICENSE     = "LGPL"
DESCRIPTION = "Base library for GPE phone environment."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ gtk-doc dbus-glib"
PR          = "r1"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "009af2f3554caaf547bbc282da0e83c6"
SRC_URI[sha256sum] = "c40ea6d2282503ede882efe85ad526358683c311ea4592d41eaab0725ca75934"
