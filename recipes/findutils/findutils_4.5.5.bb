require findutils.inc

PR = "${INC_PR}.0"

# newer version is not available on GNU_MIRROR from .inc file, and old 4.2.29 is not available on alpha.gnu.org
SRC_URI = "ftp://alpha.gnu.org/gnu/${BPN}/${BPN}-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "39f9dbee5db8e26f8fe01884cb99397b"
SRC_URI[archive.sha256sum] = "8388e1b26902e8f84320b320994071743b0e98c2831b189e8ba230747e8e0b8d"
