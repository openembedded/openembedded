require ${PN}.inc

PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_applets_vmemo.tar.bz2;name=split_core_applets_vmemo \
           http://sources.openembedded.org/opie-1.2.4-split_sounds.tar.bz2;name=split_sounds"
SRC_URI[split_core_applets_vmemo.md5sum] = "613fc8512d79c699eb88e83bba441a44"
SRC_URI[split_core_applets_vmemo.sha256sum] = "e28b5f02b34c352a1668364e2fbf171951a4cc2c1fd6796586b81074b4de875e"
SRC_URI[split_sounds.md5sum] = "eab6336ddc7a8b4db9fca94cef2485b1"
SRC_URI[split_sounds.sha256sum] = "a110602cd5013c6a406765f351a8484478617b2002377dd3c02a8bf450ca845f"

# FILES plugins/applets/libvmemoapplet.so sounds/vmemo*.wav
do_install() {
        install -d ${D}${palmtopdir}/sounds/
        install -m 0644 ${WORKDIR}/sounds/vmemo*.wav ${D}${palmtopdir}/sounds/
}

