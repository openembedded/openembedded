require pixman.inc
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI += " \
            file://pixman-0.13.2-neon1.patch;patch=1 \
	   "

# We have NEON
EXTRA_OECONF_append_armv7a = " --disable-arm-simd"
