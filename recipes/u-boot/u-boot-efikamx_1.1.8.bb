require u-boot.inc
PR ="r0"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.powerdeveloper.org/asset/by-id/89;name=uboot-efikamx \
          "
SRC_URI[uboot-efikamx.md5sum] = "072fbd97b293ac96d3f166e261c56131"
SRC_URI[uboot-efikamx.sha256sum] = "ee813d15e0e699340e5099641e01ac2952d42329d168deb48692a22a66d48965"

S = "${WORKDIR}/uboot-efikamx-${PV}"

python do_fetch () {
        import os,shutil
        bb.build.exec_func("base_do_fetch", d)
        if os.access(bb.data.expand("${DL_DIR}/89", d), os.R_OK):
                shutil.copy(bb.data.expand("${DL_DIR}/89", d), bb.data.expand("${DL_DIR}/${PN}-${PV}.tar.lzma", d))
}

python do_unpack () {
        bb.build.exec_func('efikamx_uboot_do_unpack', d)
}

efikamx_uboot_do_unpack (){
       (cd ${WORKDIR}; tar xf ${DL_DIR}/${PN}-${PV}.tar.lzma)
}
