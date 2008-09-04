require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/settings/security \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

# FILES plugins/application/libsecurity.so* bin/security apps/Settings/Security.desktop pics/security
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/

        for icon in Security.png lock.png multiauth.png sync.png users.png ownerinfo.png;
        do
            install -m 0644 ${WORKDIR}/pics/${APPNAME}/$icon ${D}${palmtopdir}/pics/${APPNAME}/
        done
}

