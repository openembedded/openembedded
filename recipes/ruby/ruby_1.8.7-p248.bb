require ruby.inc
DEPENDS = "ruby-native zlib openssl"
SRC_URI = "ftp://ftp.ruby-lang.org/pub/ruby/${SHRT_VER}/ruby-${PV}.tar.gz \
           file://extmk_run.patch;patch=1 \
"
FILES_${PN}-dbg += "${libdir}/ruby/1.8/*/.debug \
                    ${libdir}/ruby/1.8/*/*/.debug"

