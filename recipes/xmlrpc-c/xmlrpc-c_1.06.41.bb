DESCRIPTION = "XML-RPC for C/C++ is programming libraries and related tools to help you \
write an XML-RPC server or client in C or C++."
LICENSE = "GPLv2+"
DEPENDS = "curl libxml2"
PR = "r0"

# note: this is version 1.06.47
# there seems to be versions with higher numbers (e.g. 1.11.00)
# but these are actually not newer

EXTRA_OECONF = " --enable-libxml2-backend -disable-libwww-client"

PARALLEL_MAKE = ""

inherit autotools

do_configure () {
	gnu-configize
        oe_runconf
}

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tgz"
SRC_URI[md5sum] = "02c6b89b8ff911341b6b6d4a6c621ea9"
SRC_URI[sha256sum] = "a13f5ef40ed75d89543b9cd086185121dead9fc7de850ca4d2edd9a0cec12205"

