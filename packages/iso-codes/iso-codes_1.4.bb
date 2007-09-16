LICENSE = "LGPL"

SRC_URI = "ftp://pkg-isocodes.alioth.debian.org/pub/pkg-isocodes/iso-codes-${PV}.tar.bz2" 

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/xml/"

do_stage() {
        autotools_stage_all
}

