DESCRIPTION = "Qt/Embedded 2 Auxilliary libraries"
HOMEPAGE = "http://opie.handhelds.org"
SECTION = "opie/libs"
PRIORITY = "optional"
LICENSE = "GPL"

INC_PR = "r2"

S = "${WORKDIR}/libqtaux"

inherit opie

do_compile() {
        oe_runmake MOC=${STAGING_BINDIR_NATIVE}/moc UIC=${STAGING_BINDIR_NATIVE}/uic DESTDIR=${S}
}

do_install() {
        install -d ${D}${includedir}/opie2
        for i in `find . -name "*.h"`
        do
                install -m 0644 $i ${D}${includedir}/opie2/`basename $i`
        done

        oe_libinstall -so libqtaux2 ${D}${libdir}
}
