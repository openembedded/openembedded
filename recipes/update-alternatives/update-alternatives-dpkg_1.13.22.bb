require update-alternatives-dpkg.inc

RPROVIDES_${PN} = "update-alternatives"
RDEPENDS_${PN} = "perl dpkg"

do_install () {
    install -d ${D}${sbindir} \
               ${D}${localstatedir}/dpkg/alternatives \
               ${D}${sysconfdir}/alternatives

    install -m 0755 scripts/update-alternatives ${D}${sbindir}/update-alternatives
}

SRC_URI[md5sum] = "0fc9fffc2c2cfa7107d8f422815078c1"
SRC_URI[sha256sum] = "c33aeb300d93eaeac55927ce81dc6f3a1cf74b3b759b65182c9bfca31b75b98f"
