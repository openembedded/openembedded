require ruby.inc
PR = "${INC_PR}.0"
SRC_URI = "ftp://ftp.ruby-lang.org/pub/ruby/${SHRT_VER}/ruby-${PV}.tar.gz \
           file://extmk_run.patch;patch=1 \
           file://extmk.patch;patch=1 \
"
FILES_${PN}-dbg += "${libdir}/ruby/1.8/*/.debug \
                    ${libdir}/ruby/1.8/*/*/.debug"
BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "60a65374689ac8b90be54ca9c61c48e3"
SRC_URI[sha256sum] = "5c9cd617a2ec6b40abd7c7bdfce3256888134482b22f933a061ae18fb4b48755"
