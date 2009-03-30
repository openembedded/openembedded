DESCRIPTION = "Packages for a standalone  SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r1"

PACKAGES = "${PN}"

# Stuff contained in this SDK is largely taken from task-sdk-base.bb.
# This is a starting point, and nothing more at present -- please fill
# this out with a reasonable set of development tools for an FSO image.
# Also feel free to remove stuff that's silly.  And someone should
# review the glibc-gconv list to see if that makes sense.

RDEPENDS_${PN} = "\
    glibc \
    glibc-dbg \
    glibc-dev \
    glibc-utils \
    libsegfault \
    glibc-thread-db \
    glibc-localedata-i18n \
    glibc-gconv-ibm850 \
    glibc-gconv-cp1252 \
    glibc-gconv-iso8859-1 \
    glibc-gconv-iso8859-15 \
    locale-base-en-gb \
    libgcc \
    libstdc++ \
    linux-libc-headers-dev \
    \
    libssl \
    libcrypto \
    openssl-dev \
    libts-dev \
    ncurses-dev \
    readline-dev \
    gnutls-dev \
    libgcrypt-dev \
    libapm-dev \
    alsa-dev \
    alsa-lib-dev \
    libgpg-error-dev \
    libx11-dev \
    util-macros-dev \
    bigreqsproto-dev \
    xproto-dev \
    xextproto-dev \
    xtrans-dev \
    xcmiscproto-dev \
    xf86bigfontproto-dev \
    kbproto-dev \
    inputproto-dev \
    glib-2.0-dev \
    expat-dev \
    libice-dev \
    libsm-dev \
    dbus-dev \
    bluez-libs-dev \
    jpeg-dev \
    libpng-dev \
    "

# This one needs further investigation; seems to be some
# sort of naming problem that breaks the SDK when it is
# added directly.
ODDLY_BROKEN_PACKAGES ="\
    libz-dev \
"
