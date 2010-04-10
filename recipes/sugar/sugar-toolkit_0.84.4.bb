DESCRIPTION = "Sugar toolkit"
LICENSE = "LGPLv2"
DEPENDS = "python-pygtk libxml-parser-perl-native libxml2 gtk+ alsa-lib"
RDEPENDS = "python-pygtk"

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


SRC_URI[md5sum] = "5ad76015d382ec4125c2ef01022dc898"
SRC_URI[sha256sum] = "bc489eb0feacfd68cd29f1556e2d1c4b4eb8f01c9add7ceb878b605521eb9f92"
