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
