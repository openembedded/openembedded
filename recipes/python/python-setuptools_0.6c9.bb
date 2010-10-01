DESCRIPTION = "Download, build, install, upgrade, and uninstall Python packages"
HOMEPAGE = "http://cheeseshop.python.org/pypi/setuptools"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
SRCNAME = "setuptools"
PR = "ml2"
DEPENDS += "python"
DEPENDS_virtclass-native += "python-native"

SRC_URI = "\
  http://cheeseshop.python.org/packages/source/s/setuptools/${SRCNAME}-${PV}.tar.gz\
  file://fix-log-usage.patch \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_install_prepend() {
    install -d ${D}/${libdir}/${PYTHON_DIR}/site-packages
}

RDEPENDS_${PN} = "\
  python-distutils \
  python-compression \
"

SRC_URI[md5sum] = "3864c01d9c719c8924c455714492295e"
SRC_URI[sha256sum] = "e6190497301b6cb1484b9e6173723452c8df1b4cd9ea97af75c9589b1c34b3d8"

BBCLASSEXTEND = "native"

NATIVE_INSTALL_WORKS = "1"
