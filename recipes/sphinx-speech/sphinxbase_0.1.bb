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
