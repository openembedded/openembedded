DESCRIPTION = "Perl module for pseudo tty IO"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/IO/IO-Tty-${PV}.tar.gz"

S = "${WORKDIR}/IO-Tty-${PV}"

inherit cpan

SRC_URI[md5sum] = "2a54e49b60a4092e93af5b8073ec5325"
SRC_URI[sha256sum] = "44c3b00c7b33db6fc4d11e0d096520f2e870f8557f2e2a8f0e8d2efcf9506906"
