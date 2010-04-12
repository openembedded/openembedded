PR = "${INC_PR}.0"

require ipsec-tools.inc

SRC_URI += "file://racoon-search-missing.patch;patch=1 file://gcc-4.2.patch;patch=1"
SRC_URI[ipsec-tools-0.6.6.md5sum] = "e908f3cf367e31c7902df5ab16fbe5c3"
SRC_URI[ipsec-tools-0.6.6.sha256sum] = "2291dd75794a4fc307eb420eb035087a4cf56d3ef6b187f1a1386d3e33851044"
