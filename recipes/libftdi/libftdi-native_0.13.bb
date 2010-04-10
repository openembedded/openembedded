require libftdi_${PV}.bb

inherit native

DEPENDS = "virtual/libusb0-native"

SRC_URI[md5sum] = "7b4a660fd644980f3d45873d156d021a"
SRC_URI[sha256sum] = "98ceb0a3174564f310c4ff1c021bdca52558bf693003a410cdb95c8388aa11f3"
