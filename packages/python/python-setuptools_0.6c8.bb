DESCRIPTION = "Download, build, install, upgrade, and uninstall Python packages"
HOMEPAGE = "http://cheeseshop.python.org/pypi/setuptools"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT-like"
RDEPENDS = "python-distutils python-compression"
SRCNAME = "setuptools"
PR = "ml2"

SRC_URI = "\
  http://cheeseshop.python.org/packages/source/s/setuptools/${SRCNAME}-${PV}.tar.gz\
  file://fix-log-usage.patch;patch=1 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_install_prepend() {
    install -d ${D}/${libdir}/${PYTHON_DIR}/site-packages
}
