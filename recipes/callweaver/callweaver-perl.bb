DESCRIPTION = "Callweaver::OGI Perl Gateway Interface Module"
HOMEPAGE = "http://www.callweaver.org"
SECTION = "libs"
LICENSE = "GPL"
RDEPENDS = "perl callweaver-ogi"
PR = "r0"
S = "${WORKDIR}/callweaver-1.2-${CWRCV}/contrib/ogi-perl/callweaver-perl-0.0.1"

CWRCV = "rc5"

SRC_URI = "http://devs.callweaver.org/release/callweaver-1.2.0-${CWRCV}.tar.bz2"

inherit cpan

do_install_append () {
  install -d ${D}${datadir}/callweaver/ogi/perl
  install ${S}/examples/* ${D}${datadir}/callweaver/ogi/perl
}

PACKAGES =+ "${PN}-examples"

FILES_${PN}-examples = "${datadir}/callweaver/ogi/perl"

SRC_URI[md5sum] = "cc99a6b12613bbdb132fb5c8c56069f1"
SRC_URI[sha256sum] = "1d4ec44d6124776009ddc7bf08d5f24f26a9b6814835456ab0b3ddbfc111b527"
