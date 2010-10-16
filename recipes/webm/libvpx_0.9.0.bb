require libvpx.inc

LICENSE = "VP8"

PR = "${INC_PR}.0"

SRC_URI[md5sum] = "9eb8e818d2f3263623c258fe66924082"
SRC_URI[sha256sum] = "a0096ac6859cfb61cf06dd9bc0a79a3333a4ec389ba311911d84df8ff2a1b9dc"

do_install() {
       oe_runmake install
       install -d ${D}${prefix}
       cp -R ${S}/vpx-vp8-nopost-nodocs*${PV}/* ${D}${prefix}/
       install -d ${D}${includedir}/vpx
       mv ${D}${includedir}/*.h ${D}${includedir}/vpx
}

