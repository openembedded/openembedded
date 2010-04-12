DESCRIPTION = "Linux kernel for h1940 devices."
SECTION = "kernel"
LICENSE = "GPLv2"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "h1940"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.11.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/snapshots/old/patch-2.6.11-bk1.gz;patch=1;name=bkpatch \
           http://rtpnet.nerim.net/ipaq/2.6.11-bk1/2.6.11-bk1-h1940.patch;patch=1;name=patch \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.11"

inherit kernel

do_configure() {
        install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        yes '' | oe_runmake oldconfig
}

SRC_URI[kernel.md5sum] = "f00fd1b5a80f52baf9d1d83acddfa325"
SRC_URI[kernel.sha256sum] = "1fa39c202efe168bfeb0ddd74c8e4814f77da7dc78993e47826bad9173b95808"
SRC_URI[bkpatch.md5sum] = "92d8225c6b75b142054ad2321a992a42"
SRC_URI[bkpatch.sha256sum] = "2886eb4ceedac69f3924dbc9d979869b8a188dfb5b94a3e1068932859b4c9b3f"
SRC_URI[patch.md5sum] = "7f76fd173b550b1236025592be88f84c"
SRC_URI[patch.sha256sum] = "f09d4ae3365b876da9f40f49178ab7241bb7e4c1d67db9e2f310f9c76d5834a6"
