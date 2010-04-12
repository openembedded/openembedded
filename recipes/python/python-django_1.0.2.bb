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
  python-html \
  python-netserver \
  python-pickle \
  python-pprint \
  python-shell \
  python-sqlite3 \
  python-textutils \
  python-threading \
  python-unixadmin \
  python-xml \
"

SRC_URI[md5sum] = "89353e3749668778f1370d2e444f3adc"
SRC_URI[sha256sum] = "50a5d228743a69a682899b20141194bf8fd3fd75eaf33ba5f2932f43ea93ea0d"
