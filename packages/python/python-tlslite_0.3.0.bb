DESCRIPTION = "TLS Lite is a free python library that implements SSL 3.0 and TLS 1.0. TLS Lite supports non-traditional \
authentication methods such as SRP, shared keys, and cryptoIDs, in addition to X.509 certificates. TLS Lite is pure  \
Python, however it can access OpenSSL or cryptlib for faster crypto operations."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PD"
SRCNAME = "tlslite"

SRC_URI = "http://trevp.net/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

