DESCRIPTION = "SDK task for Scratchbox rootstraps"
PR = "r8"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

RDEPENDS_${PN} = "\
    strace \
    gdb \
    sbrsh \
    fakeroot \
    opkg \
    opkg-utils \
    "
