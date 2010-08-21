# klcc-cross depends on klibc
DEPENDS =+ "klcc-cross"

export CC=${TARGET_PREFIX}klcc

# reset inherited OE flags to avoid e.g. ggdb3 and keep size small
export CFLAGS=""
export CPPFLAGS=""
export LDFLAGS=""
