DESCRIPTION = "Powerful and Pythonic XML processing library combining \
libxml2/libxslt with the ElementTree API."
HOMEPAGE = "http://codespeak.net/lxml"
LICENSE = "BSD"
SRCNAME = "lxml"
PR = "r0"
DEPENDS = "libxml2 libxslt"
RDEPENDS_${PN} += "libxml2 libxslt python-compression"

SRC_URI = "http://pypi.python.org/packages/source/l/${SRCNAME}/${SRCNAME}-${PV}.tar.gz;name=lxml"
SRC_URI[lxml.md5sum] = "b1f700fb22d7ee9b977ee3eceb65b20c"
SRC_URI[lxml.sha256sum] = "7fd36e4a56360cd5d7319e357b04a90e2c6b836ea220c88f9451c300ae33cc5e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DISTUTILS_BUILD_ARGS += " \
                     --with-xslt-config='${STAGING_BINDIR_NATIVE}/pkg-config libxslt' \
                     --with-xml2-config='${STAGING_BINDIR_NATIVE}/xml2-config' \
"

DISTUTILS_INSTALL_ARGS += " \
                     --with-xslt-config='${STAGING_BINDIR_NATIVE}/pkg-config libxslt' \
                     --with-xml2-config='${STAGING_BINDIR_NATIVE}/xml2-config' \
"
