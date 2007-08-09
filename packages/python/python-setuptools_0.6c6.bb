DESCRIPTION = "Download, build, install, upgrade, and uninstall Python packages"
HOMEPAGE = "http://cheeseshop.python.org/pypi/setuptools"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT-like"
RDEPENDS = "python-core python-zlib"
SRCNAME = "setuptools"
PR = "ml1"

SRC_URI = "http://cheeseshop.python.org/packages/source/s/setuptools/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_install_prepend() {
    install -d ${D}/${libdir}/${PYTHON_DIR}/site-packages
}

do_stage() {
    BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
      ${STAGING_BINDIR_NATIVE}/python setup.py install 
}
