require apt.inc
PR = "r2"

SRC_URI += "file://nodoc.patch;patch=1"

require apt-package.inc

FILES_${PN} += "${bindir}/apt-key"
apt-manpages += "doc/apt-key.8"



SRC_URI[md5sum] = "67d439a252996357b0313b3ad999739a"
SRC_URI[sha256sum] = "6f1a7340d0de2a9a524055d0ed4289aa919dc29e9e1fe60aae598f2019105686"
