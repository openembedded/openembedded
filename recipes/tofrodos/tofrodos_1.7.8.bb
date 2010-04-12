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







SRC_URI[md5sum] = "aaa044f9817a048e126d9eb7a7535e96"
SRC_URI[sha256sum] = "e1d78226c5b54c0ce8e1c7de8bdd025aec6bf684960d5cee28310cf8dce48bb9"
