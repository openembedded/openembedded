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