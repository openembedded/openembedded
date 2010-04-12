DESCRIPTION = "Openmoko Settings GUI"
AUTHOR = "Kristian M."
SECTION = "openmoko/applications"
RDEPENDS = "python-pygtk python-subprocess python-threading"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://mput.de/~kristian/.openmoko/settingsgui-0.8.tar.bz2"

inherit distutils

SRC_URI[md5sum] = "8b6f19636983fe22bad5ee1e0906c837"
SRC_URI[sha256sum] = "e839e55b2d7babbbf0302429e9c58ff6e62a064c9ae4cb2d6f957a89b81e0022"
