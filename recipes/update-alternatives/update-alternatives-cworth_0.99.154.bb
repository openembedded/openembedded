require update-alternatives-cworth.inc

RPROVIDES_${PN} = "update-alternatives"

PR="${INC_PR}.0"

do_install () {
    install -d ${D}${sbindir} \
               ${D}${sysconfdir}/alternatives \
               ${D}${libdir}/opkg/alternatives

    install -m 0755 update-alternatives ${D}${sbindir}/update-alternatives
}

require ../opkg/update-alternatives-merge.inc
