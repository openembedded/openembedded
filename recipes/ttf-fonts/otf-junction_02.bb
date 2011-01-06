require ttf.inc

DESCRIPTION = "Junction Fonts - OTF Edition"
LICENSE = "OFL"
PR = "r0"

SRC_URI = "http://www.linuxtogo.org/~mickeyl/misc/junction.zip"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${datadir}/fonts/${PN}
	install -m 0644 */*.otf ${D}${datadir}/fonts/${PN}/
}

SRC_URI[md5sum] = "fe26a1f85d7f367781e0f8764552dff7"
SRC_URI[sha256sum] = "cab8f3f546c49f2aae9855c252e898cb1951a50a5638080cc713d8987520b366"

FILES_${PN} += "${datadir}/fonts/${PN}/*.otf"

