require clutter.inc

SRCREV = "36cfb6030784791a4420a1e52a8c18d56b1d0c69"
#good: 20090512 08a73a215f2cf18abcfd7d93e8047583511497bd

PV = "0.9.3"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter.git;protocol=git;branch=master \
           file://enable_tests.patch;patch=1 "
S = "${WORKDIR}/git"

BASE_CONF += "--disable-introspection"

# Fixup gles backend: 

do_compile_prepend() {
	for i in ${S}/clutter/cogl/gles/* ; do
		sed -i -e s:CGL_NEAREST:COGL_TEXTURE_FILTER_NEAREST:g \
		       -e s:CGL_LINEAR:iCOGL_TEXTURE_FILTER_LINEAR:g \
		       -e s:CGL_VERTEX_SHADER:COGL_SHADER_TYPE_VERTEX:g \
		       -e s:CGL_FRAGMENT_SHADER:COGL_SHADER_TYPE_FRAGMENT:g $i
	done
}
