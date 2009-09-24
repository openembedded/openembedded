require xorg-lib-common.inc

DEPENDS += "xproto virtual/libx11"

PR="r1"

SRC_URI += "\
            file://0001-vgaarb-check-pci_sys-exists-before-initing-vga-arb.patch;patch=1 \
            file://0002-Free-return-value-from-scandir-instead-of-leaking-it.patch;patch=1 \
            file://0003-vgaarb-check-for-fd-before-close-it.patch;patch=1 \
            file://0004-vgaarb-fix-newbie-typo.patch;patch=1 \
           "

