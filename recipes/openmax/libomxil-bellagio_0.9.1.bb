DESCRIPTION = "OpenMAX Integration Layer (IL) is a standard API to access Multimedia Components on mobile platforms. It has been defined by the Khronos group."
LICENSE = "LGPLv2"
DEPENDS = "alsa-lib ffmpeg \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad', d)}"

SRC_URI = "${SOURCEFORGE_MIRROR}/omxil/${PN}-${PV}.tar.gz"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} += "${libdir}/bellagio/*.so ${libdir}/bellagio/*.la"
FILES_${PN}-dev += "${libdir}/bellagio/*.a"
FILES_${PN}-dbg += "${libdir}/bellagio/.debug"


SRC_URI[md5sum] = "757371e21e4f3653ce4d12d3ba0be1e0"
SRC_URI[sha256sum] = "9a0864cd442c43e5b69072dc0617b56252bc933fce26f6bfd6d47909287a353a"
