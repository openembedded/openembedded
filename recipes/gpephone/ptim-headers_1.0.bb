DESCRIPTION = "Phone input method - shared headers"
SECTION = "gpephone"
PRIORITY = "optional"
LICENSE = "LiPS"
DEPENDS = "gtk+"

inherit gpephone pkgconfig autotools

SRC_URI = "${GPEPHONE_MIRROR}/ptim-headers-${PV}/imheaders-${PV}.tar.bz2"

S = "${WORKDIR}/imheaders-${PV}"

do_stage () {
    autotools_stage_all
}

SRC_URI[md5sum] = "33226da8468acccdcac483ea25c99a91"
SRC_URI[sha256sum] = "255b3b869e3945f8b031e9fa23649f7e342211713335ea447e40975bfed96fa8"
