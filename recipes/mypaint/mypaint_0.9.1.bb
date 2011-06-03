DESCRIPTION = "drawing program with dynamic brushes for graphic tablets"
HOMEPAGE = "http://mypaint.info/"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv2 GPLv2+ LGPLv2+"

DEPENDS = "glib-2.0 libpng python-numpy swig-native"
RDEPENDS_${PN} = "python-image python-json"

SRC_URI = "http://download.gna.org/mypaint/${PN}-${PV}.tar.bz2 \
           file://scons-adapt.patch \
"

SRC_URI[md5sum] = "6249a16359a438d6dc658f5765b35515"
SRC_URI[sha256sum] = "407b599f62fb0d6e711fee57d22e64d3aec88825364fb5f7f73b9f0940aa7aed"

inherit distutils scons

do_compile() {
       STAGING_INCDIR=${STAGING_INCDIR} \
       STAGING_LIBDIR=${STAGING_LIBDIR} \
       STAGING_DIR_TARGET=${STAGING_DIR_TARGET} \
       PYTHON_SITEPACKAGES_DIR=${PYTHON_SITEPACKAGES_DIR} \
       BUILD_SYS=${BUILD_SYS} \
       HOST_SYS=${HOST_SYS} \
       PATH=${PATH} scons_do_compile
}

do_install() {
       STAGING_DIR_TARGET=${STAGING_DIR_TARGET} \
       PYTHON_SITEPACKAGES_DIR=${PYTHON_SITEPACKAGES_DIR} \
       BUILD_SYS=${BUILD_SYS} \
       HOST_SYS=${HOST_SYS} \
       scons_do_install
}

FILES_${PN} += "${datadir}"
