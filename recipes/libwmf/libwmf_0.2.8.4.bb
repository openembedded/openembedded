inherit autotools_stage

SRC_URI = "${SOURCEFORGE_MIRROR}/wvware/${PN}/${PV}/${P}.tar.gz;name=tarball"
SRC_URI[tarball.md5sum] = "d1177739bf1ceb07f57421f0cee191e0"
SRC_URI[tarball.sha256sum] = "5b345c69220545d003ad52bfd035d5d6f4f075e65204114a9e875e84895a7cf8"

DESCRIPTION = "Library for converting WMF files"
HOMEPAGE = "http://wvware.sourceforge.net/libwmf.html"
LICENSE = "GPL-2" 

SECTION = "libs"

