DESCRIPTION = "GOCR is an OCR (Optical Character Recognition) program"
LICENSE = "GPLv2"

SRC_URI = "http://www-e.uni-magdeburg.de/jschulen/ocr/gocr-${PV}.tar.gz"
SRC_URI[md5sum] = "9882ba9a93fcb18ab704a10da80c228c"
SRC_URI[sha256sum] = "e0c7b6fc864abfebcb0afa084963fb98f8967b356913e6406cf7b21cfd83d8a2"

inherit autotools

RDEPENDS_${PN} = "tcl"
