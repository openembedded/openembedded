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

SRC_URI[md5sum] = "17610af80be230e5760dbb25690a45f0"
SRC_URI[sha256sum] = "b5817b8629f89e16ba88e1c62dce0321978f3aea038aa77cb61a1ff7fa3e0dbb"
