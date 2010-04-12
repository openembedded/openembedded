DESCRIPTION = "A commercial quality OCR engine "
LICENSE = "APL + others"

DEPENDS = "tiff"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}-ocr/${P}.tar.gz"

inherit autotools pkgconfig




SRC_URI[md5sum] = "e3bc57773a60134ef37e9f06fe541108"
SRC_URI[sha256sum] = "6fc9e28a574bf22028249e9a12e033c8bee0aeccbf90621238a6f538e60e7d60"
