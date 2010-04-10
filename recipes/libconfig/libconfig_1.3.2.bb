DESCRIPTION = "Library for manipulating structured configuration files"
AUTHOR = "Mark Lindner"
HOMEPAGE = "http://www.hyperrealm.com/libconfig/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2"
PR = "r0"

SRC_URI = "http://www.hyperrealm.com/libconfig/libconfig-${PV}.tar.gz"

S = "${WORKDIR}/libconfig-${PV}"

inherit autotools

do_stage() {
  autotools_stage_all
}

SRC_URI[md5sum] = "094a82afd382aa2305c6cc3c06025c2d"
SRC_URI[sha256sum] = "2a680bb33e290c3c799e3a90cf2c0fb9f5482dd930ad93d9f83ce39923258c0a"
