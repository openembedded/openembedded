require xorg-font-common.inc

PE = "1"
PR = "${INC_PR}.0"

EXTRA_OECONF = "--disable-iso8859-2 --disable-iso8859-3 --disable-iso8859-4 --disable-iso8859-5 --disable-iso8859-6 --disable-iso8859-7 --disable-iso8859-8 --disable-iso8859-9 --disable-iso8859-10 --disable-iso8859-11 --disable-iso8859-12 --disable-iso8859-13 --disable-iso8859-14 --disable-iso8859-15 --disable-iso8859-16 --disable-jisx0201 --disable-koi8-r"

SRC_URI[archive.md5sum] = "6350117efebe340f33e818f4a33e4e4b"
SRC_URI[archive.sha256sum] = "a5b987ea38bf53f63968a6cad1c052ca6d0fc678d9409c1953701f0159e4972b"
