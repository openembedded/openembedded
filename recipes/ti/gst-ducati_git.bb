DEPENDS = "libdce gst-plugins-base"

LICENSE = "LGPLv2.1"

inherit autotools

PV = "0.10.0"
PR = "r3"
PR_append = "+gitr${SRCREV}"

SRCREV = "2c30e033e5014903a61ad9b483627ff2e320b35a"
SRC_URI = "git://github.com/robclark/gst-ducati.git;protocol=git \
           http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-0.10.32.tar.bz2;name=archive \
"

SRC_URI[archive.md5sum] = "442bc3d37b8511a73379143e7531d726"
SRC_URI[archive.sha256sum] = "3bf4e46a186ee9a1f5e212aaf651d67cffb4f5f05345a7c99ae71d5d992be133"

S = "${WORKDIR}/git"

acpaths = "-I m4 -I common/m4"

do_configure_prepend () {

    rm -rf ${S}/common ${S}/po
    cp -Rf ${WORKDIR}/gstreamer-0.10.32/common ${S}/
    cp -Rf ${WORKDIR}/gstreamer-0.10.32/po ${S}/

    if test -f po/Makefile.in.in;
    then
      patch -p0 -R < common/gettext.patch
    fi
    autopoint --force
    patch -p0 < common/gettext.patch
}

FILES_${PN}     += "${libdir}/gstreamer-0.10/*.so ${sysconfdir} ${installdir}"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.a ${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

