DESCRIPTION = "OpenMAX Integration Layer (IL) is a standard API to access Multimedia Components on mobile platforms. It has been defined by the Khronos group."
LICENSE = "LGPLv2"
DEPENDS = "alsa-lib ffmpeg \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad', d)}"

PR = "r6"

SRC_URI = "${SOURCEFORGE_MIRROR}/omxil/${PN}-${PV}.tar.gz"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}


FILES_${PN} += "${libdir}/bellagio/*.so ${libdir}/bellagio/*.la"
FILES_${PN}-dev += "${libdir}/bellagio/*.a"
FILES_${PN}-dbg += "${libdir}/bellagio/.debug"


SRC_URI[md5sum] = "6d6b6a75bc8751a7421b5e739c53ef6e"
SRC_URI[sha256sum] = "07128710a699b453dcd7b92e33f2aa8dcbbfe0a657d33040803cdaf0997e442c"
