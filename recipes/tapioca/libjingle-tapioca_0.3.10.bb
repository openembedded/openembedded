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

SRC_URI[md5sum] = "7ee7d8c834f1e06093130a86cbb9e79a"
SRC_URI[sha256sum] = "3453c1426fdc06b32bc5f4e7d3ce039ec7f38f0fa4018d505e515099b209dd25"
