DESCRIPTION = "The pycodes package provides various extensions to Python for low density parity check (LDPC) codes \
(an extremely powerful class of error correcting codes)."
SECTION = "devel/python"
HOMEPAGE = "http://web.mit.edu/~emin/www/source_code/pycodes/index.html"
PRIORITY = "optional"
LICENSE = "PYCODES"
SRCNAME = "pycodes"
PR = "ml1"

SRC_URI = "http://web.mit.edu/~emin/www/source_code/pycodes/pycodes-1-2.tar.gz \
           file://no-docs.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}"

inherit distutils

SRC_URI[md5sum] = "c39e0ffea530cbf0b4f2aa6af6e81b66"
SRC_URI[sha256sum] = "d203b4be819e20314576d5c26329862e7d371c84e8f192e31402a0b6d9e055aa"
