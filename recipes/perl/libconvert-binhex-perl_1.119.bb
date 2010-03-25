DESCRIPTION = "Convert::BinHex - extract data from Macintosh BinHex files"
SECTION = "libs"
LICENSE = "Artistic|GPL"
BBCLASSEXTEND = "native"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/E/ER/ERYQ/Convert-BinHex-${PV}.tar.gz;name=convert-binhex-perl-${PV}"
SRC_URI[convert-binhex-perl-1.119.md5sum] = "ba70ad1772abac6270078f28197a7961"
SRC_URI[convert-binhex-perl-1.119.sha256sum] = "2d4b59e46d43eaeb7de39e244d8d89af1b44b8977c3034c3779f984c2a399f55"

S = "${WORKDIR}/Convert-BinHex-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
