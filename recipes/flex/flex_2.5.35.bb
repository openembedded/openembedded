require flex.inc

SRC_URI = "${SOURCEFORGE_MIRROR}/flex/flex-${PV}.tar.bz2;name=flex \
"

SRC_URI[flex.md5sum] = "10714e50cea54dc7a227e3eddcd44d57"
SRC_URI[flex.sha256sum] = "0becbd4b2b36b99c67f8c22ab98f7f80c9860aec70f0350a0018f29a88704e7b"

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
