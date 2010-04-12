require apt.inc
PR = "r3"

SRC_URI += "file://nodoc.patch;patch=1"

require apt-package.inc

FILES_${PN} += "${bindir}/apt-key"
apt-manpages += "doc/apt-key.8"

SRC_URI[md5sum] = "e2e6e23f43bfdf135b923205659dfaf1"
SRC_URI[sha256sum] = "d3a71446234e567a24740b02abe5bc6c695836343df6139eb7c03ec11871e710"
