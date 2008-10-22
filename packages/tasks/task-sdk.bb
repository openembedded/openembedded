DESCRIPTION = "SDK packages"
PR = "r8"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PACKAGES = "\
    task-sdk-bare \
    "

DEPENDS = "virtual/libc"

LIBC_linux = "glibc"
LIBC_linux-uclibc = "uclibc"
LIBC_linux-gnueabi = "glibc"
LIBC_linux-uclibcgnueabi = "uclibc"


RDEPENDS_task-sdk-bare = "\
    ${LIBC} \
    ${LIBC}-dev \
    libgcc \
    "
