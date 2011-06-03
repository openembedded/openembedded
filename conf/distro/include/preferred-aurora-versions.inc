# we need new headers for libc, now OLDEST_KERNEL_linux-gnueabi = "2.6.24"
# and 2.6.31 for fsodeviced
LINUX_LIBC_HEADERS_VERSION ?= "2.6.32"
PREFERRED_VERSION_linux-libc-headers = "${LINUX_LIBC_HEADERS_VERSION}"
PREFERRED_VERSION_linux-libc-headers-native = "${LINUX_LIBC_HEADERS_VERSION}"

# We need git version of tslib as the old 1.0 release does not the support the features we
# need for some mobile handset devices
PREFERRED_VERSION_tslib = "1.0+git%"

# Adjust kernel configuration for older udev versions
UDEV_GE_141 = "1"

# specifically set an openssh version
# NOTE: whenever changing the version here make sure
#       to check we won't loose our specific config !!!
PREFERRED_VERSION_openssh = "5.2p1"

