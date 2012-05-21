DESCRIPTION = "Library for ASN.1 and DER manipulation"
LICENSE = "GPLv3+ LGPLv2.1+"
LICENSE_${PN}-bin = "GPLv3+"
LICENSE_${PN} = "LGPLv2.1+"

PR = "r2"

SRC_URI = "ftp://ftp.gnutls.org/pub/gnutls/libtasn1/libtasn1-${PV}.tar.gz"

inherit autotools binconfig lib_package

SRC_URI[md5sum] = "ebfd69b3514d8e8830057f0e9df6a5f9"
SRC_URI[sha256sum] = "9431f8e41acbeb5b5b89ec87a092b1a1fe9ef0a229a9a90806f4774707ca1f1f"
