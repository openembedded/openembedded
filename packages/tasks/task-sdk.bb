DESCRIPTION = "SDK packages"
PR = "r7"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PACKAGES = "\
    task-sdk-bare \
    task-sdk-base \
    "

RDEPENDS_task-sdk-bare := "\
    glibc \
    glibc-dev \
    libgcc1 \
    "

RDEPENDS_task-sdk-base := "\
    glibc \
    glibc-dev \
    libgcc1 \
    ipkg-dev \
    "

