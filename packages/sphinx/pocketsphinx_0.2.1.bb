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
