require ttf.inc

DESCRIPTION = "Linux Libertine fonts - TTF Edition"
LICENSE = "OFL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/linuxlibertine/linuxlibertine/${PV}/LinLibertineFont-${PV}-2.tgz"
S = "${WORKDIR}/LinLibertine/Fonts"

do_install() {
	install -d ${D}${datadir}/fonts/ttf-linlibertine
	install -m 0644 *.ttf ${D}${datadir}/fonts/ttf-linlibertine/
}

python populate_packages_prepend() {
	plugindir = bb.data.expand('${datadir}/fonts/ttf-linlibertine/', d)
	do_split_packages(d, plugindir, '^(.*)\.ttf$', 'ttf-%s', 'TTF Font %s', extra_depends = "ttf-common")
}

SRC_URI[md5sum] = "789b4d8f0dd93b7234b7996e54a6a983"
SRC_URI[sha256sum] = "f11ff509b89b060953c8921bcaeab14256999083c2e01c7a23bc1cf1709d1dfa"

ALLOW_EMPTY_${PN} = "1"
RDEPENDS_${PN} = "\
  ttf-linbiolinum-bd-0.5.5 \
  ttf-linlibertine-bi-4.1.0 \
  ttf-linbiolinum-it-0.5.1 \
  ttf-linlibertine-c-4.0.4 \
  ttf-linbiolinum-kb-0.5.4 \ 
  ttf-linbiolinum-re-0.6.4 \
  ttf-linbiolinum-sl-0.4.9 \
  ttf-linlibertine-it-4.2.6 \
  ttf-linlibertine-bd-4.1.5 \
  ttf-linlibertine-re-4.7.5 \
"

