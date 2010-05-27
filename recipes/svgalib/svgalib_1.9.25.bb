#
#  Created on: 25-Jul-2006
#      Author: Christopher Lang, <christopher.lang@acurana.de>
#      Copyright (C) 2006 acurana GmbH, http://www.acurana.de/
#      All rights reserved.
#
#  Updated on 29-Apr-2010
#	Eric Benard - <eric@eukrea.com>
#
#  Description: svgalib VGA graphics library
#

DESCRIPTION = "Linux Super VGA graphics library"
AUTHOR = "The svgalib contributors"
HOMEPAGE = "http://www.svgalib.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r0"

PARALLEL_MAKE = ""

SRC_URI = "http://my.arava.co.il/~matan/svgalib/svgalib-${PV}.tar.gz;name=tarball \
	file://makefiles-ldconfig.patch \
	file://gtfcalc-round.patch \
	file://svgalib-1.9.25-linux2.6.patch \
	"

S = "${WORKDIR}/svgalib-${PV}"

LEAD_SONAME = "libvga"

PACKAGES += "${PN}-utils ${PN}-demos"

FILES_${PN} = "${libdir}/*.so.*"

FILES_${PN}-demos = "${bindir}/${PN}"
FILES_${PN}-utils = "${sbindir}/${PN}"

FILES_${PN}-dbg += "${bindir}/${PN}/.debug \
    ${sbindir}/${PN}/.debug"

TARGET_CC_ARCH += "${LDFLAGS}"
LDFLAGS_append = " -L${D}/usr/lib"

# this HAVE_ROUND thing is not ideal, but since svgalib doesn't use autoconf...
# see also gtfcalc-round.patch
CFLAGS_append = " -L${D}/usr/lib -DHAVE_ROUND "

# see Makefile.cfg
ADDITIONAL_SVGA_DRIVER_TESTS = "INCLUDE_FBDEV_DRIVER_TEST=y"

EXTRA_OEMAKE = "install demoprogs \
    prefix=${D}/usr \
    TOPDIR=${D} \
    INSTALL_PROGRAM='install -c -s -m 755' \
    INSTALL_SCRIPT='install -c -m 755' \
    INSTALL_SHLIB='install -c -m 755' \
    INSTALL_DATA='install -c -m 644' \
    NO_HELPER=y \
    ${ADDITIONAL_SVGA_DRIVER_TESTS} \
    INCLUDES='-I. -I../include -I../src -I../gl -I${STAGING_INCDIR}' \
    mandir=${D}/usr/share/man \
    SVGALIB_CONFIG_FILE=/etc/vga/libvga.config \
    "

do_compile_prepend () {
    install -d ${D}/{usr/lib,etc}
}

do_install_append () {
    oe_libinstall -C sharedlib -so libvga ${D}${libdir}
    oe_libinstall -C sharedlib -so libvgagl ${D}${libdir}
    oe_libinstall -C threeDKit -so lib3dkit ${D}${libdir}
    install -d ${D}${includedir}
    install -m 0644 ${S}/include/* ${D}${includedir}
    install -m 0644 ${S}/gl/vgagl.h ${D}${includedir}

    install -d ${D}${mandir}/man{1,3,5,6,7,8}

    for files in `ls -1 ${S}/doc/man1` ; do gzip ${S}/doc/man1/$files ; done
    install -m 0644 ${S}/doc/man1/* ${D}${mandir}/man1

    for files in `ls -1 ${S}/doc/man3` ; do gzip ${S}/doc/man3/$files ; done
    install -m 0644 ${S}/doc/man3/* ${D}${mandir}/man3

    for files in `ls -1 ${S}/doc/man5` ; do gzip ${S}/doc/man5/$files ; done
    install -m 0644 ${S}/doc/man5/* ${D}${mandir}/man5

    for files in `ls -1 ${S}/doc/man6` ; do gzip ${S}/doc/man6/$files ; done
    install -m 0644 ${S}/doc/man6/* ${D}${mandir}/man6

    for files in `ls -1 ${S}/doc/man7` ; do gzip ${S}/doc/man7/$files ; done
    install -m 0644 ${S}/doc/man7/* ${D}${mandir}/man7

    for files in `ls -1 ${S}/doc/man8` ; do gzip ${S}/doc/man8/$files ; done
    install -m 0644 ${S}/doc/man8/* ${D}${mandir}/man8

    install -d ${D}${bindir}/${PN}
    install -d ${D}${sbindir}/${PN}

    for files in `find ${S}/demos -type d -o -executable -print` ; do \
        install -m 755 $files ${D}${bindir}/${PN} ; \
    done

    install -m 755 ${S}/threeDKit/plane ${D}${bindir}/${PN}
    install -m 755 ${S}/threeDKit/wrapdemo ${D}${bindir}/${PN}

    for files in `find ${S}/utils -type d -o -executable -print` ; do \
        install -m 755 $files ${D}${sbindir}/${PN} ; \
    done

    install -d ${D}${docdir}/${PN}

    for files in `find ${S}/doc -maxdepth 1 -type f` ; do \
        install -m 644 $files ${D}${docdir}/${PN} ; \
    done
}

do_stage () {
    install -m 0644 ${S}/include/* ${STAGING_INCDIR}/
    install -m 0644 ${S}/gl/vgagl.h ${STAGING_INCDIR}/
    oe_libinstall -C sharedlib -so libvga ${STAGING_LIBDIR}
    oe_libinstall -C sharedlib -so libvgagl ${STAGING_LIBDIR}
    oe_libinstall -C threeDKit -so lib3dkit ${STAGING_LIBDIR}
}

SRC_URI[tarball.md5sum] = "4dda7e779e550b7404cfe118f1d74222"
SRC_URI[tarball.sha256sum] = "2ad5da713a6bd69622c483de4e4f448ed2b82f7b954db43dc477d5b6b12d8602"
