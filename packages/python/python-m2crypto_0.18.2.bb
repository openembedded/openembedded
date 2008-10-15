DESCRIPTION = "A Python crypto and SSL toolkit"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = "openssl swig-native"
LICENSE = "BSD"
SRCNAME = "M2Crypto"
PR = "ml0"

SRC_URI = "http://chandlerproject.org/pub/Projects/MeTooCrypto/m2crypto-${PV}.tar.gz \
           file://install.patch;patch=1"
S = "${WORKDIR}/m2crypto-0.18.2"

inherit setuptools

export STAGING_DIR := "${STAGING_DIR}"
export STAGING_INCDIR := "${STAGING_INCDIR}"
export STAGING_LIBDIR := "${STAGING_LIBDIR}"

