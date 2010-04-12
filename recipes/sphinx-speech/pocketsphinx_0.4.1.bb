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

SRC_URI[md5sum] = "8c1bc9d5bdd6f6298222125669d16e1e"
SRC_URI[sha256sum] = "5a31aa10668b93e8283c58592b46368c26aa92e097cea0bda9b0554042bd6643"
