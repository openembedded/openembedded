require pixman.inc
PR = "${INC_PR}.0"

SRC_URI += " \
            file://pixman-0.13.2-neon1.patch \
           "
SRC_URI[archive.md5sum] = "837df4a02c61a60a880644393b57faed"
SRC_URI[archive.sha256sum] = "45d491879791140dc1f20287e6489f32dc59ae37628038d991d9511abede3fc2"

# We have NEON
EXTRA_OECONF_append_armv7a = " --disable-arm-simd"

DEFAULT_PREFERENCE = "-1"
