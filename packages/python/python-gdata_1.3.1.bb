DESCRIPTION = "Google Data API"
AUTHOR = "Jeffrey Scudder"
HOMEPAGE = "http://code.google.com/p/gdata-python-client/"
SECTION = "network"
PRIORITY = "optional"
LICENSE = "Apache 2.0"
PROVIDES = "python-gdata"
DEPENDS = "python-native"

inherit package_ipk

inherit distutils

PR = "r1"

SRC_URI = "http://gdata-python-client.googlecode.com/files/gdata-${PV}.tar.gz"

S = "${WORKDIR}/gdata-${PV}"

do_compile() {
    export STAGING_LIBDIR=${STAGING_LIBDIR}
    export STAGING_INCDIR=${STAGING_INCDIR}
    distutils_do_compile
}

do_install() {
    export STAGING_LIBDIR=${STAGING_LIBDIR}
    export STAGING_INCDIR=${STAGING_INCDIR}
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/atom/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/Cipher/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/Hash/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/Protocol/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/PublicKey/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/Util/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/media/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/geo/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/oauth/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/tlslite/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/tlslite/integration/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/tlslite/utils/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/exif/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/photos/
		install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/youtube/
		install -m 0755 ${S}/build/lib/atom/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/atom/
		install -m 0755 ${S}/build/lib/gdata/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/
		install -m 0755 ${S}/build/lib/gdata/Crypto/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/
		install -m 0755 ${S}/build/lib/gdata/Crypto/Cipher/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/Cipher/
		install -m 0755 ${S}/build/lib/gdata/Crypto/Hash/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/Hash/
		install -m 0755 ${S}/build/lib/gdata/Crypto/Protocol/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/Protocol/
		install -m 0755 ${S}/build/lib/gdata/Crypto/PublicKey/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/PublicKey/
		install -m 0755 ${S}/build/lib/gdata/Crypto/Util/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/Crypto/Util/
		install -m 0755 ${S}/build/lib/gdata/media/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/media/
		install -m 0755 ${S}/build/lib/gdata/geo/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/geo/
		install -m 0755 ${S}/build/lib/gdata/oauth/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/oauth/
		install -m 0755 ${S}/build/lib/gdata/tlslite/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/tlslite/
		install -m 0755 ${S}/build/lib/gdata/tlslite/integration/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/tlslite/integration/
		install -m 0755 ${S}/build/lib/gdata/tlslite/utils/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/tlslite/utils/
		install -m 0755 ${S}/build/lib/gdata/exif/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/exif/
		install -m 0755 ${S}/build/lib/gdata/photos/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/photos/
		install -m 0755 ${S}/build/lib/gdata/youtube/*.py ${D}${libdir}/${PYTHON_DIR}/site-packages/gdata/youtube/
}
