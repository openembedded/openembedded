require clutter.inc

SRCREV = "13e055a351f83c56b895b131566a6e842d24ed2a"

PV = "1.1.0"
PR = "${INC_PR}.0"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter.git;protocol=git \
           file://enable_tests.patch;patch=1 "
S = "${WORKDIR}/git"

BASE_CONF += "--disable-introspection"

PARALLEL_MAKE = ""

do_compile_prepend() {
	for i in $(find ${S} -name Makefile) ; do
		sed -i -e s:-Werror::g $i
	done
    ( cd clutter/cogl/gles ; for i in *.glsl ; do sh stringify.sh -h $i ; done )
}

