DESCRIPTION = "Threaded I/O tester"
HOMEPAGE = "http://sourceforge.net/projects/tiobench/"
LICENSE = "GPLv2"
RDEPENDS = "\
    perl \
    perl-module-exporter-heavy \
    perl-module-getopt-long \
    perl-module-overload \
    perl-module-strict \
    "
PR = "r0"

SRC_URI = "\
    http://sourceforge.net/projects/tiobench/files/tiobench/${PV}/${P}.tar.gz \
    file://tiobench-makefile.patch \
    "
SRC_URI[md5sum] = "bf485bf820e693c79e6bd2a38702a128"
SRC_URI[sha256sum] = "8ad011059a35ac70cdb5e3d3999ceee44a8e8e9078926844b0685b7ea9db2bcc"

EXTRA_OEMAKE = "PREFIX=${D}"

do_install() {
    oe_runmake install
}
