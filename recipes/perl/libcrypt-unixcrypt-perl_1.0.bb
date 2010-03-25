DESCRIPTION = "Crypt::UnixCrypt - perl-only implementation of the crypt function."
SECTION = "libs"
LICENSE = "Artistic|GPL"
BBCLASSEXTEND = "native"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MV/MVORL/Crypt-UnixCrypt-${PV}.tar.gz;name=crypt-unixcrypt-perl-${PV}"
SRC_URI[crypt-unixcrypt-perl-1.0.md5sum] = "ff007b7fdda2aa626acaca216750c422"
SRC_URI[crypt-unixcrypt-perl-1.0.sha256sum] = "51d3716e740ed2ddd93cf942b994d0384b0452dd8138f8c5ce420ad39df8f906"

S = "${WORKDIR}/Crypt-UnixCrypt-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
