DESCRIPTION = "libhangul is a generalized and portable library for processing hangul (Korean)."
HOMEPAGE = "http://kldp.net/projects/hangul/"
SECTION = "x11/input"
LICENSE = "GPL"
DEPENDS = "gtk+ glib-2.0"
PR = "r0"

SRC_URI = "http://kldp.net/frs/download.php/3733/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig lib_package

do_stage() {
       autotools_stage_all
}

SRC_URI[md5sum] = "a32301e03a381917cb2ec836a43a9664"
SRC_URI[sha256sum] = "939bbcacd49487f830cd9d8bf56f81043f519bb7bfbcfb568fd87bf484120a10"
