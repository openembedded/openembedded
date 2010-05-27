LICENSE     = "LiPS"
DESCRIPTION = "LiPS IPC library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ gtk-doc"
PR          = "r1"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "6bb2fd1841d9c1be22edc999970a55a3"
SRC_URI[sha256sum] = "821290104ef79b6a35a4a7456d50aff0536f66f05a5d6c255e7155d1cacd12b6"
