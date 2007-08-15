DESCRIPTION = "The pycodes package provides various extensions to Python for low density parity check (LDPC) codes \
(an extremely powerful class of error correcting codes)."
SECTION = "devel/python"
HOMEPAGE = "http://web.mit.edu/~emin/www/source_code/pycodes/index.html"
PRIORITY = "optional"
LICENSE = "PYCODES"
SRCNAME = "pycodes"
PR = "ml0"

SRC_URI = "http://web.mit.edu/~emin/www/source_code/pycodes/pycodes-1-2.tar.gz \
           file://no-docs.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}"

inherit distutils
