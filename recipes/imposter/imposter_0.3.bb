DESCRIPTION =	"Imposter is a standalone viewer for the presentations created by OpenOffice.org Impress software."
LICENSE =	"GPLv2"

SRC_URI	=	"${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"
DEPENDS =	"gtk+"

inherit autotools pkgconfig

SRC_URI[md5sum] = "5bcaa0fe3fec26840c8f1ecefc891887"
SRC_URI[sha256sum] = "53b67c08477623bb03436f79bf2ca859d7cd9684c57775ea539e1db449658236"
