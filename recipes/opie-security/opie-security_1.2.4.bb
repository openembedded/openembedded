require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_settings_security.tar.bz2;name=split_core_settings_security \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_settings_security.md5sum] = "e1844ea1d259597ec6a9dc6f23461e47"
SRC_URI[split_core_settings_security.sha256sum] = "b8bd87ee9c82f7a8efde011555920f174e212d58620c4fa5f14f38f2e93ceb96"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"

# FILES plugins/application/libsecurity.so* bin/security apps/Settings/Security.desktop pics/security
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/

        for icon in Security.png lock.png multiauth.png sync.png users.png ownerinfo.png;
        do
            install -m 0644 ${WORKDIR}/pics/${APPNAME}/$icon ${D}${palmtopdir}/pics/${APPNAME}/
        done
}

