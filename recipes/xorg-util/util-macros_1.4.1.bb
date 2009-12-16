require xorg-util-common.inc

DESCRIPTION = "X autotools macros"
PE = "1"

SRC_URI += " file://malloc_zero_returns_null.patch;patch=1"

ALLOW_EMPTY = "1"
