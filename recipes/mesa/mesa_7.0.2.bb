include mesa-mesa.inc

PR = "${INC_PR}.0"

SRC_URI_append = " file://fix-host-compile.patch;patch=1 "

SRC_URI[md5sum] = "93e6ed7924ff069a4f883b4fce5349dc"
SRC_URI[sha256sum] = "9d4707b556960f6aef14480f91fcd4f868720f64321947ab1b2fd20e85ce7f9e"
