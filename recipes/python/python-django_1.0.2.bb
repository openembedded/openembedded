DESCRIPTION = "Python Web framework"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "Django"
PR = "ml0"

SRC_URI = "http://media.djangoproject.com/releases/${PV}/${SRCNAME}-${PV}-final.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}-final"

inherit distutils

DISTUTILS_INSTALL_ARGS = "--root=${D} --prefix=${prefix}"

# TODO: huge package, increase granularity

RDEPENDS_${PN} = "\
  python-email \
  python-netserver \
  python-pickle \
  python-pprint \
  python-shell \
  python-sqlite \
  python-textutils \
  python-threading \
  python-unixadmin \
  python-xml \
"
