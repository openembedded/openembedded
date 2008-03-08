DESCRIPTION = "PyIW is a simple Python extension module written in C \
that interfaces with libiw  and provides a very 'pythonic' API to programmers."
HOMEPAGE = "http://www.emperorlinux.com/etc/contrib/?page=pyiw"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "wireless-tools"
RDEPENDS = "python-core"
PR = "ml0"

inherit autotools pkgconfig distutils-base

CFLAGS += "-I${STAGING_INCDIR}/${PYTHON_DIR}"

SRC_URI = "http://downloads.emperorlinux.com/contrib/pyiw/pyiw-${PV}.tbz2 \
           file://Makefile"
S = "${WORKDIR}/pyiw-${PV}"

do_unpack_real () {
        tar jxvf ${DL_DIR}/pyiw-${PV}.tbz2
        cp Makefile pyiw-${PV}/
}
do_unpack_real[dirs] = "${WORKDIR}"
addtask unpack_real before do_patch after do_unpack

do_install() {
        install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/
        install -m 0755 pyiw.so ${D}${libdir}/${PYTHON_DIR}/site-packages/pyiw.so
}

FILES_${PN} = "${libdir}/${PYTHON_DIR}/site-packages/pyiw.so"
