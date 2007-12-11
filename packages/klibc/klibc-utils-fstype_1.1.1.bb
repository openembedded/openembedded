SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/klibc/Stable/klibc-${PV}.tar.bz2" 
SRC_URI += "file://fstype-sane-and-vfat.patch;patch=1" 
PR = "r0"

S = "${WORKDIR}/klibc-${PV}"

do_compile() {
    ${CC} -o fstype utils/fstype.c -static
}

do_install () {
        install -d ${D}${bindir}
        install -m 0755 fstype ${D}${bindir}/
}
