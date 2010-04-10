require libftdi_${PV}.bb

inherit native

DEPENDS = "virtual/libusb0-native"

SRC_URI[md5sum] = "6b1bf276ba8d623332083477f91deefd"
SRC_URI[sha256sum] = "1ffb6284de02c75a2cd6709b6148eac0336cd0297742500da12aedd151838295"
