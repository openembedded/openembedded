DESCRIPTION = "Gstreamer scripts for Embedded Systems Conference workshop"
LICENSE = "Various"

SRC_URI = "http://downloads.sourceforge.net/project/showoff/esc_gst_scripts.tar.gz \
"
SRC_URI[md5sum] = "944f4ea58e81c3a32b947322ac8f9e1d"
SRC_URI[sha256sum] = "589c3b611406f255204e1993e470d0d69ac8f12ff479febf4d5dc92915f982da"

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
}

FILES_${PN} += "${datadir}/esc-gst"
