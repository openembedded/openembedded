DESCRIPTION = "Openpbx::OGI Perl Gateway Interface Module"
HOMEPAGE = "http://www.openpbx.org"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "install-native"
RDEPENDS = "perl openpbx.org-ogi"
PR = "r0"

OPBXV = "openpbx.org-1.2_rc3"

SRC_URI = "http://www.openpbx.org/releases/${OPBXV}.tar.gz"

S = "${WORKDIR}/${OPBXV}/contrib/ogi-perl/openpbx-perl-${PV}"

inherit cpan

do_install_append () {
  install -d ${D}${datadir}/openpbx.org/ogi/perl
  install ${S}/examples/* ${D}${datadir}/openpbx.org/ogi/perl
}

PACKAGES =+ "${PN}-examples"

FILES_${PN}-examples = "${datadir}/openpbx.org/ogi/perl"
