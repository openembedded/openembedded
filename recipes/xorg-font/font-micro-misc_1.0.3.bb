require xorg-font-common.inc

PE = "1"
PR = "${INC_PR}.0"

EXTRA_OECONF = "--disable-iso8859-2 --disable-iso8859-3 --disable-iso8859-4 --disable-iso8859-5 --disable-iso8859-6 --disable-iso8859-7 --disable-iso8859-8 --disable-iso8859-9 --disable-iso8859-10 --disable-iso8859-11 --disable-iso8859-12 --disable-iso8859-13 --disable-iso8859-14 --disable-iso8859-15 --disable-iso8859-16 --disable-jisx0201 --disable-koi8-r"

SRC_URI[archive.md5sum] = "143c228286fe9c920ab60e47c1b60b67"
SRC_URI[archive.sha256sum] = "9a3381c10f32d9511f0ad4179df395914c50779103c16cddf7017f5220ed8db6"
