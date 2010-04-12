require glibmm.inc

DEPENDS += "mm-common"

SRC_URI += " file://remove-examples.patch;patch=1"

PR = "r1"


SRC_URI[archive.md5sum] = "1a96c7fde75ddbb421bc23fb4aa7adba"
SRC_URI[archive.sha256sum] = "f105ff4afdcdf7da7f310affdbe698058958f01e94ab65ac1c35e46e20ecb6c0"
