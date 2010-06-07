DESCRIPTION = "Gstreamer scripts for Embedded Systems Conference workshop"
LICENSE = "Various"

SRC_URI = "http://hivelocity.dl.sourceforge.net/project/showoff/esc_gst_scripts.tar.gz \
        file://README \
        file://a0 \
        file://c1 \
        file://n5 \
        file://a_gst.c \
"
SRC_URI[md5sum] = "4af79d2967dca3c649d3a644ddd4c604"
SRC_URI[sha256sum] = "d7b486520bf22a1e0bc9a808b1bf42f36a329d5a9f67ea6e0f3a25a9dfde2936"

S = "${WORKDIR}/esc-gst"

do_install() {
    ESC_FILES="a1 a2 a3 a4 a5 a6 d1 d2 d3 d4 d5 d6 g1 g2 g3 g4 g5 g6 g7 g8 g9"
    ESC_FILES="${ESC_FILES} n1 n2 n3 n4 p1 s v1 v2 v3 v4"
    install -d ${D}${datadir}/esc-gst
    for F in ${ESC_FILES} ; do
        install -m 0755 ${S}/${F} ${D}${datadir}/esc-gst
    done
    install -m 0644 ${S}/README ${D}${datadir}/esc-gst
    install -d ${D}${datadir}/applications
    install -m 0644 ${S}/GStreamer_Class.desktop ${D}${datadir}/applications/
    install -m 0644 ${WORKDIR}/README ${D}${datadir}/esc-gst
    install -m 0755 ${WORKDIR}/a0 ${D}${datadir}/esc-gst
    install -m 0755 ${WORKDIR}/c1 ${D}${datadir}/esc-gst
    install -m 0755 ${WORKDIR}/n5 ${D}${datadir}/esc-gst
    install -m 0644 ${WORKDIR}/a_gst.c ${D}${datadir}/esc-gst
}

FILES_${PN} += "${datadir}/esc-gst"
