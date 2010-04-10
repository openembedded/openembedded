require apt-native.inc
PR = "r5"

SRC_URI += "file://nodoc.patch;patch=1 \
            file://noconfigure.patch;patch=1"

SRC_URI[md5sum] = "e2e6e23f43bfdf135b923205659dfaf1"
SRC_URI[sha256sum] = "d3a71446234e567a24740b02abe5bc6c695836343df6139eb7c03ec11871e710"
