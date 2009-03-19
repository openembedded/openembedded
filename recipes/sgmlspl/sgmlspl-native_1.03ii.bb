DESCRIPTION = "A simple post-processor for SGMLS and NSGMLS"
HOMEPAGE = "http://search.cpan.org/src/DMEGG/SGMLSpm-1.03ii/DOC/HTML/SGMLSpm/sgmlspm.html"
SECTION = "libs"
LICENSE = "GPL"

SRC_URI = "http://www.cpan.org/authors/id/D/DM/DMEGG/SGMLSpm-${PV}.tar.gz \
          file://combined.patch;patch=1"

S = "${WORKDIR}/SGMLSpm"

inherit native cpan

do_install() {
  :
}

do_stage() {
  oe_runmake install_vendor
}

PACKAGES = "${PN}-dbg  "
