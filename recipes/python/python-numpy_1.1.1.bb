DESCRIPTION = "A sophisticated Numeric Processing Package for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
PR = "ml0"

RDEPENDS_${PN} = "python-compiler python-mmap python-pkgutil python-pydoc python-unittest"

SRC_URI = "${SOURCEFORGE_MIRROR}/numpy/numpy-${PV}.tar.gz \
           file://unbreak-assumptions.diff \
	   file://trycompile.diff \
	   file://config.h \
	   file://numpyconfig.h \
	  "

S = "${WORKDIR}/numpy-${PV}"

inherit distutils

# Make the build fail and replace *config.h with proper one
# This is a ugly, ugly hack - Koen
do_compile_prepend() {
         BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
         ${STAGING_BINDIR_NATIVE}/python setup.py build ${DISTUTILS_BUILD_ARGS} || \
         true
	 cp ${WORKDIR}/*config.h ${S}/build/$(ls ${S}/build | grep src)/numpy/core/include/numpy/
}



SRC_URI[md5sum] = "af066b59a50bf5dbe1a14d6be3df6937"
SRC_URI[sha256sum] = "d430273a77aed959c007595d969fefa36c59249807212d7d89f5d6cf2a701dd6"
