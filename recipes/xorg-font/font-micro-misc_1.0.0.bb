require xorg-font-common.inc

PE = "1"
PR = "${INC_PR}.0"

EXTRA_OECONF = "--disable-iso8859-2 --disable-iso8859-3 --disable-iso8859-4 --disable-iso8859-5 --disable-iso8859-6 --disable-iso8859-7 --disable-iso8859-8 --disable-iso8859-9 --disable-iso8859-10 --disable-iso8859-11 --disable-iso8859-12 --disable-iso8859-13 --disable-iso8859-14 --disable-iso8859-15 --disable-iso8859-16 --disable-jisx0201 --disable-koi8-r"

SRC_URI[archive.md5sum] = "8c8bffd7540f05caa0dbb4e6e1d6c58e"
SRC_URI[archive.sha256sum] = "16b17b5939e12e9381c8096c1f77f064ee0073fa9cb09297dec278bade17a572"
