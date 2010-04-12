require update-alternatives-dpkg.inc

RPROVIDES_${PN} = "update-alternatives"
RDEPENDS_${PN} = "perl dpkg"

do_install () {
    install -d ${D}${sbindir} \
               ${D}${localstatedir}/dpkg/alternatives \
               ${D}${sysconfdir}/alternatives

    install -m 0755 scripts/update-alternatives ${D}${sbindir}/update-alternatives
}

SRC_URI[md5sum] = "88effb358aa04d25036b662d588433a6"
SRC_URI[sha256sum] = "a525f321e875a8c16f5b6942bc02ac66b0d284cc6c61704f93e74789ef89d817"
