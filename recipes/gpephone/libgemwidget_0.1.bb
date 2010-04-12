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

SRC_URI[md5sum] = "95d269ad7e7cb7d3032498ad2e47643b"
SRC_URI[sha256sum] = "b8a1da871aa34362caf0c76dcbd3df42aef7313a4ed08f38eddcb159b80302c5"
# CHECKSUMS.INI MISMATCH: I got this:
#SRC_URI[md5sum] = "f5ac1c6a22120581659588a9d507dc06"
#SRC_URI[sha256sum] = "4d98b3999a79244856edabf8d99874f7fb665e5eb129af1360529c41df29dc4c"
