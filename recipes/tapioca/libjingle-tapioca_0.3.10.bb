LICENSE = "BERKLEY"
DEPENDS = "openssl ortp speex expat"
PROVIDES = "libjingle"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/libjingle-${PV}.tar.gz \
           file://gcc-4.5-compilation-fixes.patch \
           file://fix-host-h-double-install.patch \
          "

S = "${WORKDIR}/libjingle-${PV}"

inherit autotools pkgconfig

SRC_URI[md5sum] = "7ee7d8c834f1e06093130a86cbb9e79a"
SRC_URI[sha256sum] = "3453c1426fdc06b32bc5f4e7d3ce039ec7f38f0fa4018d505e515099b209dd25"
