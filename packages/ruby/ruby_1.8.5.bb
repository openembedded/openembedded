require ruby.inc
DEPENDS = "ruby-native zlib openssl"

PR = "r1"

FILES_${PN}-dbg += "${libdir}/ruby/1.8/*/.debug \
                    ${libdir}/ruby/1.8/*/*/.debug"

