require clamav.inc

SRC_URI += "file://cross-compile-fix.patch;patch=1"

PR = "${INC_PR}.0"

SRC_URI[clamav-0.90.3.md5sum] = "d42ccf7a32daeb7c7cc3c8c23a7793ea"
SRC_URI[clamav-0.90.3.sha256sum] = "939913d15ad0dc583ba609274ae61a948f4fa18b848bd503d958feacdaab54a4"
