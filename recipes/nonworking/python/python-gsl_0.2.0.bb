DESCRIPTION = "GNU Scientific Library Python Bindings"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "gsl"
RDEPENDS = "python-core gsl"
SRCNAME = "pygsl"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://${FILESDIR}/cross-compile.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

export STAGING_DIR := "${STAGING_DIR}"

SRC_URI[md5sum] = "7b2c96c0bf2cf435611803b3f2463614"
SRC_URI[sha256sum] = "983e9b5cdf37a76f75cba7b9cfc6927d600d0bb8f87a9cb0972ef812c7cdac6f"
