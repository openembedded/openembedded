require ruby.inc
PR = "${INC_PR}.0"
SRC_URI = "ftp://ftp.ruby-lang.org/pub/ruby/${SHRT_VER}/ruby-${PV}.tar.gz \
           file://extmk_run.patch;patch=1 \
           file://extmk.patch;patch=1 \
"
FILES_${PN}-dbg += "${libdir}/ruby/1.8/*/.debug \
                    ${libdir}/ruby/1.8/*/*/.debug"
BBCLASSEXTEND = "native"
