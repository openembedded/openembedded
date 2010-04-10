DESCRIPTION = "Python Imaging Library"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "freetype jpeg tiff"
RDEPENDS = "python-lang python-stringold"
SRCNAME = "Imaging"
PR = "ml1"

SRC_URI = "http://effbot.org/downloads/Imaging-${PV}.tar.gz \
           file://path.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_compile() {
    export STAGING_LIBDIR=${STAGING_LIBDIR}
    export STAGING_INCDIR=${STAGING_INCDIR}
    distutils_do_compile
}

do_install() {
    export STAGING_LIBDIR=${STAGING_LIBDIR}
    export STAGING_INCDIR=${STAGING_INCDIR}
    distutils_do_install
    install -d ${D}${datadir}/doc/${PN}/html/
    install -m 0644 ${S}/README ${D}${datadir}/doc/${PN}/
    install -m 0644 ${S}/Docs/* ${D}${datadir}/doc/${PN}/html/

}

SRC_URI[md5sum] = "3a9b5c20ca52f0a9900512d2c7347622"
SRC_URI[sha256sum] = "7dd7358ab519161967c838df27465282d180a3206f693ba2db64273d688b3f90"
