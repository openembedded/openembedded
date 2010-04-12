DESCRIPTION = "Download, build, install, upgrade, and uninstall Python packages"
HOMEPAGE = "http://cheeseshop.python.org/pypi/setuptools"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
RDEPENDS = "python-distutils python-compression"
SRCNAME = "setuptools"
PR = "ml0"

SRC_URI = "\
  http://cheeseshop.python.org/packages/source/s/setuptools/${SRCNAME}-${PV}.tar.gz\
  file://fix-log-usage.patch;patch=1 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_install_prepend() {
    install -d ${D}/${libdir}/${PYTHON_DIR}/site-packages
}

RDEPENDS = "\
  python-distutils \
  python-compression \
"

SRC_URI[md5sum] = "3864c01d9c719c8924c455714492295e"
SRC_URI[sha256sum] = "e6190497301b6cb1484b9e6173723452c8df1b4cd9ea97af75c9589b1c34b3d8"
