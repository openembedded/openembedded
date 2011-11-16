# This is the support library for AT91SAM9M10 On2 8170 video decoder.
DESCRIPTION = "Library for AT91SAM9M10 On2 8170 video decoder"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = ""

COMPATIBLE_MACHINE = (at91sam9m10ekes|at91sam9m10g45ek|at91sam9m10g45|at91sam9x5ek)

PR = "r1"

DEPENDS = "glib-2.0 gstreamer on2-8170-libs"
CFLAGS += "-I${STAGING_INCDIR}/glib-2.0 -I${STAGING_INCDIR}/gstreamer-0.10 -I${STAGING_INCDIR}/libxml2/ -I${STAGING_LIBDIR}/glib-2.0/include"
GST_MAJORMINOR=0.10
PROVIDES += "gstx170"

SRC_URI = "ftp://ftp.linux4sam.org/pub/demo/linux4sam_1.9/codec/gst-plugin-x170-${PV}.tar.gz"
SRC_URI[md5sum] = "bd8a8a1cc31dd37f18b1614f503226f4"
SRC_URI[sha256sum] = "734ded3618246d946b53c2c8c7ab5a0961287485aaef5fb9bf874f93e3caa342"
S = ${WORKDIR}/gst-plugin-x170-${PV}

inherit autotools

FILES_${PN} = " \
    ${libdir}/gstreamer-${GST_MAJORMINOR}/*.so \
    "

FILES_${PN}-dev = " \
    ${libdir}/gstreamer-${GST_MAJORMINOR}/*.so \
    ${libdir}/gstreamer-${GST_MAJORMINOR}/*.a \
    ${libdir}/gstreamer-${GST_MAJORMINOR}/*.la \
    "

do_stage() {
    echo staging ...
    oe_libinstall -s -a -C ${S}/src/.libs libgstx170   ${STAGING_LIBDIR}
    install -m 0644  ${S}/src/gstx170.h  ${STAGING_INCDIR}/
}

do_install() {
    echo install ...
    install -d ${D}/${libdir}/gstreamer-${GST_MAJORMINOR}
    oe_libinstall -s -C ${S}/src/.libs/ libgstx170   ${D}/${libdir}/gstreamer-${GST_MAJORMINOR}
}
