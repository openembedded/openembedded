DESCRIPTION = "A Python crypto and SSL toolkit"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "openssl swig-native"
LICENSE = "BSD"
SRCNAME = "M2Crypto"
PR = "ml1"

SRC_URI = "\
  http://chandlerproject.org/pub/Projects/MeTooCrypto/m2crypto-${PV}.tar.gz \
  file://install.patch;patch=1 \
"
S = "${WORKDIR}/m2crypto-0.18.2"

inherit setuptools

export STAGING_DIR
export STAGING_INCDIR
export STAGING_LIBDIR

SRC_URI[md5sum] = "445dce53fcfc7ec8f6fd31f54da8a067"
SRC_URI[sha256sum] = "62ed44c8b2d392bdc757981ac37f05d808a0d917e4f9d95de2fbf3c2bdad41a7"
