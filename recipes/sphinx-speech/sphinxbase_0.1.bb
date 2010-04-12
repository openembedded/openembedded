DESCRIPTION = "Base library for CMU Sphinx speech recognition engines"
HOMEPAGE = "http://www.speech.cs.cmu.edu/pocketsphinx/"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/cmusphinx/sphinxbase-${PV}.tar.bz2"

inherit autotools

require sphinx-fpu.inc
EXTRA_OECONF += "${@get_sphinx_fpu_setting(bb, d)}"

do_stage () {
    autotools_stage_all
}

SRC_URI[md5sum] = "5ff76b3a4799405ad91e88331eb938bb"
SRC_URI[sha256sum] = "ffb5e646d98c058ad2f1f0d7738b39e29fbe432981b1b5d9c8a79cdcb168c3c6"
