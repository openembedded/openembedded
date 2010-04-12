require ruby.inc

PR = "${INC_PR}.0"

FILES_${PN}-dbg += "${libdir}/ruby/1.8/*/.debug \
                    ${libdir}/ruby/1.8/*/*/.debug"


SRC_URI[md5sum] = "3fbb02294a8ca33d4684055adba5ed6f"
SRC_URI[sha256sum] = "19590e972b80333e26a6514c34d976c2037138361481a16f27b75e5d33f33a58"
