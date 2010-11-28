require ${PN}.inc

PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_vmemo.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_sounds.tar.bz2"

# FILES plugins/applets/libvmemoapplet.so sounds/vmemo*.wav
do_install() {
        install -d ${D}${palmtopdir}/sounds/
        install -m 0644 ${WORKDIR}/sounds/vmemo*.wav ${D}${palmtopdir}/sounds/
}

