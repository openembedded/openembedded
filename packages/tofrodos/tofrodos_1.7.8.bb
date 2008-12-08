DESCRIPTION = "Tofrodos is a text file conversion utility that converts ASCII files between the MSDOS and unix format"
LICENSE = "GPLv2"

SRC_URI = "http://tofrodos.sourceforge.net/download/tofrodos-${PV}.tar.gz \
           file://cross.patch;patch=1;pnum=2"

S = "${WORKDIR}/${PN}/src"

do_install() {
	install -d ${D}/usr/man/man1
	install -d ${D}/${bindir}
	oe_runmake DESTDIR=${D} install
	cd ${D}/${bindir}
}

FILES_${PN} = "${bindir}/fromdos"

pkg_postinst_${PN} () {
#!/bin/sh
for app in dos2unix unix2dos todos ; do
    update-alternatives --install ${bindir}/$app $app fromdos 100
done
}

pkg_prerm_${PN} () {
 #!/bin/sh
for app in dos2unix unix2dos todos ; do
   update-alternatives --remove $app fromdos
done
}






