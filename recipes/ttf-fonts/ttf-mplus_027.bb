require ttf.inc

DESCRIPTION = "MPlus font - TTF Edition"
HOMEPAGE = "http://dejavu.sourceforge.net/wiki/"
LICENSE = "${PN}"
PR = "r0"

SRC_URI = "http://osdn.dl.sourceforge.jp/mplus-fonts/6650/mplus-TESTFLIGHT-${PV}.tar.gz"
S = "${WORKDIR}/mplus-TESTFLIGHT-${PV}"

python populate_packages_prepend() {
	plugindir = bb.data.expand('${datadir}/fonts/ttf-mplus/', d)
	do_split_packages(d, plugindir, '^(.*)\.ttf$', 'ttf-%s', 'TTF Font %s', extra_depends = "ttf-common")
}

do_install() {
	install -d ${D}${datadir}/fonts/ttf-mplus
	install -m 0644 *.ttf ${D}${datadir}/fonts/ttf-mplus/
}
