require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_settings_security.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2"

# FILES plugins/application/libsecurity.so* bin/security apps/Settings/Security.desktop pics/security
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/

        for icon in Security.png lock.png multiauth.png sync.png users.png ownerinfo.png;
        do
            install -m 0644 ${WORKDIR}/pics/${APPNAME}/$icon ${D}${palmtopdir}/pics/${APPNAME}/
        done
}

