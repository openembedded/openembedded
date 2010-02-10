DESCRIPTION = "Packages for a standalone  SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"
PR = "r1"

PACKAGES = "${PN}"

GLIBC_PKGS = "\
    glibc \
    glibc-dbg \
    virtual-libc-dev \
    glibc-utils \
    libsegfault \
    glibc-thread-db \
"

LIBC_PKGS_linux = "${GLIBC_PKGS}"
LIBC_PKGS_linux-gnueabi = "${GLIBC_PKGS}"
LIBC_PKGS_linux-gnuspe = "${GLIBC_PKGS}"
LIBC_PKGS_linux-uclibc = "uclibc uclibc-dev uclibc-thread-db"
LIBC_PKGS_linux-uclibceabi = "uclibc uclibc-dev uclibc-thread-db"

RDEPENDS_${PN} = "\
    ${LIBC_PKGS} \
    libgcc \
    libstdc++ \
    libstdc++-dev \
"
