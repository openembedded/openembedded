DESCRIPTION = "Qt/Embedded Fonts Version ${PV}"
SECTION = "opie/fonts"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL QPL"
PR = "r0"

SRC_URI = "ftp://ftp.trolltech.com/pub/qt/source/qt-embedded-${PV}-free.tar.gz \
	   file://update-qtfontdir"
S = "${WORKDIR}/qt-${PV}"

do_configure() {
	:
}

do_compile() {
	:
}

pkg_postinst_fonts() {
#!/bin/sh
set -e
. /etc/profile
${sbindir}/update-qtfontdir
}

python populate_packages_prepend() {
	postinst = bb.data.getVar('pkg_postinst_fonts', d, 1)
	postrm = postinst
	pkgregex = "^([a-z]*_[0-9]*).*.qpf$"
	pkgpattern = "qte-font-%s"

        do_split_packages(d, root='/opt/QtPalmtop/lib/fonts', file_regex=pkgregex, output_pattern=pkgpattern, 
			  description='Qt/E font %s', postinst=postinst, postrm=postrm, recursive=True, hook=None, 
			  extra_depends='qte-font-common')
}

do_install() {
	install -d ${D}/${sbindir}/
	install -m 0755 ${WORKDIR}/update-qtfontdir ${D}/${sbindir}/
	install -d ${D}${palmqtdir}/lib/fonts/
	cp -a lib/fonts/* ${D}${palmqtdir}/lib/fonts/
}
