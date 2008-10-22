DESCRIPTION = "GNOME XML library"
DEPENDS = "python-native"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libxml2-${PV}"
PR = "r3"

SRC_URI = "ftp://xmlsoft.org/libxml2/libxml2-${PV}.tar.gz"
S = "${WORKDIR}/libxml2-${PV}"

inherit autotools native pkgconfig

def libxml2_native_python_dir(d):
        import os, bb
        staging_incdir = bb.data.getVar( "STAGING_INCDIR", d, 1 )
        if os.path.exists( "%s/python2.5" % staging_incdir ): return "python2.5"
        if os.path.exists( "%s/python2.4" % staging_incdir ): return "python2.4"
        if os.path.exists( "%s/python2.3" % staging_incdir ): return "python2.3"
        raise "No Python in STAGING_INCDIR. Forgot to build python-native ?"

EXTRA_OECONF = "--with-python=${STAGING_INCDIR}/${@libxml2_native_python_dir(d)} \
                --without-debug --without-legacy --without-catalog --without-docbook --with-c14n"

do_stage () {
	oe_runmake install
}
