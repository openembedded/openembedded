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

SRC_URI[md5sum] = "cf829bb82f84728194c64a41e9f1cf32"
SRC_URI[sha256sum] = "10197df9daee806453c5a7e99e538d7eac0421796f2a9ae114d4369d85fcf3af"
