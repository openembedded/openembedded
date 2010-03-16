PR = "${INC_PR}.0"

require ipsec-tools.inc

SRC_URI += "file://racoon-search-missing.patch;patch=1 file://gcc-4.2.patch;patch=1"