PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/linknx/linknx-${PV}.tar.gz \
           file://logger-initialisations.patch;patch=1 \
           "

require linknx.inc
SRC_URI[md5sum] = "21956fe0ca7072e08b8fe096c61c4f2d"
SRC_URI[sha256sum] = "cbc7e781fad9ac4704b7bf24b95e3de480fbcce6884e595109d18d0027d3b2fa"
