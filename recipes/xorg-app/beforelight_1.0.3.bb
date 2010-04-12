require xorg-app-common.inc

DESCRIPTION = "a sample implementation of a screen saver for X"
DEPENDS += " virtual/libx11 libxscrnsaver libxt libxaw libxt"
PE = "1"

SRC_URI[archive.md5sum] = "d55b0e7196dafcfeb4db3886af2e1969"
SRC_URI[archive.sha256sum] = "cae9427fa083a0ec3f2d1a3a6391508b31a2cf0220cb8d732c5d473a8c995c4e"
