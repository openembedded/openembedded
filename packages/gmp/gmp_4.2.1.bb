PR = "r1"

SRC_URI += "file://sh4-asmfix.patch;patch=1"

require gmp.inc

# Builds on sh but can't be used due to not compiling in some functions
DEFAULT_PREFERENCE_sh3 = "-1"
DEFAULT_PREFERENCE_sh4 = "-1"
