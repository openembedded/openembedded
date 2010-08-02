DESCRIPTION = "An LGPL implementation of RTP - RFC3550"
LICENSE = "LGPL"

INC_PR = "r1"

inherit autotools pkgconfig

SRC_URI = "http://download.savannah.nongnu.org/releases/linphone/${PN}/sources/${P}.tar.gz"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  ortp.pc

}

