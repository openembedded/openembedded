require ttf.inc

DESCRIPTION = "The Bitstream Vera fonts - TTF Edition"
LICENSE = "Bitstream Vera"
PR = "r6"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/ttf-bitstream-vera/1.10/ttf-bitstream-vera-${PV}.tar.bz2"

do_install () {
        install -d ${D}${prefix}/share/fonts/ttf/
        for i in *.ttf; do
                install -m 644 $i ${D}${prefix}/share/fonts/ttf/${i}
        done

	# fontconfig ships this too.  not sure what to do about it.
        #install -d ${D}${sysconfdir}/fonts
        #install -m 644 local.conf ${D}${sysconfdir}/fonts/local.conf


        install -d ${D}${prefix}/share/doc/${PN}/
        for i in *.TXT; do
                install -m 644 $i ${D}${prefix}/share/doc/${PN}/$i
        done
}

FILES_${PN} = "/etc ${datadir}/fonts"

SRC_URI[md5sum] = "bb22bd5b4675f5dbe17c6963d8c00ed6"
SRC_URI[sha256sum] = "db5b27df7bbb318036ebdb75acd3e98f1bd6eb6608fb70a67d478cd243d178dc"
