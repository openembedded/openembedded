DESCRIPTION = "PyWPA is another Python extension module written in C \
               that interfaces with wpa_supplicant"
HOMEPAGE = "http://www.emperorlinux.com/etc/contrib/?page=pywpa"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
RDEPENDS = "python-core"
PR = "ml0"

SRC_URI = "http://downloads.emperorlinux.com/contrib/pywpa/pywpa-${PV}.tbz2 \
           file://Makefile \
           file://Makefile.wpactrl"

S="${WORKDIR}/pywpa-${PV}"

do_unpack_real () {
        tar jxvf pywpa-${PV}.tbz2
        cp Makefile pywpa-${PV}/
        cp Makefile.wpactrl pywpa-${PV}/wpactrl/Makefile
}
do_unpack_real[dirs] = "${WORKDIR}"
addtask unpack_real before do_patch after do_unpack

inherit autotools pkgconfig distutils-base

CFLAGS += "-I${STAGING_INCDIR}/${PYTHON_DIR}"

do_compile() {
	cd ${S}/wpactrl
        oe_runmake HOSTPYTHON=${STAGING_BINDIR_NATIVE}/python \
                   STAGING_LIBDIR=${STAGING_LIBDIR} \
                   STAGING_INCDIR=${STAGING_INCDIR} \
                   BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
                   OPT="${CFLAGS}"
	cd ${S}
        oe_runmake HOSTPYTHON=${STAGING_BINDIR_NATIVE}/python \
                   STAGING_LIBDIR=${STAGING_LIBDIR} \
                   STAGING_INCDIR=${STAGING_INCDIR} \
                   BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
                   OPT="${CFLAGS}"
}

do_install() {
        install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/pywpa
        install -m 0755 pywpa/__init__.py ${D}${libdir}/${PYTHON_DIR}/site-packages/pywpa/__init__.py
        install -m 0755 pywpa/_pywpa.so ${D}${libdir}/${PYTHON_DIR}/site-packages/pywpa/_pywpa.so
}

FILES_${PN} = "${libdir}/${PYTHON_DIR}/site-packages/pywpa/__init__.py ${libdir}/${PYTHON_DIR}/site-packages/pywpa/_pywpa.so"
