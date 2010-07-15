require clutter.inc

PR = "${INC_PR}.0"

SRC_URI = "http://source.clutter-project.org/sources/clutter/1.0/clutter-${PV}.tar.bz2 \
"
SRC_URI[md5sum] = "bf48e85291cba33f3f149f4eefe759f0"
SRC_URI[sha256sum] = "6fb98dc4d16a3a98be734cf0a6cc4f8d8179800603c3e41011c414eeaf1f456b"

S = "${WORKDIR}/clutter-${PV}"

BASE_CONF += "--disable-introspection"

PARALLEL_MAKE = ""

do_compile_prepend() {
	for i in $(find ${S} -name Makefile) ; do
		sed -i -e s:-Werror::g $i
	done
    ( cd clutter/cogl/gles ; for i in *.glsl ; do sh stringify.sh -h $i ; done )
}

