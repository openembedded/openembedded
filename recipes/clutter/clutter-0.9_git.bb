require clutter.inc

SRCREV = "745ca8a62ca52eedfad850e556f160f36eb32953"

PV = "0.9.3"
PR = "r1"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter.git;protocol=git;branch=1.0-integration \
           file://enable_tests.patch;patch=1 "
S = "${WORKDIR}/git"

BASE_CONF += "--disable-introspection"

do_compile_prepend() {
	for i in $(find ${S} -name Makefile) ; do
		sed -i -e s:-Werror::g $i
	done
    ( cd clutter/cogl/gles ; for i in *.glsl ; do sh stringify.sh -h $i ; done )
}

