DESCRIPTION = "GNU SASL is an implementation of the Simple Authentication and Security Layer framework and a few common SASL mechanisms."
HOMEPAGE = "http://www.gnu.org/software/gsasl/"
DEPENDS = "libidn"  
PR = "r0"

SRC_URI = "${GNU_MIRROR}/${PN}/${P}.tar.gz;name=libgsasl"
SRC_URI[libgsasl.md5sum] = "e1e5ffac3f260a0412b8820d8e5229ab"
SRC_URI[libgsasl.sha256sum] = "1e3d42c414e09a8fb16fb3ce5fac2a3b3324048e123b7f682fb05b12c51bede8"

S = ${WORKDIR}/${PN}-${PV}

EXTRA_OECONF = "--with-libidn-prefix=${STAGING_DIR}/${HOST_SYS}"

inherit autotools
