require update-alternatives-dpkg.inc

PR="r1"
RPROVIDES_${PN} = "update-alternatives"
RDEPENDS_${PN} = "perl dpkg"

do_install () {
    install -d ${D}${sbindir} \
               ${D}${localstatedir}/lib/dpkg/alternatives \
               ${D}${sysconfdir}/alternatives

    install -m 0755 scripts/update-alternatives ${D}${sbindir}/update-alternatives
}

SRC_URI[md5sum] = "4326172a959b5b6484b4bc126e9f628d"
SRC_URI[sha256sum] = "ea7ec1c861af43ba534a0d7997774a5f1fd4e25a7eea4ff229c9c7bf89aed633"
