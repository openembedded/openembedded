DESCRIPTION = "SDK task for Scratchbox rootstraps"
PR = "r7"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

RDEPENDS_${PN} = "\
    strace \
    gdb \
    sbrsh \
    fakeroot \
    opkg-nogpg \
    opkg-utils \
    "
