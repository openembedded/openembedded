require ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/vmemo \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/sounds"

# FILES plugins/applets/libvmemoapplet.so sounds/vmemo*.wav
do_install() {
        install -d ${D}${palmtopdir}/sounds/
        install -m 0644 ${WORKDIR}/sounds/vmemo*.wav ${D}${palmtopdir}/sounds/
}

