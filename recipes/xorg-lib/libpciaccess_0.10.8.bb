require xorg-lib-common.inc

DEPENDS += "xproto virtual/libx11"

SRC_URI += "file://0001-vgaarb-check-pci_sys-exists-before-initing-vga-arb.patch;patch=1"
