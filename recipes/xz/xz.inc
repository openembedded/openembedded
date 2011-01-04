DESCRIPTION = "XZ Utils is free general-purpose data compression software with high compression ratio.  XZ Utils are the successor to LZMA Utils."
SECTION = "console/utils"
LICENSE = "Public Domain"
HOMEPAGE = "http://tukaani.org/xz/"
INC_PR = "r0"
S ?= "${WORKDIR}/xz-${PV}"
EXTRA_OECONF = "--enable-shared"
BBCLASSEXTEND = "native"

inherit autotools
