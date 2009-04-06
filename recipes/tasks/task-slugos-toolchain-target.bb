DESCRIPTION = "Packages for a standalone SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r3"

PACKAGES = "${PN}"

DEPENDS = "task-sdk-bare"

# This is a starting point, and nothing more at present -- please fill
# this out with a reasonable set of development tools for a SlugOS image.
# Also feel free to remove stuff that's silly.

RDEPENDS_${PN} = "\
    task-sdk-bare \
    linux-libc-headers-dev \
    libssl \
    libcrypto \
    openssl-dev \
    zlib-dev \
    "
