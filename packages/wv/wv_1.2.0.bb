LICENSE = "GPLv2"

DEPENDS = "libgsf"

SRC_URI = "http://switch.dl.sourceforge.net/sourceforge/wvware/wv-${PV}.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig

do_stage () {
        autotools_stage_all
}

