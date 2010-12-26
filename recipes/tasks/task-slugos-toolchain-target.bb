DESCRIPTION = "Packages for a standalone SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r3.2"

PACKAGES = "${PN}"

# This is a starting point, and nothing more at present -- please fill
# this out with a reasonable set of development tools for a SlugOS image.
# Also feel free to remove stuff that's silly.

RDEPENDS_${PN} = "\
    eglibc eglibc-dbg eglibc-utils eglibc-dev eglibc-thread-db libsegfault \
    libgcc libstdc++ libstdc++-dev \
    libssl \
    libcrypto \
    openssl-dev \
    zlib-dev \
    "
