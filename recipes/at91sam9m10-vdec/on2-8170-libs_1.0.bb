# This is the support library for Hantro X170 video decoder.
DESCRIPTION = "Library for Hantro X170 video decoder"
SECTION = "libs"
PRIORITY = "optional"

COMPATIBLE_MACHINE = (at91sam9m10ekes|at91sam9m10g45ek|at91sam9m10g45|at91sam9x5ek)

PR = "r1"
PROVIDES += "hantro-libs"
SRC_URI ="file://on2-8170-libs-1.0.tar.gz"
SRC_URI[md5sum] = "6dbdf510d16f120df9072ca7a25b1804"
SRC_URI[sha256sum] = "db7390a13e7c0426894a6f966ecde1f89e6566416088c50729750e800306a2de"

inherit autotools
S = ${WORKDIR}/on2-8170-libs-${PV}

FILES_${PN} = " \
    ${libdir}/*.so \
    "

FILES_${PN}-dev = " \
    ${libdir}/*.so \
    ${libdir}/*.a  \
    ${libdir}/*.la \
    ${includedir}/*.h  \
    "

#SRC_URI_append = ""

do_stage() {
    oe_libinstall -s -a -C ${S}   libdwlx170   ${STAGING_LIBDIR}
    oe_libinstall -s -a -C ${S}   libdecx170h  ${STAGING_LIBDIR}
    oe_libinstall -s -a -C ${S}   libx170j     ${STAGING_LIBDIR}
    oe_libinstall -s -a -C ${S}   libdecx170m2 ${STAGING_LIBDIR}
    oe_libinstall -s -a -C ${S}   libdecx170m  ${STAGING_LIBDIR}
    oe_libinstall -s -a -C ${S}   libdecx170p  ${STAGING_LIBDIR}
    oe_libinstall -s -a -C ${S}   libdecx170v  ${STAGING_LIBDIR}
															
    install -m 0644 ${S}/*.h ${STAGING_INCDIR}/
}

do_install() {
    oe_libinstall -s  -C ${S}  libdwlx170   ${D}/${libdir}/
    oe_libinstall -s  -C ${S}  libdecx170h  ${D}/${libdir}/
    oe_libinstall -s  -C ${S}  libx170j     ${D}/${libdir}/
    oe_libinstall -s  -C ${S}  libdecx170m2 ${D}/${libdir}/
    oe_libinstall -s  -C ${S}  libdecx170m  ${D}/${libdir}/
    oe_libinstall -s  -C ${S}  libdecx170p  ${D}/${libdir}/
    oe_libinstall -s  -C ${S}  libdecx170v  ${D}/${libdir}/
}

