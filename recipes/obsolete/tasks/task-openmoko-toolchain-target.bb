DESCRIPTION = "Packages for a standalone Openmoko SDK or external toolchain"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PR = "r3"

PACKAGES = "${PN}"

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
    libgcc \
    libstdc++ \
"
