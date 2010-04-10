require gpe-clock.inc

PR = "${INC_PR}.0"

SRC_URI += "file://default-time-24hrs.patch;patch=1"

SRC_URI[md5sum] = "3084a12de394a252048603128afe7c08"
SRC_URI[sha256sum] = "a6e74b2a9a7ccc24e095dbbc473c9ad7e69e06e8a30cd9581941763a75237b78"
