DESCRIPTION = "SDK task for Scratchbox rootstraps"
PR = "r6"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

RDEPENDS := "\
    strace \
    gdb \
    sbrsh \
    fakeroot \
    ipkg \
    gettext-dev \
    pkgconfig-dev \
    ipkg-utils \
    "
