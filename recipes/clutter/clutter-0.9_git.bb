require clutter.inc

SRCREV = "b9a53d379d3aaca4b09a90cd44d5a9d9736a2435"

PV = "0.9.3"
PR = "r2"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter.git;protocol=git \
           file://enable_tests.patch;patch=1 "
S = "${WORKDIR}/git"

BASE_CONF += "--disable-introspection"

do_compile_prepend() {
	for i in $(find ${S} -name Makefile) ; do
		sed -i -e s:-Werror::g $i
	done
    ( cd clutter/cogl/gles ; for i in *.glsl ; do sh stringify.sh -h $i ; done )
}

