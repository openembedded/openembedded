LICENSE = "BERKLEY"
DEPENDS = "openssl ortp speex expat"
PROVIDES = "libjingle"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/libjingle-${PV}.tar.gz"

S = "${WORKDIR}/libjingle-${PV}"

inherit autotools pkgconfig

do_stage () {
        autotools_stage_all
}
