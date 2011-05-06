require avahi.inc

# Lack the noipv6 stuff from 0.6.25
DEFAULT_PREFERENCE = "-1"

PR = "${INC_PR}.1"

DEPENDS += "intltool-native"

PACKAGES =+ "libavahi-gobject"

SRC_URI[md5sum] = "e4db89a2a403ff4c47d66ac66fad1f43"
SRC_URI[sha256sum] = "f9e4316c2339d0020726edd846d01bee0c39980906db0c247479e5807457ff1f"


