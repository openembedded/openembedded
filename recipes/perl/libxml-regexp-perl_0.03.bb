DESCRIPTION = "XML::RegExp - Regular expressions for XML tokens"
SECTION = "libs"
LICENSE = "unknown"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TJ/TJMATHER/XML-RegExp-${PV}.tar.gz"

S = "${WORKDIR}/XML-RegExp-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "5826b24e0d05714e25c2bb04e1f1c09b"
SRC_URI[sha256sum] = "4608bd4aed51d6f31a1a77796bc42f7ddf9700fe9b33c86a6b75ccb6a9cf6abe"
