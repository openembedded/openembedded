DESCRIPTION = "Implementation of the Stringprep, Punycode and IDNA specifications defined by the IETF Internationalized Domain Names (IDN) working group."
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
PR = "r0"

SRC_URI = "${GNU_MIRROR}/${PN}/${P}.tar.gz;name=libidn"
SRC_URI[libidn.md5sum] = "66f115347439f56386f37a3ad92c1da2"
SRC_URI[libidn.sha256sum] = "b824ef81319f4ba1a2e49b7208a3ad820a1baa7369e4555b8e45227e5796e77c"

EXTRA_OECONF = "--disable-tld"

inherit autotools
