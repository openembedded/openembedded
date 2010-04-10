DESCRIPTION = "CMU PocketSphinx - speech recognition engine for handhelds"
HOMEPAGE = "http://www.speech.cs.cmu.edu/pocketsphinx/"
LICENSE = "BSD"
DEPENDS = "sphinxbase"

SRC_URI = "${SOURCEFORGE_MIRROR}/cmusphinx/${PN}-${PV}.tar.bz2 \
           file://cross-compile.patch;patch=1"

inherit autotools

do_configure () {
    CPPFLAGS="-I${STAGING_INCDIR}/sphinxbase" oe_runconf
}

SRC_URI[md5sum] = "65408ad948c0b9e21dd5813e68ef76ad"
SRC_URI[sha256sum] = "74c83c3283178656a6fc1ee571fb1ebbddda8f3b7c32ad405477ae278b0cf867"
