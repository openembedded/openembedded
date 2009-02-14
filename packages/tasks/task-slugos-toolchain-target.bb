DESCRIPTION = "Packages for a standalone SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r1"

PACKAGES = "${PN}"

# Stuff contained in this SDK is largely taken from task-sdk-base.bb.
# This is a starting point, and nothing more at present -- please fill
# this out with a reasonable set of development tools for a SlugOS image.
# Also feel free to remove stuff that's silly.

RDEPENDS_${PN} = "\
    libgcc \
    linux-libc-headers-dev \
    libssl \
    libcrypto \
    openssl-dev \
    libstdc++ \
    "

# Not sure if we need these or not...
NOT_SURE_ABOUT = "\
    libsegfault \
    "

# This one needs further investigation; seems to be some sort
# of naming problem that breaks the SDK when it is added directly.
ODDLY_BROKEN_PACKAGES ="\
    libz-dev \
    "
