DESCRIPTION = "Python Web framework"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "Django"
RELEASE = "1.2"
PR = "r0"

SRC_URI = "http://media.djangoproject.com/releases/${RELEASE}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DISTUTILS_INSTALL_ARGS = "--root=${D} --prefix=${prefix}"

# TODO: huge package, increase granularity

RDEPENDS_${PN} = "\
  python-email \
  python-html \
  python-netserver \
  python-numbers \
  python-pickle \
  python-pprint \
  python-shell \
  python-sqlite3 \
  python-textutils \
  python-threading \
  python-unixadmin \
  python-xml \
"

SRC_URI[md5sum] = "2351efb20f6b7b5d9ce80fa4cb1bd9ca"
SRC_URI[sha256sum] = "eaa29f2344568cc871c4517a348de0d5c39fbd055b4c998cd4a80601bb51e7b9"
