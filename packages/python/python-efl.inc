DESCRIPTION = "${PN} bindings"
LICENSE = "BSD"
AUTHOR = "Gustavo Sverzut Barbieri <barbieri@gmail.com>"
HOMEPAGE = "http://www.enlightenment.org"
# somewhere is a bug. cython should be self-contained, but somehow this
# does not compile unless pyrex has been built
DEPENDS = "python-cython-native python-pyrex-native python-numeric"
RDEPENDS += "python-lang"
PV = "0.1.1+cvs${SRCDATE}"

inherit setuptools

SRC_URI = "${E_CVS};module=e17/proto/python-efl/${PN}"
S = "${WORKDIR}/${PN}"

do_install_append() {
	if [ -e examples ]; then
		for i in `find examples -name "*.edc"`; do
			pushd `dirname $i`
			echo "Generating .edj file for $i..."
			edje_cc `basename $i`
			echo "Removing sources in this directory..."
			rm -f *.edc *.png *.ttf *.jpeg
			popd
		done
		install -d ${D}${datadir}/${PN}/
		cp -a examples ${D}${datadir}/${PN}/
		find ${D}${datadir}/${PN}/examples -name "CVS" | xargs rm -rf
		find ${D}${datadir}/${PN}/examples -name ".cvsignore" | xargs rm -f
	fi
}

FILES_${PN}-dbg += "${libdir}/${PYTHON_DIR}/site-packages/*.egg/*/*/.debug"

PACKAGES += "${PN}-examples"
FILES_${PN}-examples = "${datadir}/${PN}/examples"

