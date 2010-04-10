DESCRIPTION = "Sugar toolkit"
LICENSE = "LGPLv2"
DEPENDS = "python-pygtk libxml-parser-perl-native libxml2 gtk+ alsa-lib"

SRC_URI = "http://download.sugarlabs.org/sources/sucrose/glucose/sugar-toolkit/sugar-toolkit-${PV}.tar.bz2"

inherit autotools distutils-base

SRC_URI += "file://acinclude.m4"

EXTRA_OECONF += "--with-python-includes=${STAGING_INCDIR}/../"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}


SRC_URI[md5sum] = "f6882ee56ed327c6680738133e911bf3"
SRC_URI[sha256sum] = "243a9d699af072b4cb79334b62638463d9f39437e7a886a14a95b7a8250983bd"
