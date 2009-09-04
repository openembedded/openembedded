DESCRIPTION = "Fribidi library for bidirectional text"
SECTION = "libs"
PRIORITY = "optional"

PROVIDES = "libfribidi"

# Slightly incompatible with 0.10.x, so:
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

inherit autotools_stage lib_package pkgconfig

CFLAGS_append = "  -DPAGE_SIZE=4096 "

SRC_URI = "http://fribidi.org/download/fribidi-${PV}.tar.gz"
