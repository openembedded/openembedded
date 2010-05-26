require iproute2.inc

PR = "${INC_PR}.1"
DATE = "070710"

SRC_URI_append = " file://new-flex-fix.patch \
                   file://ip6tunnel.patch \
                   file://remove-bashisms.patch \
                   file://no-strip.patch"

S = "${WORKDIR}"


SRC_URI[md5sum] = "20ef2767896a0f156b6fbabd47936f79"
SRC_URI[sha256sum] = "3c6b48af9e655e4f0a34c7718e288960a1dc84a3ac7eb726e855adb45fbd953a"
