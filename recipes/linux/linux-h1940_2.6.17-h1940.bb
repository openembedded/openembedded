DESCRIPTION = "Linux kernel for h1940 devices."
SECTION = "kernel"
LICENSE = "GPLv2"

PR = "r1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "h1940"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.17.tar.bz2;name=kernel \
           http://rtp-net.org/ipaq/patches/2.6.17-1/v2.6.17-gitcurrent.patch;patch=1;name=patch1 \
           http://rtp-net.org/ipaq/patches/2.6.17-1/full.patch;patch=1;name=patch2 \
           http://rtp-net.org/ipaq/patches/2.6.17-1/WIP/serial_sparse.patch;patch=1;name=patch3 \
           http://rtp-net.org/ipaq/patches/2.6.17-1/WIP/h1940_leds.patch;patch=1;name=patch4 \
           http://rtp-net.org/ipaq/patches/2.6.17-1/WIP/bluetooth.patch;patch=1;name=patch5 \
           http://rtp-net.org/ipaq/patches/2.6.17-1/WIP/h1940_batt.patch;patch=1;name=patch6 \
           http://rtp-net.org/ipaq/patches/2.6.17-1/WIP/mtd_partition.patch;patch=1;name=patch7 \
           http://anymore.nl/ipaq/usbgadget_fixups.patch;patch=1;name=patch8 \
           http://anymore.nl/ipaq/udc_usb_gadget_register_driver_fix.patch;patch=1;name=patch9 \
           http://anymore.nl/ipaq/udc_unbind.patch;patch=1;name=patch10 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.17"

inherit kernel

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        yes '' | oe_runmake oldconfig
}

SRC_URI[kernel.md5sum] = "37ddefe96625502161f075b9d907f21e"
SRC_URI[kernel.sha256sum] = "ab0f647d52f124958439517df9e1ae0efda90cdb851f59f522fa1749f1d87d58"
SRC_URI[patch1.md5sum] = "d41d8cd98f00b204e9800998ecf8427e"
SRC_URI[patch1.sha256sum] = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"
SRC_URI[patch2.md5sum] = "230b98276779339a4102abdb1c36197a"
SRC_URI[patch2.sha256sum] = "866d1e45a575f448148c227f60cde4c8b607c51f179da3a7ec1acb5036b8e3ec"
SRC_URI[patch3.md5sum] = "2734448ca22fc44c2d999a5e47c70d5d"
SRC_URI[patch3.sha256sum] = "3a8b96d7955a022045c781c1b8ac266fa8cdd47295744d60e7c00a6e88abbb3d"
SRC_URI[patch4.md5sum] = "f1c690a1c94a4178cf71ddeba3d52acc"
SRC_URI[patch4.sha256sum] = "efa90d22a191b1bf2511b722dc2b9ed823fa7dbdab4a6be4c5f0609f5ed83af3"
SRC_URI[patch5.md5sum] = "d76dbdbb59924ace618e48fbddbf3365"
SRC_URI[patch5.sha256sum] = "eaa1a9746a4613a75a9fe9fc0c54a724758b899c5a898b8b50578066d8a82ead"
SRC_URI[patch6.md5sum] = "2810d6a0aa41a349faf711bfc9facf14"
SRC_URI[patch6.sha256sum] = "0d68bfb125997599470dbc4822d43e777a831da2f1cfa5356b5dc791cdd8b27f"
SRC_URI[patch7.md5sum] = "0f7cdd68da77a62e77f9012de052c513"
SRC_URI[patch7.sha256sum] = "2e56fe35b6f3b93dac201c55764b8bf6d899c995e0d165381368cfca886c6739"
SRC_URI[patch8.md5sum] = "261038b0a6890207b68a26be10a37822"
SRC_URI[patch8.sha256sum] = "1d645fa76a9482a6630b9a7257d11eabfa94ef4337493ef7075e25cbb8820491"
SRC_URI[patch9.md5sum] = "ee48a4ec191cb6ae61dad1bf6378cc85"
SRC_URI[patch9.sha256sum] = "31cfb81c4a4b16a6a0fe8fec04241d37c9ca98fe3bb0a434141c287fcb98e2bb"
SRC_URI[patch10.md5sum] = "07da0085296fef529ca869a108e07edc"
SRC_URI[patch10.sha256sum] = "3ffcdc0e4597046f476ae5d4250783eb563723614bad9f1f58cc0cd9932d0b1d"
