require cairo.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
           file://configure_fix.patch;patch=1 "

PR = "r4"


SRC_URI[md5sum] = "a198d509f9e3a35b78de8bb02174ebb9"
SRC_URI[sha256sum] = "7f0ce28c358706913bc39e6930a18ae89f3b9a6aa17998faa2b59d1e0e2b4f42"
