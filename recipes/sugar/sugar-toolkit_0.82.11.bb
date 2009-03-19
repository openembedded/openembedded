DESCRIPTION = "Sugar toolkit"
LICENSE = "LGPLv2"
DEPENDS = "python-pygtk libxml-parser-perl-native libxml2 gtk+ alsa-lib"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/sugar-toolkit/sugar-toolkit-${PV}.tar.bz2"

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

