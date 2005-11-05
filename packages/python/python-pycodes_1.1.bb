DESCRIPTION = "The pycodes package provides various extensions to Python for low density parity check (LDPC) codes \
(an extremely powerful class of error correcting codes). LDPC codes can be used for physical layer error correction \
in wireless, telephone, DSL, or cable modems; packet loss correction in multicast and distribution of bulk data over \
the Internet; and even data compression. A variety of decoding/quantization algorithms are provided including standard\
things like sum-product as well as linear programming relaxations."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PYCODES"
SRCNAME = "pycodes"

SRC_URI = "http://www.csua.berkeley.edu/~emin/source_code/pycodes/pycodes-1-1.tar.gz \
           file://no-docs.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}"

inherit distutils
