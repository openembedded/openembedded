DESCRIPTION = "Packages for a standalone  SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"
PR = "r2"

PACKAGES = "${PN}"

GLIBC_PKGS = "\
    glibc \
    glibc-dbg \
    virtual-libc-dev \
    glibc-utils \
    libsegfault \
    glibc-thread-db \
"

LIBC_PKGS_libc-glibc = "${GLIBC_PKGS}"
LIBC_PKGS_libc-uclibc = "uclibc uclibc-dev uclibc-thread-db"

RDEPENDS_${PN} = "\
    ${LIBC_PKGS} \
    libgcc \
    libstdc++ \
    libstdc++-dev \
"
