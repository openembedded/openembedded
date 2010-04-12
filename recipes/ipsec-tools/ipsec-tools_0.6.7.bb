PR = "${INC_PR}.0"

require ipsec-tools.inc

SRC_URI += "file://racoon-search-missing.patch;patch=1 file://gcc-4.2.patch;patch=1"
SRC_URI[ipsec-tools-0.6.7.md5sum] = "4fb764f282dc21cf9a656c58e13dacbb"
SRC_URI[ipsec-tools-0.6.7.sha256sum] = "4239f836dc610a2443ded7ba35cb3b87de9d582c800e5d9eb5eed37defd61ef2"
