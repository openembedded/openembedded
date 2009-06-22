require clutter.inc

SRCREV = "fdaaa8b6d701d2b43fd2750de1b018b5af5577ea"

PV = "0.9.4"
PR = "r0"
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

