DESCRIPTION = "Base library for CMU Sphinx speech recognition engines"
HOMEPAGE = "http://www.speech.cs.cmu.edu/pocketsphinx/"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/cmusphinx/sphinxbase-0.1.tar.bz2"

inherit autotools

EXTRA_OECONF = "--enable-fixed"

do_stage () {
    autotools_stage_all
}
