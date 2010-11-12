require xorg-app-common.inc
DESCRIPTION = "query configuration information of DRI drivers"
DEPENDS += " glproto virtual/libgl"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "3d3cad4d754e10e325438193433d59fd"
SRC_URI[archive.sha256sum] = "35c6e43d3b68ef5d93d013b4517014fb890bad96b2c801abf4f607927a94cb1c"
