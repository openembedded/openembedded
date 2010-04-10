DESCRIPTION = "Library for manipulating structured configuration files"
AUTHOR = "Mark Lindner"
HOMEPAGE = "http://www.hyperrealm.com/libconfig/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2"
DEPENDS = ""
PV = "1.3.1"
PR = "r0"

SRC_URI = "http://www.hyperrealm.com/libconfig/libconfig-${PV}.tar.gz"

S = "${WORKDIR}/libconfig-${PV}"

inherit autotools

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "f02bfa27a21b3040089026975b9dc0b8"
SRC_URI[sha256sum] = "5677f32eff184883d7ca402234f92142f35bea7d04d503becdd104ae8343cb1c"
