DESCRIPTION = "${PN} bindings"
LICENSE = "BSD"
AUTHOR = "Gustavo Sverzut Barbieri <barbieri@gmail.com>"
HOMEPAGE = "http://www.enlightenment.org"
# NOTE: Due to a bug in distutils, even if we don't use pyrex but cython,
# we need to build pyrex otherwise cython doesn't get called to build
# the extension modules.
DEPENDS = "python-cython-native python-pyrex-native python-numeric eina"
RDEPENDS += "python-lang"
PV = "0.3.1+svnr${SRCPV}"
PR = "ml0"

inherit setuptools

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/BINDINGS/python;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"

do_install_append() {
	if [ -e examples ]; then
		for i in `find examples -name "*.edc"`; do
			cd ${S}/`dirname $i`
			echo "Generating .edj file for $i..."
			edje_cc `basename $i`
			echo "Removing sources in this directory..."
			rm -f *.edc *.png *.ttf *.jpeg
		done
		cd ${S}
		install -d ${D}${datadir}/${PN}/
		cp -a examples ${D}${datadir}/${PN}/
		find ${D}${datadir}/${PN}/examples -name "CVS" | xargs rm -rf
		find ${D}${datadir}/${PN}/examples -name ".cvsignore" | xargs rm -f
	fi
}

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/*.egg/*/*/.debug"

PACKAGES += "${PN}-examples"
FILES_${PN}-examples = "${datadir}/${PN}/examples"
