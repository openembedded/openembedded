require ti-xdctools.inc

PV = "3_20_06_81"

# This fixes c6accel, but breaks codec-engine and lpm
#SRC_URI += "file://arm-linker-hack.diff"

SRC_URI[xdcbin.md5sum] = "65151268d6be6ad6eb940ef7ed03af16"
SRC_URI[xdcbin.sha256sum] = "8ea6b851521ce41fe0b4a349b2d922af7e70f48c50ad9fd21f62627446a834f8"



