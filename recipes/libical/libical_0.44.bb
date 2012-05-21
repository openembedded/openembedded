DESCRIPTION = "iCal and scheduling (RFC 2445, 2446, 2447) library"
HOMEPAGE = "http://www.softwarestudio.org/softwarestudio/app.php/libical"
SECTION = "libs"
LICENSE = "LGPLv2.1 | MPL-1"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/freeassociation/${P}.tar.gz \
	  "


inherit autotools

SRC_URI[md5sum] = "e0403c31e1ed82569325685f8c15959c"
SRC_URI[sha256sum] = "20a4750df8f4dedd718b55117b8351989e0dfa4ad2c966a383550ed43e6a72d8"
