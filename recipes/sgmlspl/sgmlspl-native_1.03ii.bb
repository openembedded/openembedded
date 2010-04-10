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

SRC_URI[md5sum] = "5bcb197fd42e67d51c739b1414d514a7"
SRC_URI[sha256sum] = "f06895c0206dada9f9e7f07ecaeb6a3651fd648f4820f49c1f76bfeaec2f2913"
