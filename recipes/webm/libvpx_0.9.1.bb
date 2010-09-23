require libvpx.inc

PR = "${INC_PR}.0"

SRC_URI += "file://libvpx-configure-support-blank-prefix.patch;apply=yes"

CONFIGUREOPTS += " \
        --prefix=${prefix} \
        --libdir=${libdir} \
"

SRC_URI[md5sum] = "e1442e74d0cca228785083fa520735a2"
SRC_URI[sha256sum] = "c4e8e463e079ffde5b6948366a1d0873f1bf685dccd89ca137585c2b8247ec59"

