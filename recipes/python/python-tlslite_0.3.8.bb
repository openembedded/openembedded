DESCRIPTION = "TLS Lite is a free python library that implements SSL 3.0 and TLS 1.0. TLS Lite supports non-traditional \
authentication methods such as SRP, shared keys, and cryptoIDs, in addition to X.509 certificates. TLS Lite is pure  \
Python, however it can access OpenSSL or cryptlib for faster crypto operations."
SECTION = "devel/python"
HOMEPAGE = "http://trevp.net/tlslite/"
PRIORITY = "optional"
LICENSE = "PD"
SRCNAME = "tlslite"
PR = "ml1"

SRC_URI = "http://trevp.net/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "5e1c19500e30fc7580939c18b435f937"
SRC_URI[sha256sum] = "3d79170d8c3a662fa717b6401e8004208df113aaf3b18689bbeb704a23bf5b9f"
