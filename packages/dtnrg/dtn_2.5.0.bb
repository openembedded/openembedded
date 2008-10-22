DESCRIPTION = "Delay Tolerant Networking Package"
HOMEPAGE = "http://www.dtnrg.org/wiki"
SECTION = "libs"
DEPENDS = "db openssl python-native xerces-c"
LICENSE = "Apache"
SRC_URI = "http://www.dtnrg.org/docs/code/dtn_${PV}.tgz \
           file://configure_fix.patch;patch=1"
PR = "r3"

inherit autotools

EXTRA_OECONF = "\
  --with-python=${STAGING_BINDIR_NATIVE}/python \
  --with-db=${STAGING_DIR_HOST}${layout_exec_prefix} \
  --with-tcl=${STAGING_DIR_HOST}${layout_exec_prefix} \
  --without-google-perftools \
  --without-bluez \
  --without-bonjour \
  --with-expat=${STAGING_DIR_HOST}${layout_exec_prefix} \
  --with-xerces-c=${STAGING_DIR_HOST}${layout_exec_prefix} \
  --without-tclreadline \
  --with-zlib=${STAGING_DIR_HOST}${layout_exec_prefix} \
  --without-xsd-tool \
  --with-db=${STAGING_DIR_HOST}${layout_exec_prefix} \
  --enable-ecl \
  --enable-edp \
  --without-mysql \
  --without-postgres \
  --with-openssl=${STAGING_DIR_HOST}${layout_exec_prefix} \
"

def dtn_python_dir(d):
        import os, bb
        staging_incdir = bb.data.getVar( "STAGING_INCDIR", d, 1 )
        if os.path.exists( "%s/python2.5" % staging_incdir ): return "python2.5"
        if os.path.exists( "%s/python2.4" % staging_incdir ): return "python2.4"
        if os.path.exists( "%s/python2.3" % staging_incdir ): return "python2.3"
        raise "No Python in STAGING_INCDIR. Forgot to build python-native ?"

PYTHON_DIR = "${@dtn_python_dir(d)}"

# use this syntax once everyone has at least bitbake 1.8.9
#export BUILD_SYS
#export HOST_SYS

export BUILD_SYS:="${BUILD_SYS}"
export HOST_SYS:="${HOST_SYS}"

do_configure_prepend() {
	for i in aclocal/*.ac oasys/aclocal/*.ac; do
		install -m 0644 $i ${STAGING_DATADIR}/aclocal/`basename $i`.m4
	done
	autotools_do_configure
}

do_install_append() {
	cd applib/python
	INCDIR=../.. LIBDIR=.. VERSION=${PV} python setup.py install --prefix=${D}/${prefix} --install-data=${D}/${datadir}
}

PACKAGES =+ "${PN}-lib"
FILES_${PN}-lib = "${libdir}/*.so*"
PACKAGES += "python-dtn"
DESCRIPTION_python-dtn = "Python bindings to the DTN API"
PR_python-dtn = "ml2"
FILES_python-dtn = "${libdir}/${PYTHON_DIR}"
RDEPENDS_python-dtn = "python-core dtn-lib"
FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/.debug"
