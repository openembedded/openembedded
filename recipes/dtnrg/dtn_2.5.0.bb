DESCRIPTION = "Delay Tolerant Networking Package"
HOMEPAGE = "http://www.dtnrg.org/wiki"
SECTION = "libs"
DEPENDS = "db openssl python-native xerces-c"
LICENSE = "Apache"
PR = "r5"

# thread code atomic ops do not play with thumb
ARM_INSTRUCTION_SET = "arm"

SRC_URI = "\
  http://www.dtnrg.org/docs/code/dtn_${PV}.tgz \
  file://configure_fix.patch;patch=1 \
"

inherit autotools distutils-base

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

export BUILD_SYS
export HOST_SYS

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
PR_python-dtn = "ml4"
FILES_python-dtn = "${libdir}/${PYTHON_DIR}"
RDEPENDS_python-dtn = "python-core dtn-lib"

FILES_${PN}-dbg += "\
  ${PYTHON_SITEPACKAGES_DIR}/.debug \
  ${libdir}/.debug \
  ${bindir}/.debug \
"

FILES_${PN} += "${sysconfdir}"
